function post() {
    var questionId = $("#question-id").val();
    var comtent = $("#question-content").val();
    $.ajax({
        type: "POST",
        url: "/comment",
        contentType: 'application/json',
        data: JSON.stringify({
            "parentId":questionId,
            "content":comtent,
            "type":1
        }),
        success: function (response) {
            if(response.code == 200){
                $("#comment-section").hide();
                alert(response.message);
            }else {
                alert(response.message);
            }
        },
        dataType: "json"
    })
    ;

}