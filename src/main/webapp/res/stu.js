function loadOption(deptno){
    var url = path+"/student/selectSpecialtyByDeptNo.do";
    $.ajaxSettings.async = false;
    $.post(url,{"deptNo":deptno},function (data) {
        $("#specialty").empty();
        $("#specialty").append("<option value=''>请选择</option>");
        var result = "";
        for(var i = 0 ; i < data.length; i++){
            result = result+"<option value="+data[i].specId+">"+data[i].specName+"</option>"
        }
        $("#specialty").append(result);
    },"json")
    $.ajaxSettings.async = true;
}
$(function () {
    $("#close").click(function () {
        location.reload();
    })

    //当学院进行切换的时候发送一个ajax请求
    $("#deptNo").change(function () {
        var deptno = $("#deptNo").val();
        loadOption(deptno);
    })


    //表单验证
    $("#form").submit(function () {
        var  flag = true;
        //学号验证
        var stuNo = $("#stuNo").val();
        if(stuNo == null || stuNo==""){
            $("#errorStuNo").html("学号不能为空");
            flag = false;
        }else{
            $("#errorStuNo").html("");
            flag = true;
        }

        //姓名验证
        var name = $("#name").val();
        if(name==null || name==""){
            $("#errorName").html("姓名不能为空");
            flag = false;
        }else{
            $("#errorName").html("");
            flag = true;
        }

        //系别验证
        var dept = $("#deptNo").val();
        if(dept==null || dept==""){
            $("#errorDeptNo").html("请选择系别");
            flag = false;
        }else{
            $("#errorDeptNo").html("");
            flag = true;
        }

        //专业验证
        var specialty = $("#specialty").val();
        if(specialty==null || specialty==""){
            $("#errorSpecialty").html("请选择专业");
            flag = false;
        }else{
            $("#errorSpecialty").html("");
            flag = true;
        }

        //年级验证
        var grade = $("#grade").val();
        if(grade==null || grade==""){
            $("#errorGrade").html("请选择年级");
            flag = false;
        }else{
            $("#errorGrade").html("");
            flag = true;
        }

        //电话验证
        var tel = $("#tel").val();
        if(tel==null || tel==""){
            $("#errorTel").html("电话不能为空");
            flag = false;
        }else{
            $("#errorTel").html("");
            flag = true;
        }
        return flag;
    })



    //////////////////////////////////////////////
    $(".numberLink").click(function () {
        var pageNo = $(this).val();
        $("#pageNo").val(pageNo);
        $("#formSubmit").submit();
    })

    //首页
    $("#first").click(function () {
        $("#pageNo").val(1);
        $("#formSubmit").submit();
    })
    //尾页
    $("#end").click(function () {
        $("#pageNo").val($("#totalPage").val());
        $("#formSubmit").submit();
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
        $("#formSubmit").submit();
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
        $("#formSubmit").submit();
    })

})
//删除信息
function deleteStudent(stuId){
    var url = path+"/student/deleteStudent.do";
    $.ajax({
        url:url,
        data:"stuId="+stuId,
        type:"post"
    })
}

//修改信息回显
function modifyStudent(stuId){
    var url = path+"/student/alterStudent.do"
    $.post(url,{"stuId":stuId},function (data) {
        $("#stuId").val(data.stuId);
        $("#stuNo").val(data.stuNo);
        $("#name").val(data.stuName);
        $("#deptNo").children().each(function(){
            if(data.deptNo == $(this).val()){
                $(this).prop('selected',true);
            }
        })
        //回显专业
        loadOption(data.deptNo);
        $("#specialty").children().each(function(){
            if(data.specId == $(this).val()){
                $(this).prop('selected',true);
            }
        })
        //回显年级
        $("#grade").children().each(function(){
            if(data.stuGrade == $(this).val()){
                $(this).prop('selected',true);
            }
        })
        //回显电话
        $("#tel").val(data.stuTel);

    },"json")
}