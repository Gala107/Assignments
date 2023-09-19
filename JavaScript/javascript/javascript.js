function validateMeeting() {
    // Validate that date is starting today and going into the future.
    let meetingDate = document.getElementById("meetingDate");

    const dateExp = /^[0-9]{4}\-[0-9]{2}-[0-9]{2}$/;
    if (!dateExp.test(meetingDate.value)) {
        alert("Please select meeting date.");
        meetingDate.focus();
        return false;
    }
// need to work on the code below
    var today = new Date().getTime();
    var meetingD = new Date(meetingDate).getTime();
    alert((today - meetingD) > 0);
    return true;
}

function validateClient() {  
    // Validate that first name contains only letters.
    const firstNameExp = /^[a-zA-Z]+$/;

    // Validate that last name contains only letters and 
    // possibly a space, hyphen or apostrophe.
    // Ex. Last names like: Van Duck, Small-Mighty, O'Connell.
    const lastNameExp = /^[a-zA-Z]+[' -]?[a-zA-Z]*$/;

    // Validate that email starts with letters, digits, underscores, hyphens, or periods,
    // proceeds with '@', continues with another set of the first part characters, period
    // and ends with the top level domain like 'com' taking 2 to 4 characters.
    const emailExp = /^[\w-\.]+@[\w-]+\.[\w-]{2,4}$/;

    let firstName = document.getElementById("firstName");
    let lastName = document.getElementById("lastName");
    let email = document.getElementById("email");
 
    if(!firstNameExp.test(firstName.value)){
        alert("Please enter your first name.");
        firstName.focus();
        return false;
    }
    if(!lastNameExp.test(lastName.value)){
        alert("Please enter your last name.");
        lastName.focus();
        return false;
    }
    if(!emailExp.test(email.value)){
        alert("Please enter your email.");
        email.focus();
        return false;
    }
    return true;   
}
