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

function registerUser() {
    if (!hasError) {
        let userObject = {};
        userObject.email = $('#email').val();
        userObject.userName = $('#username').val();
        userObject.password = $('#password').val();
        userObject.state = $('#state option:selected').text();
        userObject.country = "US"; //Add country ui elemen;
        userObject.street = $('#street').val();
        userObject.city = $('#city').val();
        userObject.gender = $('#gender option:selected').text();
        userObject.status = "ACTIVE";
        userObject.zipCode = $('#zipcode').val();

        console.log("object "+userObject);
        console.log(JSON.stringify(userObject));

        $.post('registerServlet', {
            data: JSON.stringify(userObject),
            success: function(data) {},
            dataType:'json',
            error: function(xhr, status) {
                console.log("Failed to add user.")
                console.log(status);
                console.log(xhr);
            }
        })
    } else {
        //Show appropriate error message.
        console.log("Error registering")
    }
}

function verifyPassword() {
    let password = $('#password').val();
    let confirmPassword = $('#confirmPassword').val();
    hasError = password !== confirmPassword;

}