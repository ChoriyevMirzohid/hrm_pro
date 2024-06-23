function checkStatus(){
    let a = document.querySelector(".note-value").innerHTML;
    localStorage.setItem("noteStatus", a);
}

if (localStorage.getItem("noteStatus")){
    setTimeout(function (){
        document.querySelector(".note").style.display = "none";
        localStorage.removeItem("noteStatus");
    }, 3000)
}
