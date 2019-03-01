<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="utf-8" />
		<title>登录页面</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
		<style type="text/css">
			#back{
				background-image: url(${pageContext.request.contextPath}/img/3.jpg);
				height: 1000px;
				overflow:hidden;
				background-size: 100%;
				background-repeat: no-repeat;
				
			}
			#formDiv{
				margin: 200px auto;
				width: 300px;
			}
		</style>
		<script type="text/javascript">
			$(function(){
				//表单验证
				$("#form").submit(function(){
					
					var username = $("#username").val();
					if(username == null || username ==""){
						$("#errorUserName").html("用户名不能为空");
						return false;
					}
					var pwd = $("#password").val();
					if(pwd == null || pwd ==""){
						$("#errorPassword").html("密码不能为空");
						return false;
					}
					return true;
				})
				
				//username失去焦点的时候进行js验证
				$("#username").blur(function(){
					var username = $("#username").val();
					if(username == null || username == ""){
						$("#errorUserName").html("用户名不能为空");
					}else{
						$("#errorUserName").html("");
					}
				})
				
				//password失去焦点的时候进行js验证
				$("#password").blur(function(){
					var pwd = $("#password").val();
					if(pwd == null || pwd == ""){
						$("#errorPassword").html("密码不能为空");
					}else{
						$("#errorPassword").html("");
					}
				})
			})
		</script>
	</head>
	<body id="back">
		<div class="container">
				<div id="formDiv">
					<form id="form" method="post" action="${pageContext.request.contextPath}/user/login.do">
					  <div class="form-group">
					    <label for="exampleInputEmail1" style="color: gainsboro;">Username:</label>
					    <input type="text" value="${username}" name="username"  class="form-control" id="username" placeholder="Place Input Your Username" style="width: 300px;">
					  	<p class="text-danger" id="errorUserName">${error}</p>
					  </div>
					  <div class="form-group">
					    <label for="exampleInputPassword1" style="color: gainsboro;">Password:</label>
					    <input type="password" name="password" class="form-control" id="password" placeholder="Place Input Your Password" style="width: 300px;">
					  	<p class="text-danger" id="errorPassword"></p>
					  </div>
					  <div>
						  <button type="submit" class="btn btn-success">登录</button>
						  <button type="reset" class="btn btn-primary" style="float: right;">重置</button>
					  </div>
					  <div style="float: none;"></div>
					  
					</form>
				</div>
		</div>
		
		
	</body>
</html>
