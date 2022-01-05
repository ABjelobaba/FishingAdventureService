package isa.FishingAdventure.service;

import isa.FishingAdventure.model.AdditionalService;
import isa.FishingAdventure.model.Appointment;
import isa.FishingAdventure.model.ServiceProfile;
import isa.FishingAdventure.model.User;
import isa.FishingAdventure.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private ServiceProfileService serviceProfileService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private EmailService emailService;

    public Appointment save(Appointment newAppointment) {
        return appointmentRepository.save(newAppointment);
    }

    public void addAppointmentToServiceProfile(Integer id, Appointment newAppointment) {
        ServiceProfile profile = serviceProfileService.getById(id);
        profile.getAppointments().add(newAppointment);
        serviceProfileService.save(profile);
    }

    public Integer createAppointment(Appointment newAppointment, Integer serviceProfileId) throws InterruptedException, MessagingException {
        Appointment savedAppointment = save(newAppointment);
        addAppointmentToServiceProfile(serviceProfileId, newAppointment);
        ServiceProfile serviceProfile = serviceProfileService.getById(serviceProfileId);
        List<User> clients = clientService.getClientSubscribedToServiceProfile(serviceProfileId);

        for (User client : clients) {
            String emailText = createEmail(client, newAppointment, serviceProfile);
            emailService.sendEmail(client.getEmail(), "New offer for " + serviceProfile.getName(), emailText);
        }
        return savedAppointment.getAppointmentId();
    }

    private String createEmail(User client, Appointment newAppointment, ServiceProfile serviceProfile) {
        StringBuilder content = new StringBuilder();
        content.append(client.getName()).append(" ").append(client.getSurname()).append(" you are subscribed to get notifications about new offers!\n");
        content.append("New offer for ").append(serviceProfile.getName()).append("\n");
        content.append("Location: ").append(newAppointment.getPlace());
        content.append("Offer will be active starting from ").append(newAppointment.getStartDate());
        content.append("to ").append(newAppointment.getEndDate()).append("\n");
        content.append("Number of persons is limited to ").append(newAppointment.getMaxPersons()).append("\n");
        content.append("Services included:\n");
        for (AdditionalService as : newAppointment.getChosenServices()) {
            content.append("\t").append(as.getName()).append(" ").append(as.getPrice()).append("$\n");
        }
        content.append("Price per day will be ").append(newAppointment.getPrice()).append("$");
        content.append("which means you can get ").append(newAppointment.getDiscount()).append("% off your reservation.\n");
        content.append("For more information about offer, please click <a href='http://localhost:8081/cottage/?id=").append(serviceProfile.getId()).append("'>here.</a>\n");
        content.append("Sincerely,\n").append("Angler");

        return content.toString();
    }
}
