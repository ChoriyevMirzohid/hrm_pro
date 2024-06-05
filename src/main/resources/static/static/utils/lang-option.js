
if (localStorage.getItem("sys_lang") == null){
    document.getElementById("current_lang").innerHTML="UZB";
}else{
    document.getElementById("current_lang").innerHTML=
        localStorage.getItem("sys_lang");
}
function setLang(lang) {
    localStorage.setItem("sys_lang", lang);
    document.getElementById("current_lang").innerHTML=
        localStorage.getItem("sys_lang");
    window.location.reload();
}
