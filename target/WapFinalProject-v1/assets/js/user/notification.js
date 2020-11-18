$(document).ready(function() {
    fetchNotifications();
})

function fetchNotifications() {
    $.get('notificationServlet', {}).done(function(data) {
        $('#notification-count').text(data.length);
        for (let i = 0; i < data.length; i++) {
            console.log(data[i]);
            let slicedText = data[i].postSummary.slice(0, 10);
            let fullName = data[i].posterFullName;
            $('#notification-list').append('<a class="dropdown-item"> By: '+fullName+' '+slicedText+'</a>');
        }
     })
}