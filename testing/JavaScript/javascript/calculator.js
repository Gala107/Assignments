function compute(operation){
    let num1 = document.getElementById("number1").value;
    let num2 = document.getElementById("number2").value;
    if (num1 == "" || num2 == "") {
        alert("Both numbers have to be entered.\nThank you!");
        return;
    }

    let resultElem = document.getElementById("result");
    if ("add" == operation){
        resultElem.value = eval(num1) + +(num2);
    } else if ("sub" == operation){
        resultElem.value = num1 - num2;
    } else if ("mul" == operation){
        resultElem.value = num1 * num2;
    } else if ("div" == operation){
        resultElem.value = num1 / num2;
    }

    document.getElementById("number1").value = "";
    document.getElementById("number2").value = "";
}

function reset(){
    document.getElementById("result").value = "";
    document.getElementById("number1").value = "";
    document.getElementById("number2").value = "";
}
