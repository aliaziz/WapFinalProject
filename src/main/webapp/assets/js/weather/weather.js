let weatherData;
$(document).ready(function () {
    getWeather();
});

function getWeather() {
    if (navigator.geolocation){
        navigator.geolocation.getCurrentPosition(successWeather, errorWeather);
    } else {
        alert("Please turn on location");
        //Use some's location.
    }
}

function successWeather(position) {
    let latitude = position.coords.latitude;
    let longitude = position.coords.longitude;
    fetchWeather(latitude, longitude);
}

function errorWeather(error) {
    console.log(error);
}

function fetchWeather(lat, long) {
    $.get('http://api.openweathermap.org/data/2.5/forecast', {
        'lat': lat,
        'lon': long,
        'appid': 'aaa45500876fa7b1568102c12951288e'
    }).done(function(data) {
        $('h3.fri').text(moment().format('dddd'));
        weatherData = data;
    }).fail(function(){
        console.log("Error");
    })
}