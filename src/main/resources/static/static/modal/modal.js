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

function seeInfo(key, text){
    seeModal.style.display="block";
    document.getElementById("see-data-item").innerHTML=text;
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

// When the user clicks anywhere outside of the modal, close it
//window.onclick = function(event) {
//    if (event.target == modal) {
//        modal.style.display = "none";
//    }
//}