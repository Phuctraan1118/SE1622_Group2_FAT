function windowScroll(){const e=document.getElementById("navbar");document.body.scrollTop>=50||document.documentElement.scrollTop>=50?e.classList.add("nav-sticky"):e.classList.remove("nav-sticky")}window.addEventListener("scroll",(e=>{e.preventDefault(),windowScroll()}));var scroll=new SmoothScroll("#navbar-navlist a",{speed:300,offset:60}),spy=new Gumshoe("#navbar-navlist a",{navClass:"active",contentClass:"active",offset:70});function validateForm(){var e=document.forms.myForm.name.value,t=document.forms.myForm.email.value,n=document.forms.myForm.subject.value,s=document.forms.myForm.comments.value;if(document.getElementById("error-msg").style.opacity=0,document.getElementById("error-msg").innerHTML="",""==e||null==e)return document.getElementById("error-msg").innerHTML="<div class='alert alert-warning'>*Please enter a Name*</div>",fadeIn(),!1;if(""==t||null==t)return document.getElementById("error-msg").innerHTML="<div class='alert alert-warning'>*Please enter a Email*</div>",fadeIn(),!1;if(""==n||null==n)return document.getElementById("error-msg").innerHTML="<div class='alert alert-warning'>*Please enter a Subject*</div>",fadeIn(),!1;if(""==s||null==s)return document.getElementById("error-msg").innerHTML="<div class='alert alert-warning'>*Please enter a Comments*</div>",fadeIn(),!1;var r=new XMLHttpRequest;return r.onreadystatechange=function(){4==this.readyState&&200==this.status&&(document.getElementById("simple-msg").innerHTML=this.responseText,document.forms.myForm.name.value="",document.forms.myForm.email.value="",document.forms.myForm.subject.value="",document.forms.myForm.comments.value="")},r.open("POST","php/contact.php",!0),r.setRequestHeader("Content-type","application/x-www-form-urlencoded"),r.send("name="+e+"&email="+t+"&subject="+n+"&comments="+s),!1}function fadeIn(){var e=document.getElementById("error-msg"),t=0,n=setInterval((function(){t<1?(t+=.5,e.style.opacity=t):clearInterval(n)}),200)}var TxtType=function(e,t,n){this.toRotate=t,this.el=e,this.loopNum=0,this.period=parseInt(n,10)||2e3,this.txt="",this.tick(),this.isDeleting=!1};function typewrite(){if("undefined"===n)changeText();else var e=document.getElementsByClassName("typewrite");for(var t=0;t<e.length;t++){var n=e[t].getAttribute("data-type"),s=e[t].getAttribute("data-period");n&&new TxtType(e[t],JSON.parse(n),s)}var r=document.createElement("style");r.type="text/css",r.innerHTML=".typewrite > .wrap { border-right: 0.08em solid #ffffff}",document.body.appendChild(r)}TxtType.prototype.tick=function(){var e=this.loopNum%this.toRotate.length,t=this.toRotate[e];this.isDeleting?this.txt=t.substring(0,this.txt.length-1):this.txt=t.substring(0,this.txt.length+1),this.el.innerHTML='<span class="wrap">'+this.txt+"</span>";var n=this,s=200-100*Math.random();this.isDeleting&&(s/=2),this.isDeleting||this.txt!==t?this.isDeleting&&""===this.txt&&(this.isDeleting=!1,this.loopNum++,s=500):(s=this.period,this.isDeleting=!0),setTimeout((function(){n.tick()}),s)},window.onload(typewrite());

let prism = document.querySelector(".rec-prism");

function showSignup(){
  prism.style.transform = "translateZ(-100px) rotateY( -90deg)";
}
function showLogin(){
  prism.style.transform = "translateZ(-100px)";
}
function showForgotPassword(){
  prism.style.transform = "translateZ(-100px) rotateY( -180deg)";
}

function showSubscribe(){
  prism.style.transform = "translateZ(-100px) rotateX( -90deg)";
}

function showContactUs(){
  prism.style.transform = "translateZ(-100px) rotateY( 90deg)";
}

function showThankYou(){
  prism.style.transform = "translateZ(-100px) rotateX( 90deg)";
}