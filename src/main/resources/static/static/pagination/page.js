
document.querySelector(".paging-select-drop-btn").addEventListener("click", () => {
    var a = document.querySelector(".paging-drop-ul").style.display;
    if (a === "block"){
        document.querySelector(".paging-drop-ul").style.display="none";
    }else{
        document.querySelector(".paging-drop-ul").style.display="block";
    }
});