function unlivePost(postId) {
    $.ajax('censoredPostServlet?postId=' + postId, {
        type: 'DELETE'
    })
        .done(reload)
        .fail(function () {
            console.log("Failed to delete post");
        })
}

function livePost(postId) {
    $.ajax('censoredPostServlet?postId=' + postId, {
        type: 'PUT'
    })
        .done(reload)
        .fail(function () {
            console.log("Failed to update post");
        })
}

function reload() {
    window.location.href = 'censoredPostServlet';
}