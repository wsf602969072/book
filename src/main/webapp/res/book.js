function loadOption(parentId) {
    var url = path+"/book/selectCatalogByParentId.do";
    $.ajaxSettings.async = false;
    $.post(url,{"parentId":parentId},function (data) {
        $("#catalog2").empty();
        $("#catalog2").append("<option value=''>请选择</option>");
        var option = "";
        for(var i = 0 ; i <data.length;i++){
            option = option +"<option value="+data[i].cataId+">"+data[i].cataName+"</option>";
        }
        $("#catalog2").append(option);
    },"json")
    $.ajaxSettings.async = true;
}

function modifyBook(bookId) {
    var url = path+"/book/alterBook.do"
    $.post(url,{"bookId":bookId},function (book) {
        $("#bookId").val(book.bookId);
        $("#bookNo").val(book.bookNo);
        $("#bookName").val(book.bookName);
        $("#bookAuthor").val(book.bookAuthor);
        $("#catalog1").children().each(function () {
            if(book.cataParent == $(this).val()){
                $(this).prop('selected',true);
            }
        })
        //改为同步
        loadOption(book.cataParent);
        $("#catalog2").children().each(function () {
            if(book.cataId == $(this).val()){
                $(this).prop('selected',true);
            }
        })
        //$("#catalog2").val(book.cataId);

        $("#bookNum").val(book.bookNum);
        $("#bookStatus").children().each(function () {
            if(book.bookStatus == $(this).val()){
                $(this).prop('selected',true);
            }
        })

    },"json")
}


//删除
function deleteBookById(bookId){
    var url = path+"/book/deleteBookById.do";
    $.ajax({
        url:url,
        data:"bookId="+bookId,
        type:"post"
    })
}

//借书
function selectBook(bookId){
    var url = path+"/book/selectkByBookId.do"
    $.post(url,{"bookId":bookId},function (book) {
        $("#borrowBookId").val(bookId);
        $("#borrowBookNo").val(book.bookNo);
        $("#borrowBookName").val(book.bookName);

    })
}
$(function () {
    //一级分类发送ajax
    $("#catalog1").change(function () {
        var parentId = $("#catalog1").val();
        loadOption(parentId);
    })

    ////////////////////////////////////////////////
    $("#deleteClose").click(function () {
            location.reload();
    })

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
        var totalPage = $("#totalPage").val();
        no = Number(no)+1;
        if(no>=totalPage){
            no=totalPage;
        }
        $("#pageNo").val(no);
        $("#form").submit();
    })

    $(".numLink").click(function () {
        var no = $(this).html();
        $("#pageNo").val(no);
        $("#form").submit();
    })
    
    //提交表单
    $("#formSubmit").click(function () {
        $("#form").submit();
    })


    /////////////////////////////////////////////////结束
    /*$("#borrowBookNo").blur(function () {
        var url = path+"/book/selectByBookNo.do";
        var bookNo = $("#bookNo").val();
        $.post(url,{"bookNo":bookNo},function (book) {
            if(book == null){
                $("#nameError").val("你输入的图书编号不存在");
            }else{
                $("#borrowBookName").val(book.bookName);
            }
        })
    })*/

    //////////////////////////////////////////////////
    //根据学号查询学生
    $("#stuNo").blur(function () {
        var url = path+"/student/selectStuByStuNo.do"
        var stuNo = $(this).val();
        $.post(url,{"stuNo":stuNo},function (student) {
            if(student == null){
                $("#nameSpan").html("没有查找到该学生的信息");
            }else{
                $("#borrowStuId").val(student.stuId);
                $("#stuName").val(student.stuName);
            }
        })
    })
    /*//表单校验
    $("#borrowForm").submit(function () {
        var stuNo = $("#stuNo").val();
        if(stuNo == null || stuNo == ""){
            return false;
        }
        var startTime = $("#borrwoTime").val();
        var endTime = $("#backTime").val();
        alert(startTime);
    })*/

    $("#submitForm").click(function () {
        $.ajax({
            type: 'post',
            url: path + '/borrow/borrowBook.do',
            data: $("#borrowBook").serialize(),
            dataType: 'text',
            success: function (message) {
                alert(message);
                location.reload();
            }
        });
    })
       /*$("#borrowBook").submit(function () {
           var stuName = $("#stuName").val();
           if(stuName == null || stuName == ""){
               $("#nameSpan").html("内容不能为空");
               return false
           }else{
               $("#nameSpan").html("");
           }
           var stuNo = $("#stuNo").val();
           if(stuNo == null || stuNo == ""){
               $("#nameSpan").html("内容不能为空");
               return false;
           }else{
               $("#nameSpan").html("");
           }
           var stuId = $("#stuId").val();
           if(stuId == null || stuId == ""){
               $("#nameSpan").html("内容不能为空");
               return false;
           }else{
               $("#nameSpan").html("");
           }
           var startTime = $("#startTime").val();
           if(startTime==null || startTime==""){
               $("#nameSpan").html("内容不能为空");
               return false;
           }else{
               $("#nameSpan").html("");
           }
           var endTime = $("#endTime").val();
           if(endTime == null || endTime == ""){
               $("#nameSpan").html("内容不能为空");
               return false;
           }else{
               $("#nameSpan").html("");
           }
           return true;
       });*/


})

