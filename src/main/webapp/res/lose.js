function dealLoseById(loseId) {
    var url = path+"/lose/dealLoseById.do"
    $.post(url,{"loseId":loseId},function (data) {
        alert(data);
        location.reload();
    },"text")

}
function deleteLoseById(loseId) {
    var url = path+"/lose/deleteLoseById.do"
    $.post(url,{"loseId":loseId},function () {

    },"text")
}
$(function () {

    $("#close").click(function () {
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