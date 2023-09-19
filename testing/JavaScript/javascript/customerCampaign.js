// function changeParagraph(textColor) {
//     paragraph.style.color = textColor;
//     sentence.style.color = textColor;
// }
function changeParagraph(textColor) {
    document.getElementById("paragraph").style.color = textColor;
    document.getElementById("sentence").style.color = textColor;
}
function changeSentence() {
    document.getElementById("sentence").style.color = "blue"; 
}
function thankCustomer() {
    alert("Thank you for reading the paragraph!");
}