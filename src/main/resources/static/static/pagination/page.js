
document.querySelector(".paging-select-drop-btn").addEventListener("click", () => {
    var a = document.querySelector(".paging-drop-ul").style.display;
    if (a === "block"){
        document.querySelector(".paging-drop-ul").style.display="none";
    }else{
        document.querySelector(".paging-drop-ul").style.display="block";
    }
});

function itemForwardEmployee(id){
    window.location.href='/bank-employee/'+id;
}

function empInfoChangeAccess(){
    let x = document.getElementById("changeEmpAccess").checked;
    if (x){
        document.getElementById("changeEmpAccessBtn").disabled = false;
    }else{
        document.getElementById("changeEmpAccessBtn").disabled = true;
    }
}