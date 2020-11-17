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
    $('#alert-section').css('display', 'none');
    $('#next-btn').prop('disabled', false);
}

function onEmailFailure() {
    $('#alert-section')
        .css('display', 'block')
        .text('The email is already used. Please change to another email.')
        .addClass(' alert-danger')

    $('#next-btn').prop('disabled', true);
}

function verifyPassword() {
    let password = $('#password').val();
    let confirmPassword = $('#confirmPassword').val();
    let passwordsMatch = confirmPassword === password;

    if (!passwordsMatch) {
        $('#alert-section')
            .css('display', 'block')
            .text('Please make sure passwords match')
            .addClass(' alert-danger')

        $('#next-btn').prop('disabled', true);
    } else {
        $('#alert-section').css('display', 'none');
        $('#next-btn').prop('disabled', false);
    }
}

function matchPassword() {
    let pattern = "^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$";
    let regex = new RegExp(pattern);
    let password = $('#password').val();

    if (!regex.test(password)) {
        $('#alert-section')
            .css('display', 'block')
            .text('Please make sure has 6 characters including a number and an upper case character')
            .addClass(' alert-danger')

        $('#next-btn').prop('disabled', true);
    } else {
        $('#alert-section').css('display', 'none');
        $('#next-btn').prop('disabled', false);
    }
}