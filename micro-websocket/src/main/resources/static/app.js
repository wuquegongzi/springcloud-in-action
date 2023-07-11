var stompClient = null;

function connect() {
    var socket = new SockJS('http://192.168.150.123:8099/any-socket');

    stompClient = Stomp.over(socket);
    stompClient.connect(
        {},
        function (frame) {
        // console.log('Connected: ' + frame);
        stompClient.subscribe('/user/topic/chat', function (message) {
            showMessage(JSON.parse(message.body));
        });
    });
}

function showMessage(message) {
    $("#message").append(
        message.content+"<br>"
    );
}

$(function () {
    connect();

    $("#send").click(function () {
        var content = "{'type':'text','content':'" + $("#msg").val() + "','toType':'USER','receiver':'"+$("#name").val()+"'}";
        stompClient.send("/app/chat", {}, content);
    });

});
