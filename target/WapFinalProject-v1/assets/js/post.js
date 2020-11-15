function makePost() {
    let post = $('#post').val();

    $.post('postServlet', {
        postImage: 'url to image',
        postDescription: post,
        likes: 0
    }).done(function(data) {
        console.log("the data "+data);
    }).fail(function() {
        console.log("failed.");
    });
}

function saveComment(postId) {
    let comment = $('#comment').val();

    $.post('commentServlet', {
        postId: postId,
        comment: comment
    }).done(function(data) {
        console.log("the data "+data);
    }).fail(function() {
        console.log("failed.");
    });
}

function getComments(postId) {
    $.get('commentServlet', {
        postId: postId
    }).done(function(data) {
        for (let i = 0; i < data.length; i++) {
            $('ul.comments').append('<li id='+data[i].commentId+'>'+data[i].comment+'</li>')
            console.log(data[i].comment +" "+data[i].fullName);
        }
    }).fail(function() {
        console.log("Failed to get comments");
    });
}

function getPost() {
    $.get('postServlet').done(function(data) {
        for (let i = 0; i < data.length; i++) {
            $('ul.post').append('<li>'+data[i].description+'</li>')
            console.log(data[i]);
        }
    }).fail(function() {
        console.log("Failed to get comments");
    });
}

function updateProfile() {
    $.post('profileServlet', {
        'email': '',
        'userName': '',
        'gender': '',
        'fullName': '',
        'state': '',
        'city': '',
        'street': '',
        'zipCode':''
    }).done(function(data) {
        if (data === 'success') {
            console.log("Show success");
        } else {
            console.log("show failed");
        }
    })
}

function deactivateUser() {
    $.post('statusServlet', {
        activate: false
    }).done(function(data) {
        console.log("Deactivated "+data);
    }).fail(function() {
        console.log("failed");
    });
}

function activateUser() {
    $.post('statusServlet', {
        activate: true
    }).done(function(data) {
        console.log(data);
    }).fail(function() {
        console.log("failed");
    });
}

function searchPost() {
    let query = $('#postSearch').val();

    $.get('postServlet', {
        query: query
    }).done(function(data) {
        for (let i = 0; i < data.length; i++) {
            console.log(data[i]);
        }
    }).fail(function() {
        console.log("Ekintu kiganye.")
    })
}

function searchUser() {
    let query = $('#userSearch').val();

    $.get('searchUserServlet', {
        query: query
    }).done(function(data) {
        for (let i = 0; i < data.length; i++) {
            console.log(data[i]);
        }
    }).fail(function() {
        console.log("Ekintu kiganye.")
    })
}

function deleteComment(commentId, postId) {

}