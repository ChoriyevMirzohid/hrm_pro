
function importEmpModal(){
    let importEmpModal = document.getElementById("importEmpModal");
    importEmpModal.style.display = "block";
}
function closeImportEmpModal(){
    let importEmpModal = document.getElementById("importEmpModal");
    importEmpModal.style.display = "none";
}


function createEmpModal(){
    let importEmpModal = document.getElementById("createEmpModal");
    importEmpModal.style.display = "block";
}
function closeCreateEmpModal(){
    let importEmpModal = document.getElementById("createEmpModal");
    importEmpModal.style.display = "none";
}

function seeInfo(str){
    let seeModal = document.getElementById("seeModal");
    document.getElementById("see-data-item").innerHTML='';
    seeModal.style.display="block";
    if (str!==''){
        document.getElementById("see-data-item").innerHTML=str;
    }
}
function footerSeeHide(){
    let seeModal = document.getElementById("seeModal");
    seeModal.style.display="none";
}

function showModal(){
    let modal = document.getElementById("myModal");
    modal.style.display="block";
}
function hideModal(){
    let modal = document.getElementById("myModal");
    modal.style.display="none";
}
function exportShowModal(){
    let exportModal = document.getElementById("exportModal");
    exportModal.style.display="block";
}
function exportHideModal(){
    let exportModal = document.getElementById("exportModal");
    exportModal.style.display="none";
}

function createUserRegModal(){
    let importEmpModal = document.getElementById("userRegModal");
    importEmpModal.style.display = "block";
}
function hideCreateUserRegModal(){
    let modal = document.getElementById("userRegModal");
    modal.style.display="none";
}
