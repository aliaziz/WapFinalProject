$(document).ready(function () {
    getSuggestions();
})

function getSuggestions() {
    let $suggestions = $('#suggestions-list');
    $suggestions.empty();

    $.get('followServlet', {}).done(function (data) {
        for (let i = 0; i < 3; i++) {
            console.log(data[i]);
            $suggestions.append(buildSuggestion(data[i]));
        }

    }).fail(function () {
        console.log("failed to get suggestions")
    })
}

function follow(followedId) {
    $.post('followServlet', {
        followedUserId: followedId
    }).done(function(data) {
        getSuggestions();
        alert("Followed");
    }).fail(function() {
        alert("Failed to follow");
    })
}

function buildSuggestion(suggestion) {
  return  ' <div class="col-lg-4 col-md-4 ">'+
   '     <div class="card">'+
   '         <div class="card-img-top">'+
   '             <a href="#">'+
   '                 <img src="../assets/img/city-profile.jpg" alt="Image" style="max-width:100%;">'+
   '             </a>'+
   '             <p>'+
   '                 <b>'+suggestion.fullName+'</b><br>'+
   '                 <button onclick="follow('+suggestion.userId+')" class="btn btn-sm btn-round btn btn-primary" >Follow</button>'+
   '             </p>'+
   '         </div>'+
   '     </div>'+
   ' </div>';
}