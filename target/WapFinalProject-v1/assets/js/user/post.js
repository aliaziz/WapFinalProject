$(document).ready(function () {
    $('#btnSubmit').click(function (event) {
        event.preventDefault();
        makePost();
    })
})

function makePost() {
    let formId = $('#postUploadForm')[0];
    let formData = new FormData(formId);
    formData.append("postLat", '43.0');
    formData.append("postLon", '45.0');
    formData.append("likes", "0");

    $.ajax({
        type: "POST",
        enctype: "multipart/form-data",
        url: 'postServlet',
        data: formData,
        processData: false,
        contentType: false,
        cache: false,
        success: function (data) {
            console.log("the data " + data);
        },
        error: function () {
            console.log("failed.");
        }
    });
}

function saveComment(postId) {
    let comment = $('#comment').val();

    $.post('commentServlet', {
        postId: postId,
        comment: comment
    }).done(function (data) {
        console.log("the data " + data);
    }).fail(function () {
        console.log("failed.");
    });
}

function getComments(postId) {
    $.get('commentServlet', {
        postId: postId
    }).done(function (data) {
        for (let i = 0; i < data.length; i++) {
            console.log(data[i].comment + " " + data[i].fullName);
        }
    }).fail(function () {
        console.log("Failed to get comments");
    });
}

function getPost() {
    $.get('postServlet').done(function (data) {
        for (let i = 0; i < data.length; i++) {
            console.log(data[i]);
        }
    }).fail(function () {
        console.log("Failed to get comments");
    });
}

function searchPost() {
    let query = $('#postSearch').val();

    $.get('postServlet', {
        query: query
    }).done(function (data) {
        for (let i = 0; i < data.length; i++) {
            console.log(data[i]);
        }
    }).fail(function () {
        console.log("Ekintu kiganye.")
    })
}

function searchUser() {
    let query = $('#userSearch').val();

    $.get('searchUserServlet', {
        query: query
    }).done(function (data) {
        for (let i = 0; i < data.length; i++) {
            console.log(data[i]);
        }
    }).fail(function () {
        console.log("Ekintu kiganye.")
    })
}

function deleteComment(commentId, postId) {
    $.delete('commentServlet', {
        commentId: commentId,
        postId: postId
    }).done(function (data) {
    })
        .fail(function () {
        });
}

function deletePost(postId) {
    $.delete('postServlet', {
        postId: postId
    }).done(function (data) {
    })
        .fail(function () {
        });
}

function likePost(postId) {
    $.get('likeServlet', {
        'should_like': true,
        'postId': '1'
    }).done(function (data) {
        console.log(data);
    }).fail(function () {
        console.log("Failed");
    })
}

function unlikePost(postId) {
    $.get('likeServlet', {
        'should_like': false,
        'postId': '1'
    }).done(function (data) {
        console.log(data);
    }).fail(function () {
        console.log("Failed");
    })
}