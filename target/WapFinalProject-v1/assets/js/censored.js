function edit(word) {
    let newWord = prompt("Edit word", word);

    $.ajax("censoredWordServlet?oldWord="+word+"&newWord="+newWord, {
        type: "PUT"
    }).done(function(data) {
        window.location.href = 'censoredWordServlet';
    }).fail(function() {
        console.log("Error");
    })
}

function remove(word) {
    $.ajax("censoredWordServlet?word="+word, {
        type: "DELETE"
    }).done(function(data) {
        window.location.href = 'censoredWordServlet';
    }).fail(function() {
        console.log("Error");
    })
}

function add() {
    let word = prompt("Add new word");

    $.post('censoredWordServlet', {
        word: word
    }).done(function(data) {
        window.location.href = 'censoredWordServlet';
    }).fail(function() {
        console.log("Error");
    })
}