$(document).ready(function () {
    $('#updateProfileBtn').click(function (event) {
        event.preventDefault();
        updateProfile();
    })
})

function updateProfile() {
    let email = $("#email").val();
    let userName = $("#username").val();
    let gender = $("#gender").val();
    let fullName = $("#fullname").val();
    let state = $("#state").val();
    let city = $("#city").val();
    let street = $("#street").val();
    let zipCode = $("#zipcode").val();

    console.log(email);

    $.post('profileServlet', {
        'email': email,
        'userName': userName,
        'gender': gender,
        'fullName': fullName,
        'state': state,
        'city': city,
        'street': street,
        'zipCode':zipCode
    }).done(function (data) {
        if (data === 'success') {
            alert("Profile Updated");
        } else {
            alert("Profile NOT Updated");
        }
    })
}

function deactivateUser() {
    let boolean = confirm("Are you sure you want to deactivate your account?");

    if (boolean) {
        $.post('statusServlet', {
            activate: false
        }).done(function (data) {
            window.location.href = '../auth/login.jsp';
        }).fail(function () {
            console.log("failed");
        });
    }
}

function activateUser(email) {
    $.post('statusServlet', {
        activate: true,
        email: email,
    }).done(function (data) {
        window.location.href = 'disabledUserServlet';
    }).fail(function () {
        console.log("failed");
    });
}