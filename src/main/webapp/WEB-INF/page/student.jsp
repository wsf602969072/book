<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>学生管理</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/res/stu.js"></script>
		<script type="text/javascript">var path="${pageContext.request.contextPath}";</script>
		<style type="text/css">
			#fenye{
				width: 300px;
				margin: 20px auto; 
				
			}
			#containers{
				
				height: 50px;
				float: right;
			}
			#conditionDiv{
				display: inline;
			}
			#conditionDiv{
				position: relative;
				top: 10px;
				float: left;
				
			}
		</style>
		<script type="text/javascript">
			
		</script>
	</head>
	<body>
		<div class="container">
			
		
			<!--
            	作者：offline
            	时间：2019-02-16
            	描述：增加学生模态框
            -->
			
			<!-- Modal -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="myModalLabel">添加/修改(Add/Edit)</h4>
			      </div>
			        <form class="form-horizontal" id="form" method="post" action="${pageContext.request.contextPath}/student/saveOrUpdate.do">
			        	<input type="hidden" name="stuId" id="stuId"/>
				    	<div class="modal-body">
				      		<!--学号-->
				     		<div class="form-group">
							    <label for="inputEmail3" class="col-sm-2 control-label">学号</label>
							    <div class="col-sm-10">
								<input type="text" class="form-control" name="stuNo" id="stuNo" placeholder="Please Input Your No 例如:15320474003">
							</div>
							</div>
							<span id="errorStuNo" style="color: red;text-align: center"></span>
							<!--姓名-->
							<div class="form-group">
							    <label for="inputEmail3" class="col-sm-2 control-label">姓名</label>
							    <div class="col-sm-10">
							      <input type="text" class="form-control" id="name" name="stuName" placeholder="Please Input Your Name 例如:何超群">
							    </div>
							</div>
							<span id="errorName" style="color: red;text-align: center"></span>
							<!--系别-->
							<div class="form-group">
							    <label for="inputEmail3" class="col-sm-2 control-label">系别</label>
							    <div class="col-sm-10">
							      <!--<input type="email" class="form-control" id="department" placeholder="Please Input Your Department 例如:机电工程学院">-->
							      	<select class="form-control" id="deptNo" name="deptNo">
							    		<option value="">--请选择--</option>
										<c:forEach items="${deptList}" var="dept">
											<option value="${dept.deptNo}">${dept.deptName}</option>
										</c:forEach>
							    	</select>
							    </div>
							</div>
							<span id="errorDeptNo" style="color: red;text-align: center"></span>
							<!--专业-->
							<div class="form-group">
							    <label for="inputEmail3" class="col-sm-2 control-label">专业</label>
							    <div class="col-sm-10" >
							      <!--<input type="email" class="form-control" id="specialty" placeholder="Please Input Your Specialty 例如:计算机科学与技术">-->
							    	<select class="form-control" id="specialty" name="specId">
							    		<option value="">--请选择--</option>
							    	</select>
							    </div>
							</div>
							<span id="errorSpecialty" style="color: red;text-align: center"></span>
							<!--年级-->
							<div class="form-group">
							    <label for="inputEmail3" class="col-sm-2 control-label">年级</label>
							    <div class="col-sm-10">
									<select class="form-control" id="grade" name="stuGrade">
										<c:forEach begin="2000" end="2100" varStatus="varStatus">
											<option value="${varStatus.current}">${varStatus.current}</option>
										</c:forEach>
									</select>
							    </div>
							</div>
							<span id="errorGrade" style="color: red;text-align: center"></span>
							<!--电话-->
							<div class="form-group">
							    <label for="inputEmail3" class="col-sm-2 control-label">电话</label>
							    <div class="col-sm-10">
							      <input type="text" class="form-control" name="stuTel" id="tel" placeholder="Please Input Your Tel 例如:18738322951">
							    </div>
							</div>
							<span id="errorTel" style="color: red;text-align: center"></span>
						</div>
						
				        <div class="modal-footer">
				      		<button type="submit" id="submitForm" class="btn btn-primary">提交</button>
				        	<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				        </div>
			        </form>
			    </div>
			  </div>
			</div>
            
            
			<div style="height: 10px;"></div>
			<button type="button" data-toggle="modal" data-target="#myModal" class="btn btn-primary" style="margin-top: 10px;">&nbsp;&nbsp;添加学生&nbsp;&nbsp;</button>
			<button type="button" class="btn btn btn-success" style="margin-top: 10px;">将数据导出到Excel中</button>
			<div id="containers">
				<!--
	            	作者：offline
	            	时间：2019-02-16
	            	描述：条件选择
	            -->
				<form id="formSubmit" method="post" class="navbar-form navbar-left" role="search" action="${pageContext.request.contextPath}/student/selectStudentByCondition.do">
					<input type="hidden" name="pageNo" id="pageNo"/>
				<div class="dropdown" id="conditionDiv">
					
					<select class="form-control" id="searchType" name="searchType">
			    		<option value="">--请选择筛选条件--</option>
			    		<option value="stuNo">学号</option>
			    		<option value="stuName">姓名</option>
			    		<option value="specName">专业</option>
			    		<option value="deptName">系别</option>
			    	</select>
				</div>
				
				<!--
	            	作者：offline
	            	时间：2019-02-16
	            	描述：搜索
	            -->

				  <div class="form-group">
				    <input type="text" class="form-control" id="searchValue" name="searchValue" placeholder="Search">
				  </div>
				  <button type="submit" class="btn btn-default">提交</button>

				</form>
			</div>

			
			
			<!--
            	作者：offline
            	时间：2019-02-16
            	描述：数据
            -->
            <div style="clear: all;"></div>
			<h3 align="center">学生信息管理</h3>
			<table class="table table-bordered">
				<tr style="text-align: center; font-weight: bolder;">
				  <td class="info">学号</td>
				  <td class="info">姓名</td>
				  <td class="info">系别</td>
				  <td class="info">专业</td>
				  <td class="info">年级</td>
				  <td class="info">电话</td>
				  <td class="info" style="width: 200px;">操作</td>
				</tr>
				<c:forEach items="${page.data}" var="student">
					<tr style="text-align: center;">
						<td class="success">${student.stuNo}</td>
						<td class="success">${student.stuName}</td>
						<td class="success">${student.deptName}</td>
						<td class="success">${student.specName}</td>
						<td class="success">${student.stuGrade}</td>
						<td class="success">${student.stuTel}</td>
						<td class="success" style="width: 200px;">
							<a class="btn btn-primary" data-toggle="modal" onclick="modifyStudent(${student.stuId})" data-target="#myModal">修改</a>
							&nbsp;&nbsp;&nbsp;
							<a class="btn btn-danger del" data-toggle="modal" onclick="deleteStudent(${student.stuId})" data-target="#deleteModal">删除</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<!--
            	作者：offline
            	时间：2019-02-16
            	描述：删除的模态框
            -->
			<!-- Modal -->
			<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
			      </div>
			      <div class="modal-body">
			        删除成功...
			      </div>
			      <div class="modal-footer">
			        <button type="button" id="close" class="btn btn-default" data-dismiss="modal">Close</button>
			      </div>
			    </div>
			  </div>
			</div>
			<!--
            	作者：offline
            	时间：2019-02-16
            	描述：分页栏
            -->
			<div id="fenye">	
				<nav aria-label="Page navigation">
				  <ul class="pagination">
				  <li>
					  <a href="#" aria-label="first" id="first">
						  <span aria-hidden="true">首页</span>
					  </a>
				  </li>
				    <li>
				      <a href="#" aria-label="Previous" id="previous">
				       <span aria-hidden="true">上一页</span>
				      </a>
				    </li>
					  <c:forEach begin="1" end="${page.totalPage}" varStatus="varStatus">
						  <li><a href="#" class="numberLink">${varStatus.current}</a></li>
					  </c:forEach>
				    <li>
				      <a href="#" aria-label="Next" id="next">
				        <span aria-hidden="true">下一页</span>
				      </a>
				    </li>
					  <li>
						  <a href="#" aria-label="first" id="end">
							  <span aria-hidden="true">尾页</span>
						  </a>
					  </li>
					  <input type="hidden" id="totalPage" value="${page.totalPage}"/>
				  </ul>
				</nav>
			</div>
		</div>
	</body>
</html>
