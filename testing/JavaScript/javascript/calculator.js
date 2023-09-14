function compute(operation){
    let num1 = document.getElementById("number1").value;
    let num2 = document.getElementById("number2").value;

    if (num1 == "" || num2 == "") {
        alert("Both numbers have to be entered.\nThank you!");
        return;
    }

    if ("add" == operation){
        document.getElementById("result").value = +num1 + +num2;
    } else if ("sub" == operation){
        document.getElementById("result").value = num1 - num2;
    } else if ("mul" == operation){
        document.getElementById("result").value = num1 * num2;
    } else if ("div" == operation){
        document.getElementById("result").value = num1 / num2;
    }

    document.getElementById("number1").value = "";
    document.getElementById("number2").value = "";
}

function clearResult(){
    document.getElementById("result").value = "";
}
