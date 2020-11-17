let currentLatitude;
let currentLongitude;

$(document).ready(function () {
    $('#postForm').click(function (event) {
        event.preventDefault();
        makePost();
    })

    $('#search-btn').click(function (event) {
        event.preventDefault();
        let currentUrl = window.location.pathname;
        if (currentUrl.indexOf("suggestions") >= 0) searchUser();
        else searchPost();
    })

    navigator.geolocation.getCurrentPosition(position => {
        currentLatitude = "" + position.coords.latitude;
        currentLongitude = "" + position.coords.longitude;
    }, () => {
        alert("Your location is not shared. The system shall default to your profile location");
    });

    getPosts();
})

function saveComment(postId) {
    let comment = prompt("Enter comment about the post");
    if (comment !== '') {
        $.post('commentServlet', {
            postId: postId,
            comment: comment
        }).done(function (data) {
            alert("Comment added!");
        }).fail(function () {
            alert("Comment not added!");
        });
    }
}

function getComments(postId) {
    let divId = $('#post-' + postId);
    $(divId).empty();

    $.get('commentServlet', {
        postId: postId
    }).done(function (data) {
        for (let i = 0; i < data.length; i++) {
            $(divId).append(buildComment(data[i]));
        }
    }).fail(function () {
        console.log("Failed to get comments");
    });
}

function deleteComment(commentId, postId) {
    $.ajax('commentServlet?commentId='+commentId+'&postId='+postId, {
        type: 'DELETE'
    }).done(function (data) {
        getComments(postId)
        alert("Comment deleted!");
    }).fail(function () {
        alert("You can only delete your own comments!");
    });
}

function makePost() {
    let formId = $('#postUploadForm')[0];
    let formData = new FormData(formId);
    formData.append("postLat", currentLatitude);
    formData.append("postLon", currentLongitude);
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

            $('#alert-section')
                .css('display', 'block')
                .text(data)
                .addClass(' alert-primary');

            setTimeout(function () {
                $('#alert-section').css('display', 'none');
            }, 2000)

            getPosts();
        },
        error: function () {
            console.log("failed.");
        }
    });
}

function getPosts() {
    let postSection = $('#post-section');
    postSection.empty();

    $.get('postServlet')
        .done(function (data) {
            for (let i = data.length - 1; i >= 0; i--) {
                postSection.append(buildPost(data[i]));
            }
        }).fail(function () {
        console.log("Failed to get posts");
    });
}

function searchPost() {
    let query = $('#query').val();
    let postSection = $('#post-section');

    if (query !== '') {
        $.get('postServlet', {
            query: query
        }).done(function (data) {
            console.log(data);
            postSection.empty();

            for (let i = 0; i < data.length; i++) {
                postSection.append(buildPost(data[i]));
            }
        }).fail(function () {
            console.log("Ekintu kiganye.")
        })
    } else alert("Please enter something to search");

}

function searchUser() {
    let query = $('#query').val();

    $.get('searchUserServlet', {
        query: query
    }).done(function (data) {
        for (let i = 0; i < data.length; i++) {
            console.log(data[i]);
            $('#suggested-users-list').append(buildUser(data[i]));
        }
    }).fail(function () {
        console.log("Ekintu kiganye.")
    })
}

function deletePost(postId) {
    $.ajax('postServlet?postId='+postId, {
        type: 'DELETE'
    }).done(function (data) {
        getPosts();
    }).fail(function () {
        alert("You can only delete your posts.");
    });
}

function likePost(postId) {
    $.get('likeServlet', {
        'should_like': true,
        'postId': postId
    }).done(function (data) {
        $('#' + postId).text(data + " Likes");
    }).fail(function () {
        console.log("Failed");
    })
}

function unlikePost(postId) {
    $.get('likeServlet', {
        'should_like': false,
        'postId': postId
    }).done(function (data) {
        console.log(data);
    }).fail(function () {
        console.log("Failed");
    })
}

function showMap(lat, lon) {

}

function buildUser(user) {
  return '  <div class="col-lg-3 col-md-3 ">'+
  '      <div class="card">'+
  '          <div class="card-img-top">'+
  '              <div id="profileImage"><b>Itravel</b>'+
  '              </div>'+
  '              <p id="full-name">'+
  '                  <b>'+user.fullname+'</b><br>'+
  '                  <button class="btn btn-sm btn-round btn btn-primary" href="#">Follow</button>'+
  '              </p>'+
  '          </div>'+
  '      </div> ' +
  '  </div>';
}

function buildPost(post) {
    return "" +
        "<div class='media-block'> " +
        "<a class='media-left' href='#'><img class='img-circle img-sm' alt='Profile Picture' src='https://bootdey.com/img/Content/avatar/avatar1.png'></a> " +
        " <div class='media-body'> " +
        "<div class='mar-btm'> " +
        "<a href='#' class='btn-link media-heading box-inline'><b> " + post.posterFullName + "</b></a> " +
        "<p class='text-muted text-sm-left'><i class='material-icons'>stay_current_portrait</i> " + post.postDate + " </p> " +
        "</div> " +
        "<p><img id='post-image-tag' style='width: 100%; height: 400px;' src=" + post.postImageUrl + "></p> " +
        "<p>" + post.description + "</p> " +
        "<div class='pad-ver'> <span class='tag tag-sm' id='" + post.postId + "'><i class='fa fa-heart text-danger'></i> " + post.likes + " Likes</span> " +
        "<button class='btn btn-sm btn-round btn-default' onclick='likePost(" + post.postId + ")'><i class='material-icons'>thumb_up</i></button>  " +
        "<button class='btn btn-sm btn-round btn-default' onclick='showMap(" + post.postLat + ", " + post.postLong + ")'><i class='material-icons'>map</i></button>  " +
        "<button class='btn btn-sm btn-round btn-default' onclick='deletePost(" +post.postId+ ")'><i class='material-icons'>delete</i></button>  " +
        "<button data-toggle='collapse' data-target='#post-" + post.postId + "' class='btn btn-sm btn-round btn-default' onclick='getComments(" + post.postId + ")'>View comments</button> " +
        "<button class='btn btn-sm btn-round btn-primary' onclick='saveComment("+post.postId+")'>Add Comment</button> " +
        "</div> <hr>" + " " +
        "<div class='collapse' id='post-" + post.postId + "'></div>" +
        "</div> " +
        "</div>";
}

function buildComment(comment) {
    return ' <div>' +
        '   <div class="media-block">' +
        '      <a class="media-left" href="#"><img class="img-circle img-sm" alt="Profile Picture" src="https://bootdey.com/img/Content/avatar/avatar2.png"></a>' +
        '       <div class="media-body">' +
        '           <div class="mar-btm">' +
        '               <a href="#" class="btn-link text-semibold media-heading box-inline">' + comment.fullName + '</a>' +
        '               <p class="text-muted text-sm"><i class="fa fa-mobile fa-lg"></i> Recent </p>' +
        '           </div>' +
        '           <p> ' + comment.comment + ' </p>' +
        '           <button class="btn btn-sm btn-round btn-default" onclick="deleteComment(' +comment.commentId+ ', '+comment.postId+')"><i class="material-icons">delete</i></button>  ' +
        '           <hr>' +
        '       </div>' +
        '   </div>';
}