(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-1fea3a92"],{"8a3f":function(t,e,n){"use strict";n("e6d9")},9901:function(t,e,n){"use strict";n.r(e);var o=n("7a23"),c=n("428c"),r=n.n(c),a=function(t){return Object(o["I"])("data-v-182d5c30"),t=t(),Object(o["G"])(),t},i=a((function(){return Object(o["i"])("div",{class:"d-block",style:{"background-color":"rgb(33 37 41)"}},[Object(o["i"])("img",{src:r.a,alt:"",style:{height:"12rem"}})],-1)})),u={style:{width:"50%",margin:"6rem auto","background-color":"rgb(33 37 41)",padding:"2rem","border-radius":"20px"}},s=a((function(){return Object(o["i"])("h1",{style:{color:"white"}},"Account successesfuly activated!",-1)})),l=a((function(){return Object(o["i"])("h4",{style:{color:"white",margin:"4rem 0"}}," You have activated your account, now you can log in into Angler and start looking for your perfect vacation! ",-1)}));function d(t,e,n,c,r,a){return Object(o["F"])(),Object(o["h"])(o["a"],null,[i,Object(o["i"])("div",u,[s,l,Object(o["i"])("button",{class:"btn btn-outline-primary",onClick:e[0]||(e[0]=function(){return a.btnClick&&a.btnClick.apply(a,arguments)})}," Go to site! ")])],64)}var b=n("bc3a"),f=n.n(b);f.a.defaults.baseURL="https://fishing-adventure-website-back.herokuapp.com";var h={name:"ConfirmToken",mounted:function(){f.a.get("/auth/confirm-account?token="+this.$route.query.token,{headers:{"Access-Control-Allow-Origin":"https://fishing-adventure-website-back.herokuapp.com",Authorization:"Bearer "+localStorage.refreshToken}}).then()},methods:{btnClick:function(){window.location.href="/"}}},k=(n("8a3f"),n("6b0d")),p=n.n(k);const g=p()(h,[["render",d],["__scopeId","data-v-182d5c30"]]);e["default"]=g},e6d9:function(t,e,n){}}]);
//# sourceMappingURL=chunk-1fea3a92.9a02a9ad.js.map