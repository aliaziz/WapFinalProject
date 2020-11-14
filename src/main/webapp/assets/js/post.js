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

function makeComment() {
    let postId = $('#post_id').val();
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