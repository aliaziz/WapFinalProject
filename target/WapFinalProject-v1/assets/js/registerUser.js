let hasError = true;

function validateEmail() {
    let userEmail = $('#email').val();
    if (userEmail !== '') {
        $.get('checkEmailServlet', {
            'email': userEmail
        }).done(onEmailSuccess).fail(onEmailFailure);
    }
}

function onEmailSuccess(data) {
    console.log("Succeeded " + data);
    hasError = false;
    // Remove error message.
}

function onEmailFailure() {
    console.log("email name already exists");
    hasError = true;
    //Show error message.
}

function verifyPassword() {
    let password = $('#password').val();
    let confirmPassword = $('#confirmPassword').val();
    hasError = password !== confirmPassword;

}