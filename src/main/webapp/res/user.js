function deleteUser(userId) {
    $.ajax({
        url:path+"/user/deleteUserById.do",
        data:"userId="+userId,
        type:"post",

    })
}

function modify(userId) {
    $.ajax({
        url:path+"/user/selectUserById.do",
        data:"userId="+userId,
        dataType:"json",
        type:"post",
        success:function (obj) {
            $("#userId").val(obj.userId);
            $("#username").val(obj.username);
            $("#password").val(obj.password);
            $("#name").val(obj.name);
            $("#address").val(obj.address);
            $("#tel").val(obj.tel);
            $("#privilege").children('option').each(function () {
                if($(this).val()==obj.privilege){
                    $(this).prop('selected',true);
                }
            })

        }
    })
}


$(function () {
    $("#close").click(function () {
        location.reload();
    })
    /////////////////////////////////////////////////////
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
    ////////////////////////////////////////////////////////////////
    //用户名失去交点的时候进行验证
    $("#username").blur(function () {
        //用户名
        var username = $("#username").val();
        if(username==null || username==""){
            //增加提示信息
            $("#errorUsername").html("用户名不能为空");
        }else{
            //如果用户名不为空，那么发送ajax请求，进行用户名的校验$.post(url,data,fn,type)
            $.post(path+"/user/validate.do",{username:username},function (data) {
                if(data == 1){
                    //可以进行注册
                    $("#errorUsername").html("");
                }else{
                    //返回其他值不能进行注册
                    $("#errorUsername").html("用户名已经存在");

                }
            },"text")
        }
    })

    //密码失去交点的时候进行验证
    $("#password").blur(function () {
        //用户名
        var password = $("#password").val();
        if(password==null || password==""){
            //增加提示信息
            $("#errorPassword").html("密码不能为空");
        }else{
            $("#errorPassword").html("");
        }
    })
    //姓名失去交点的时候进行验证
    $("#name").blur(function () {
        //用户名
        var name = $("#name").val();
        if(name==null || name==""){
            //增加提示信息
            $("#errorName").html("姓名不能为空");
        }else{
            $("#errorName").html("");
        }
    })
    //地址失去交点的时候进行验证
    $("#address").blur(function () {
        //用户名
        var address = $("#address").val();
        if(address==null || address==""){
            //增加提示信息
            $("#errorAddress").html("地址不能为空");
        }else {
            $("#errorAddress").html("");
        }
    })
    //电话失去交点的时候进行验证
    $("#tel").blur(function () {
        var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;
        //用户名
        var tel = $("#tel").val();
        if(tel==null || tel==""){
            //增加提示信息
            $("#errorPhone").html("用户名不能为空");
        }else {
            $("#errorPhone").html("");
        }
        if(tel.length != 11 || !myreg.test(tel)){
            //增加提示信息
            $("#errorPhone").html("不是一个手机号");
        }else {
            $("#errorPhone").html("");
        }

    })
    //权限失去交点的时候进行验证
    $("#tel").change(function () {
        var privilege = $("#privilege").val();
        if(privilege == null || privilege == ""){
            //增加提示信息
            $("#errorPrivilege").html("权限不能为空");
        }else{
            $("#errorPrivilege").html("");
        }
    })

    $("#addSubmit").click(function () {

        //提交表单之前进行校验
        $("#formAddEdit").submit(function () {
            var flag = true;
            //用户名失去交点的时候进行验证
            $("#username").blur(function () {
                //用户名
                var username = $("#username").val();
                if(username==null || username==""){
                    //增加提示信息
                    $("#errorUserName").html("用户名不能为空");
                    flag = false;
                }else{
                    //如果用户名不为空，那么发送ajax请求，进行用户名的校验$.post(url,data,fn,type)
                    $.post(path+"/user/validate.do",{username:username},function (data) {
                        alert(data+"data")
                        if(data == 1){
                            //可以进行注册
                            flag = true;
                        }else{
                            //返回其他值不能进行注册
                            $("#errorUserName").html("用户名已经存在");
                            flag = false;
                        }
                    },"text")
                }
            })
            //密码失去交点的时候进行验证
            $("#password").blur(function () {
                //用户名
                var password = $("#password").val();
                if(password==null || password==""){
                    //增加提示信息
                    $("#errorPassword").html("密码不能为空");
                    flag = false;
                }else{
                    $("#errorPassword").html("");
                    flag = true;
                }
            })
            //姓名失去交点的时候进行验证
            $("#name").blur(function () {
                //用户名
                var name = $("#name").val();
                if(name==null || name==""){
                    //增加提示信息
                    $("#errorName").html("姓名不能为空");
                    flag = false;
                }else{
                    $("#errorName").html("");
                    flag = true;
                }
            })
            //地址失去交点的时候进行验证
            $("#address").blur(function () {
                //用户名
                var address = $("#address").val();
                if(address==null || address==""){
                    //增加提示信息
                    $("#errorAddress").html("地址不能为空");
                    flag = false;
                }else{
                    $("#errorAddress").html("");
                    flag = true;
                }
            })
            //电话失去交点的时候进行验证
            $("#tel").blur(function () {
                //用户名
                var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;
                var tel = $("#tel").val();
                if(tel==null || tel==""){
                    //增加提示信息
                    $("#errorPhone").html("电话不能为空");
                    flag = false;
                }else{
                    $("#errorPhone").html("");
                    flag = true;
                }
                if(tel.length != 11 || !myreg.test(tel)){
                    //增加提示信息
                    $("#errorPhone").html("不是一个合法的手机号");
                    flag = false;
                }else{
                    $("#errorPhone").html("");
                    flag = true;
                }

            })
            //权限失去交点的时候进行验证
            $("#tel").change(function () {
                var privilege = $("#privilege").val();
                if(privilege == null || privilege == ""){
                    //增加提示信息
                    $("#errorPrivilege").html("权限不能为空");
                    flag = false;
                }else{
                    $("#errorPrivilege").html("");
                    flag = true;
                }
            })
            return flag;
        })
    })

})