function selectBorrowById(borrowId) {
    var url = path+"/borrow/selectBorrowById.do";
    $.ajax({
        url:url,
        data:{"borrowId":borrowId},
        type:"post",
        success:function (borrow) {
            $("#borrowId").val(borrow.borrowId);
            $("#stuId").val(borrow.stuId);
            $("#bookNo").val(borrow.bookNo);
            $("#bookName").val(borrow.bookName);
            $("#bookAuthor").val(borrow.bookAuthor);
            $("#islose").val(borrow.islose);
            $("#stuNo").val(borrow.stuNo);
            $("#stuName").val(borrow.stuName);
            var date = new Date(borrow.startTime);
            var startYear = date.getFullYear();
            var startMonth = date.getMonth()+1;
            if(startMonth<10){
                startMonth = "0"+startMonth;
            }
            var startDay = date.getDate();
            if(startDay<10){
                startDay = "0"+startDay;
            }
            var start = startYear+"-"+startMonth+"-"+startDay;
            $("#startTime").val(start);

            var date2 = new Date(borrow.endTime);
            var endYear = date2.getFullYear();
            var endMonth = date2.getMonth()+1;
            if(endMonth<10){
                endMonth = "0"+endMonth;
            }
            var endDay = date2.getDate();
            if(endDay<10){
                endDay = "0"+endDay;
            }
            var end = endYear+"-"+endMonth+"-"+endDay;
            $("#endTime").val(end);
        }
    })
    
}
function deleteBorrowById(borrowId) {
    var url = path+"/borrow/deleteBorrowById.do";
    $.ajax({
        url:url,
        data:{"borrowId":borrowId},
        type:"post",
    })
}
//还书
function returnBookByBorrowId(borrowId,bookId) {
    var url = path+"/borrow/checkBorrowIsLose.do";
    var url2 = path+"/borrow/returnBookByBorrowId.do"
    $.ajax({
        url:url,
        data:{"borrowId":borrowId},
        type:"post",
        dataType:"text",
        success:function (response) {
            //借阅中
            if(response == "0"){
                $.ajax({
                    url:url2,
                    data:{"borrowId":borrowId,"bookId":bookId},
                    type:"post",
                    dataType:"text",
                    success:function (response) {
                        if(response == "success"){
                            alert("还书成功");
                        }else{
                            alert("服务器繁忙,请稍后再试");
                        }
                        location.reload();
                    }

                })
            }else if(response == "1"){//丢失
                alert("图书已经丢失或者损坏，不能够进行归还");
            }else{
                alert("图书已经归还不能进行重复归还");
            }
        }
    })

}

//丢失
function loseBook(borrowId,bookId,stuNo) {
    var urlBorrow = path+"/borrow/checkBorrowIsLose.do";
    $.post(urlBorrow,{"borrowId":borrowId},function (data) {
        if(data == "2"){

            alert("图书已经归还,请不要重复操作");
            location.reload();
            return ;
        }else if(data == "1"){

            alert("图书已经损坏,请不要重复操作");
            location.reload();
            return;
        }else{

            $("#borrowIdLose").val(borrowId);
            var url = path+"/book/selectkByBookId.do"
            $.post(url,{"bookId":bookId},function (book) {
                $("#bookNoLose").val(book.bookNo);
                $("#bookNameLose").val(book.bookName);
                $("#bookIdLose").val(bookId);
            },"json")
            var url2 = path+"/student/selectStuByStuNo.do"
            $.post(url2,{"stuNo":stuNo},function (stu) {
                $("#stuNoLose").val(stuNo);
                $("#stuNameLose").val(stu.stuName);
                $("#stuIdLose").val(stu.stuId);
            },"json")
        }
    },"text")

}
$(function () {
    $("#stuNo").blur(function (student) {
        var stuNo = $(this).val();
        $.ajax({
            url:path+"/student/selectStuByStuNo.do",
            data:{"stuNo":stuNo},
            type:"post",
            success:function (student) {
                $("#stuName").val(student.stuName);
                $("#stuId").val(student.stuId);
            }
        })
    })


    //////////////////////////////
    //页面重新加载
    $("#delClose").click(function () {
        location.reload();
    })

    ///////////////////////////////////
    //首页
    $("#first").click(function () {
        $("#pageNo").val(1);
        $("#form").submit();
    })
    //尾页
    $("#end").click(function () {
        $("#pageNo").val($("#totalPage").val());
        $("#form").submit();
    })
    //上一页
    $("#previous").click(function () {
        var no = $("#pageNo").val();
        no=no-1;
        if(no <= 1){
            $("#pageNo").val(1);
        }else{
            $("#pageNo").val(no);
        }
        $("#form").submit();
    })
    //下一页
    $("#next").click(function () {
        var no = $("#pageNo").val();
        var totalPage =$("#totalPage").val();
        var pageNo = Number(no)+1;
        if(pageNo>=totalPage){
            pageNo=totalPage;
        }
        $("#pageNo").val(pageNo);
        $("#form").submit();
    })
    //超链接
    $(".numLink").click(function () {
        var no = $(this).html();
        $("#pageNo").val(no);
        $("#form").submit();
    })
})