
document.querySelector(".paging-select-drop-btn").addEventListener("click", () => {
    var a = document.querySelector(".paging-drop-ul").style.display;
    if (a === "block"){
        document.querySelector(".paging-drop-ul").style.display="none";
    }else{
        document.querySelector(".paging-drop-ul").style.display="block";
    }
});

function itemForwardEmp(id){
    window.location.href='/bank-emp/'+id;
}

function itemForwardUserAccess(id){
    window.location.href='/user-access-module/'+id;
}

function empInfoChangeAccess(){
    let x = document.getElementById("changeEmpAccess").checked;
    if (x){
        document.getElementById("changeEmpAccessBtn").disabled = false;
    }else{
        document.getElementById("changeEmpAccessBtn").disabled = true;
    }
}

function checkedEmpId(id){
    const checkEmpArray = [];
    let btn = document.getElementById("exportEmpBtn");
    let empBtnChecks = document.querySelectorAll(".data-checkbox");
    let empIdValues = document.querySelectorAll(".see-text-id");

    for (let i = 0, len = empBtnChecks.length; i < len; i++) {
        if (empBtnChecks[i].checked){
            checkEmpArray.push(empIdValues[i].innerHTML);
        }
    }

    if (checkEmpArray.length > 0){
        btn.disabled=false;
    }else{
        btn.disabled=true;
    }
}

function bankEmpExportDoc(){
    const checkEmpArray = [];
    let empBtnChecks = document.querySelectorAll(".data-checkbox");
    let empIdValues = document.querySelectorAll(".see-text-id");

    for (let i = 0, len = empBtnChecks.length; i < len; i++) {
        if (empBtnChecks[i].checked){
            checkEmpArray.push(empIdValues[i].innerHTML);
        }
    }
    window.location.href="/bank-emp/export/" + checkEmpArray;
}