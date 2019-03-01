<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>主页</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js" ></script>
		<style type="text/css">
			*{
				padding: 0px;
				margin: 0px;
			}
			body {
			    width: 100%;
			    height: 100%;
			    margin: 0;
			    overflow: hidden;
			    background-color: #FFFFFF;
			    font-family: "Microsoft YaHei", sans-serif;
			 } 
			 .pageSidebar{
			    width: 240px;
			    height:100%;
			    padding-bottom: 30px;
			    overflow: auto;
			    background-color: #e3e3e3;
			 } 
			 .splitter {
			     width: 5px;
			     height: 100%;
			     bottom: 0;
			     left: 240px;
			     position: absolute;
			     overflow: hidden;
			     background-color: #333;
			 } 
			 .pageContent{
			     height: 100%;
			     min-width: 768px;
			     left: 246px;
			     top: 0;
			     right: 0;
			     z-index: 3;
			     padding-bottom: 30px;
			     position: absolute;
			 } 
			 .pageContainer{
			     bottom: 0;
			     left:0;
			     right: 0;
			     top: 53px;
			     overflow: auto;
			     position: absolute;
			     width: 100%;
			 } 
			 .footer {
			     width: 100%;
			     height: 30px;
			     line-height: 30px;
			     margin-top: 0;
			     left: 0;
			     right: 0;
			     bottom: 0;
			     position: absolute;
			     z-index: 10;
			     background-color:#333;
			     
			 }
			.navbar-collapse{
			    padding-left: 5px;
			    padding-right: 5px;
			 } 
			 .nav>li{
			     text-align: center;
			 } 
			 .nav>li>a{
			     color:#444;
			     margin: 0 5px;
			 } 
			 .nav-pills>li.active>a, .nav-pills>li.active>a:focus, .nav-pills>li.active>a:hover{
			     background-color: #222222;
			 } 
			 .dropdown-menu{
			     min-width: 200px;
			     margin-left: 40px;
			     background-color: #E3E3E3;
			 } 
			 .dropdown-menu>li>a{
			     padding: 10px 15px;
			 }
			 

		</style>
	</head>
	<body>
		<nav class="navbar navbar-inverse navbar-static-top">
		  <div class="container-fluid">
		  	<div class="navbar-header"> 
		  	<a class="navbar-brand" title="logoTitle" href="#">图书馆管理系统</a> 
		  	
		  	</div> 
		  	<div class="collapse navbar-collapse"> 
		  		<ul class="nav navbar-nav navbar-right"> 
		  			<li role="presentation"> <a href="#">当前用户：<span class="badge">Admin</span></a> </li> 
		  			<li> <a href="${pageContext.request.contextPath}/user/logout.do">退出登录</a> </li>
		  		</ul> 
		  	</div> 
		  </div> 

		</nav>
		<!-- 中间主体内容部分 -->
		<div class="pageContainer"> 
			<!-- 左侧导航栏 --> 
			<div class="pageSidebar"> 
				<ul class="nav nav-stacked nav-pills"> 
					<li role="presentation"> 
						<a href="${pageContext.request.contextPath}/student/selectStudentByCondition.do" target="mainFrame">学生管理</a>
					</li> 
					<li role="presentation"> 
						<a href="${pageContext.request.contextPath}/book/selectBookByCondition.do" target="mainFrame">图书管理</a>
					</li> 
					<li class="dropdown"> 
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">借阅管理<span class="caret"></span> </a> 
						<ul class="dropdown-menu"> 
							<li> 
								<a href="${pageContext.request.contextPath}/borrow/selectBorrowByCondition.do" target="mainFrame">借书管理</a>
							</li> 
							<li> 
								<a href="${pageContext.request.contextPath}/lose/selectLoseByCondition.do" target="mainFrame">丢失损坏管理</a>
							</li> 
						</ul> 
					</li>
					<li role="presentation"> 
						<a  id="user" href="${pageContext.request.contextPath}/user/selectUserByCondition.do" target="mainFrame">系统管理</a>
					</li>
				</ul> 
			</div>
			<!-- 左侧导航和正文内容的分隔线 --> 
			<div class="splitter"></div> 
				
			<!-- 正文内容部分 --> 
			<div class="pageContent"> 
				<iframe  id="mainFrame" name="mainFrame" frameborder="0" width="100%"  height="100%" frameBorder="0"></iframe> 
			</div>


		</div>
			
		<!-- 底部页脚部分 --> 
		<div class="footer"> 
			<p class="text-center" style="color: gainsboro;"> 2019 © Hechaoqun 河南师范大学新联学院</p> 
		</div>

	</body>
</html>
