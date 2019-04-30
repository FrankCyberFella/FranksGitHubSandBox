// JavaScript source code
$("#inputForm").validate();


function updatePageContent(textbox) {
    var textBoxValue = $(textbox).val();

    $("#contentArea").html(textBoxValue);
}

$("#visibility-button").click(function () {
    $("#visibility-container").hide("slow");
});

$("#animation-button").click(function () {
    var div = $("#animated-container");

    div.animate({ height: '300px', opacity: '0.4' }, "slow");
    div.animate({ width: '300px', opacity: '0.8' }, "slow");
    div.animate({ height: '100px', opacity: '0.4' }, "slow");
    div.animate({ width: '100px', opacity: '0.8' }, "slow");
    div.hide("slow");
    
});

$("#fade-in-button").click(function () {
    $("#visibility-container").fadeIn("slow");
    $("#animated-container").show("fast");
    $("#animated-container").animate({ height: '200px', width: '600px', opacity: '1.0' }, "slow");
    $("#slider-panel").slideDown();
});

$("#slideup-button").click(function () {
    $("#slider-panel").slideUp();

});

$("#movie-search").keyup(function () {

    if ($("#movie-search").val().length < 3)
        return;

    var movie = escape($("#movie-search").val());

    $.getJSON("http://www.omdbapi.com/?s=" + movie, function (data) {
        
    
        $("#movie-results tbody").empty();                                

        if (data["Error"] == "Movie not found!")
            return;

        for (var i = 0; i < data["Search"].length; i++) {
            var record = data["Search"][i];

            var title = record["Title"];
            var year = record["Year"];
            var posterUrl = record["Poster"];

            if (posterUrl == "N/A")
                posterUrl = "https://upload.wikimedia.org/wikipedia/commons/a/ac/No_image_available.svg";

            var newRow = "<tr><td><img src='{0}' /></td><td>{1}</td><td>{2}</td></tr>".format(posterUrl, title, year);

            $("#movie-results tbody").append(newRow);
        }            
    });    
});


String.prototype.format = function () {
    var str = this;
    for (var i = 0; i < arguments.length; i++) {
        var reg = new RegExp("\\{" + i + "\\}", "gm");
        str = str.replace(reg, arguments[i]);
    }
    return str;
}