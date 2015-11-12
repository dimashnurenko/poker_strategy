if (window.addEventListener)
    window.addEventListener("load", init);
else if (window.attachEvent)
    window.attachEvent("onload", init);

function init() {
    $("#getCombination").click(function () {
        $.ajax({
            method: "GET",
            url: "combination/define/" + $("combinationCode").text(),
            success: function (data) {
                window.alert(data)
            },
            error: function (error) {
                window.alert(error.text)
            }
        });
    });
}