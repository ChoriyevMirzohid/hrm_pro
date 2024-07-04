
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

function itemForwardDirectorate(id){
    window.location.href='/bank-directorate-item/'+id;
}

function itemForwardDepartment(id){
    window.location.href='/bank-department-item/'+id;
}

function itemForwardUserAccess(id){
    window.location.href='/user-access-module/'+id;
}

function empInfoChangeAccess(){
    let x = document.getElementById("changeEmpAccess").checked;
    if (x){
        document.getElementById("changeEmpAccessBtn").disabled = false;
        document.getElementById("block_id").style.display='block';
        document.getElementById("direct_id").style.display='block';
        document.getElementById("depart_id").style.display='block';
        document.getElementById("position_id").style.display='block';
        document.getElementById("level_id").style.display='block';

        document.getElementById("emp-block").style.display='none';
        document.getElementById("emp-direct").style.display='none';
        document.getElementById("emp-dep").style.display='none';
        document.getElementById("emp-position").style.display='none';
        document.getElementById("emp-level").style.display='none';
    }else{
        document.getElementById("changeEmpAccessBtn").disabled = true;

        document.getElementById("block_id").style.display='none';
        document.getElementById("direct_id").style.display='none';
        document.getElementById("depart_id").style.display='none';
        document.getElementById("position_id").style.display='none';
        document.getElementById("level_id").style.display='none';

        document.getElementById("emp-block").style.display='block';
        document.getElementById("emp-direct").style.display='block';
        document.getElementById("emp-dep").style.display='block';
        document.getElementById("emp-position").style.display='block';
        document.getElementById("emp-level").style.display='block';
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