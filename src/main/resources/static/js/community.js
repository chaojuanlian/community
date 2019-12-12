

/**
 * 提交回复
 */
function post() {
    var questionId = $("#question-id").val();
    var content = $("#question-content").val();

    comment2target(questionId,1,content);

}

function comment2target(targetId, type,content) {
    if (!content){
        alert("不能回复空内容~~~");
        return;
    }
    $.ajax({
        type: "POST",
        url: "/comment",
        contentType: 'application/json',
        dataType: "json",
        data: JSON.stringify({
            "parentId":targetId,
            "content":content,
            "type":type
        }),
        success: function (response) {
            if(response.code == 200){
                window.location.reload();
            }else {
                if (response.code == 2003){
                    var isAccepted = confirm(response.message);
                    if (isAccepted){
                        window.open("https://github.com/login/oauth/authorize?client_id=7f509e5e6cba467e6e5a&redirect_uri=http://localhost:8887/callback&scope=user&state=1");
                        window.localStorage.setItem("closable",true);
                    }
                }else{
                    alert(response.message);
                }
            }
        }
    })
    ;
}

function comment(e) {
    var commentId = e.getAttribute("data-id");
    var content = $("#input-"+commentId).val();
    comment2target(commentId,2,content);
}

/**
 * 展开二级评论
 */
function collapseComments(e){
    var id = e.getAttribute("data-id");
    var comments = $("#comment-"+id);

    //获取二级评论的展开状态
    var collapse = e.getAttribute("data-collapse");
    if (collapse){
        //折叠二级评论
        comments.removeClass("in");
        e.removeAttribute("data-collapse");
        e.classList.remove("active");
    }else{
        $.getJSON("/comment/"+id,function(data){
            handleList(data.data);



        // 展开二级评论
        comments.addClass("in");
        //标记二级评论展开状态
        e.setAttribute("data-collapse","in");
        e.classList.add("active");

        });
    }
}

function handleList(data){
    var html = '';
    $.map(data,function(item,index){
        html += '<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 comments">'
            + '<div class="media"><div class="media-left"><a><img class="media-object img-rounded" '
            + 'src= ' + item.user.avatarUrl + '></a></div>'
            + '<div class="media-body"><h5 class="media-heading">'
            + '<span>' + item.user.name+ '</span></h5>'
            + '<div>' + item.content + '</div>'
            + '<div class="menu"><span class="pull-right"'
            + '>' + dateFormat(item.gmtCreate)  + '</span>'
            + '</div></div></div></div></div>';
    });
    $('.two-comment').prepend(html);
}

/*
 * 时间格式化工具
 * 把Long类型的1527672756454日期还原yyyy-MM-dd格式日期
 */
function dateFormat(longTypeDate){
    var dateTypeDate = "";
    var date = new Date();
    date.setTime(longTypeDate);
    dateTypeDate += date.getFullYear();   //年
    dateTypeDate += "-" + getMonth(date); //月
    dateTypeDate += "-" + getDay(date);   //日
    return dateTypeDate;
}

//返回 01-12 的月份值
function getMonth(date){
    var month = "";
    month = date.getMonth() + 1; //getMonth()得到的月份是0-11
    if(month<10){
        month = "0" + month;
    }
    return month;
}
//返回01-30的日期
function getDay(date){
    var day = "";
    day = date.getDate();
    if(day<10){
        day = "0" + day;
    }
    return day;
}