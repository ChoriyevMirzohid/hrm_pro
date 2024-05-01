// Get the modal
var modal = document.getElementById("myModal");
var seeModal = document.getElementById("seeModal");

// Get the button that opens the modal
var btn = document.getElementById("myBtn");
var seeBtn = document.getElementById("seeBtn");
//var btn_edit = document.getElementById("myBtnEdit");

// Get the <span> element that closes the modal
var btn_footer = document.getElementsByClassName("btn-close-footer")[0];
var btn_footer_see = document.getElementsByClassName("btn-close-footer-see");

// When the user clicks the button, open the modal
btn.onclick = function() {
    modal.style.display = "block";
}

function footerSee(){
    seeModal.style.display='none';
}
// When the user clicks on <span> (x), close the modal
btn_footer.onclick = function() {
    modal.style.display = "none";
}
btn_footer_see.onclick = function() {
    seeModal.style.display = "none";
}

function seeInfoClick(){
    const seeBtnInfo = document.getElementById("emp_id");
    const dataItem = document.getElementById("emp_id").innerHTML;
    console.log(dataItem);
    seeBtnInfo.addEventListener('click', seeInfo(dataItem));
}
function seeInfo(str){
    seeModal.style.display="block";
    if (str!==''){
        document.getElementById("see-data-item").innerHTML=str;
    }else{
        document.getElementById("see-data-item").innerHTML="No data found";
    }
}
