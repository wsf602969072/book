<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js" ></script>
		<script type="text/javascript">var path ="${pageContext.request.contextPath}"</script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/res/user.js"></script>
		<script type="text/javascript">

		</script>
		<style type="text/css">
			td{
				text-align: center;
			}
			#top{
				margin-top: 10px;
			}
			
			#search{
				float: right;
			}
			#conditionDiv{
				float: right;
				position: relative;
				top: 10px;
			}
			#fenye{
				width: 310px;
				margin: 20px auto; 
				
			}
			table tr:hover{
				background-color: yellow;
			}
		</style>
	</head>
	
	<body>
		<!--
        	作者：offline
        	时间：2019-02-16
        	描述：删除模态框
        -->
		<!-- Modal -->
		<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
			<div class="modal-content">
			  <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title" id="myModalLabel">删除用户(Delete)</h4>
			  </div>
			  <div class="modal-body">
				删除成功...
			  </div>
			  <div class="modal-footer">

						<button type="submit" id="close" class="btn btn-default" data-dismiss="modal">close</button>

			  </div>
			</div>
		  </div>
		</div>
		<!--
			作者：offline
			时间：2019-02-16
			描述：增加学生模态框
		-->

		<!-- Modal -->
		<div class="modal fade" id="userModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
			<div class="modal-content">
			  <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title" id="myModalLabel">添加(Add)</h4>
			  </div>
				<form class="form-horizontal" id="formAddEdit" method="post" action="${pageContext.request.contextPath}/user/saveOrUpdate.do">
					<input type="hidden" name="userId" id="userId"/>
					<div class="modal-body">
						<!--username-->
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">Username:</label>
							<div class="col-sm-10">
							  <input type="text" name="username" class="form-control" id="username" placeholder="Please Input Username ">
							</div>
						</div>
						<span id="errorUsername" style="color: red;text-align: center"></span>
						<!--password-->
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">Password:</label>
							<div class="col-sm-10">
							  <input type="text" name="password" id="password" class="form-control" placeholder="Please Input  Your Password ">
							</div>
						</div>
						<span id="errorPassword" style="color: red;text-align: center"></span>
						<!--姓名-->
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">Name:</label>
							<div class="col-sm-10">
							  <input type="text" name="name" id="name" class="form-control"  placeholder="Please Input  Your Name ">
							</div>
						</div>
						<span id="errorName" style="color: red;text-align: center"></span>
						<!--住处-->
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">Address:</label>
							<div class="col-sm-10">
							  <input type="text" name="address" id="address" class="form-control" placeholder="Please Input Your Address">
							</div>
						</div>
						<span id="errorAddress" style="color: red;text-align: center"></span>
						<!--手机号-->
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">Tel:</label>
							<div class="col-sm-10">
							  <input type="text" name="tel" id="tel" class="form-control" placeholder="Please Input Your Tel">
							</div>
						</div>
						<span id="errorPhone" style="color: red;text-align: center"></span>
						<!--级别 -->
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">Privilege:</label>
							<div class="col-sm-10">

								<select class="form-control" name="privilege" id="privilege">
									<option value="">-- Please Select --</option>
									<option value="0">General</option>
									<option value="1">Admin</option>
								</select>
							</div>
						</div>

						<span id="errorPrivilege" style="color: red;text-align: center"></span>
					</div>

					<div class="modal-footer">
						<button type="submit" class="btn btn-primary" id="addSubmit">提交</button>
						<button type="reset" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
				</form>
			</div>
		  </div>
		</div>


        <div class="container">
			<form action="${pageContext.request.contextPath}/user/selectUserByCondition.do" method="post" id="form" >
            	<input type="hidden" name="pageNo" id="pageNo" value="${page.pageNo}">
				<div id="top">
                <!--
                    作者：offline
                    时间：2019-02-16
                    描述：添加
                -->
                <button type="button" data-toggle="modal" data-target="#userModal" class="btn btn-primary" style="margin-top: 10px; margin-left: 0px;">&nbsp;&nbsp;添加用户&nbsp;&nbsp;</button>
                <button type="button" class="btn btn btn-success" style="margin-top: 10px;">将数据导出到Excel中</button>
                <!--
                    作者：offline
                    时间：2019-02-16
                    描述：搜索
                -->

                <div id="search">
                      <div class="form-group">
                        <input id="searchValue"  name="searchValue" type="text" class="form-control" placeholder="Search">
						  <button id="searchSubmit" type="submit" class="btn btn-default">提交</button>
					  </div>

                </div>
                <!--
                    作者：offline
                    时间：2019-02-16
                    描述：条件
                -->
                <div class="dropdown" id="conditionDiv">
                    <select class="form-control" name="searchType" id="searchSelect">
                        <option>--请选择筛选条件--</option>
                        <option value="userId">编号</option>
                        <option value="name">姓名</option>
                        <option value="privilege">级别</option>
                    </select>
                </div>
            </div>

            <h3 align="center">用户信息管理</h3>
            <table class="table table-bordered" border="1">
                <tr class="danger">
                    <td>编号</td>
                    <td>用户账号</td>
                    <td>姓名</td>
                    <td>手机号</td>
                    <td>住处</td>
                    <td>用户级别</td>
                    <td>操作</td>
                </tr>

                <c:forEach items="${requestScope.page.data}" var="u">
                <tr class="warning">
                    <td>${u.userId }</td>
                    <td>${u.username }</td>
                    <td>${u.name }</td>
                    <td>${u.tel }</td>
                    <td>${u.address }</td>
                    <td>
                        <c:if test="${u.privilege==1}">管理员</c:if>
                        <c:if test="${u.privilege==0}">普通用户</c:if>
                    </td>
                    <td>
                        <a id="alter" class="btn btn-primary" data-toggle="modal" data-target="#userModal" onclick="modify(${u.userId })">修改</a>
                        &nbsp;&nbsp;&nbsp;
                        <a class="btn btn-danger del" data-toggle="modal" data-target="#deleteModal" onclick="deleteUser(${u.userId})">删除</a>
                    </td>
                </tr>
                </c:forEach>
            </table>
        <!--
            作者：offline
            时间：2019-02-16
            描述：分页栏
        -->
            <div id="fenye">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
						<li><a id="first" href="#">首页</a></li>
                        <li>
                            <a href="#" aria-label="Previous" id="previous">
                                <span aria-hidden="true">上一页</span>
                            </a>
                        </li>
						<c:forEach begin="1" end="${page.totalPage}" varStatus="varStatus">
							<li><a class="numLink" href="#">${varStatus.current}</a></li>
						</c:forEach>
                        <%--<li><a class="numLink" href="#">1</a></li>
                        <li><a class="numLink" href="#">2</a></li>
                        <li><a class="numLink" href="#">3</a></li>
                        <li><a class="numLink" href="#">4</a></li>
                        <li><a class="numLink" href="#">5</a></li>--%>
                        <li>
                            <a href="#" aria-label="Next" id="next">
                                <span aria-hidden="true">下一页</span>
                            </a>
                        </li>
						<input type="hidden" id="totalPage" value="${page.totalPage}"/>
						<li><a id="end" href="#">尾页</a></li>
                    </ul>
                </nav>

            </div>
			</form>
        </div>
	</body>
</html>
