// Get the modal
var modal = document.getElementById("myModal");
var modal_edit = document.getElementById("myModalEdit");

// Get the button that opens the modal
var btn = document.getElementById("myBtn");
//var btn_edit = document.getElementById("myBtnEdit");

// Get the <span> element that closes the modal
var btn_footer = document.getElementsByClassName("btn-close-footer")[0];
var btn_footer_edit = document.getElementsByClassName("btn-close-footer-edit")[0];

// When the user clicks the button, open the modal
btn.onclick = function() {
    modal.style.display = "block";
}

function modalEditShow(){
    modal_edit.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
btn_footer.onclick = function() {
    modal.style.display = "none";
}
btn_footer_edit.onclick = function() {
    modal_edit.style.display = "none";
}
// When the user clicks anywhere outside of the modal, close it
//window.onclick = function(event) {
//    if (event.target == modal) {
//        modal.style.display = "none";
//    }
//}

const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const id = urlParams.get("id");
if(id != null){
    document.getElementById("myModalEdit").style.display="block";
}