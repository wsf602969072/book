<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/res/borrow.js" ></script>
		<script type="text/javascript">var path = "${pageContext.request.contextPath}"</script>
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
				width: 1000px;
				margin: 20px auto; 
				
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
			        <h4 class="modal-title" id="myModalLabel">删除图书(Delete)</h4>
			      </div>
			      <div class="modal-body">
			        删除成功...
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal" id="delClose">close</button>
			        
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
			<div class="modal fade" id="bookModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="myModalLabel">修改(Edit)</h4>
			      </div>
			        <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/borrow/UpdateBorrow.do">
                        <input type="hidden" name="borrowId" id="borrowId">
			        	<input type="hidden" name="stuId" id="stuId"/>
				    	<div class="modal-body">
							<!--图书名称-->
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">图书编号</label>
								<div class="col-sm-10">
									<input type="text" name="bookNo" class="form-control" readonly="readonly" id="bookNo" placeholder="Please Input  bookName ">
								</div>
							</div>
							<!--图书名称-->
							<div class="form-group">
							    <label for="inputEmail3" class="col-sm-2 control-label">图书名称</label>
							    <div class="col-sm-10">
							      <input type="text" name="bookName" class="form-control" readonly="readonly" id="bookName" placeholder="Please Input  bookName ">
							    </div>
							</div>
							<!--图书作者-->
							<div class="form-group">
							    <label for="inputEmail3" class="col-sm-2 control-label">图书作者</label>
							    <div class="col-sm-10">
							      <input type="text" name="bookAuthor" class="form-control" readonly="readonly" id="bookAuthor" placeholder="Please Input  bookAuthor ">
							    </div>
							</div>

							<!--状态-->
							<div class="form-group">
							    <label for="inputEmail3" class="col-sm-2 control-label">借阅状态</label>
							    <div class="col-sm-10">
							      <!--<input type="email" class="form-control" id="department" placeholder="Please Input Your Department 例如:机电工程学院">-->
							      	<select class="form-control" name="islose" id="islose">
							    		<option>--请选择--</option>
							    		<option value="1">丢失</option>
							    		<option value="0">正常</option>
										<option value="2">归还</option>
							    	</select>
							    </div>
							</div>
							<!--开始时间-->
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">开始时间</label>
								<div class="col-sm-10">
									<input type="date" name="startTime" class="form-control"  id="startTime" placeholder="Please Input  bookAuthor ">
								</div>
							</div>
							<!--学号-->
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">结束时间</label>
								<div class="col-sm-10">
									<input type="date" name="endTime" class="form-control"  id="endTime" placeholder="Please Input  bookAuthor ">
								</div>
							</div>

							<!--学号-->
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">学生学号</label>
								<div class="col-sm-10">
									<input type="text" name="stuNo" class="form-control"  id="stuNo" placeholder="Please Input  bookAuthor ">
								</div>
							</div>

							<!--姓名-->
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">学生姓名</label>
								<div class="col-sm-10">
									<input type="text" name="stuName" class="form-control" readonly="readonly" id="stuName" placeholder="Please Input  bookAuthor ">
								</div>
							</div>
						</div>
						
				        <div class="modal-footer">
				      		<button type="submit" class="btn btn-primary">提交</button>
				        	<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				        </div>
			        </form>
			    </div>
			  </div>
			</div>

		<div class="modal fade" id="bookLoseModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel">损坏处理(Edit)</h4>
					</div>
					<form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/lose/addLoseInfo.do">
						<input type="hidden" name="bookId" id="bookIdLose">
						<input type="hidden" name="stuId" id="stuIdLose"/>
						<input type="hidden" name="borrowId" id="borrowIdLose" />
						<div class="modal-body">
							<!--图书名称-->
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">图书编号</label>
								<div class="col-sm-10">
									<input type="text" name="bookNo" class="form-control" readonly="readonly" id="bookNoLose" placeholder="Please Input  bookName ">
								</div>
							</div>
							<!--图书名称-->
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">图书名称</label>
								<div class="col-sm-10">
									<input type="text" name="bookName" class="form-control" readonly="readonly" id="bookNameLose" placeholder="Please Input  bookName ">
								</div>
							</div>
							<!--学号-->
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">学生学号</label>
								<div class="col-sm-10">
									<input type="text" name="stuNo" class="form-control" readonly="readonly" id="stuNoLose" placeholder="Please Input  bookName ">
								</div>
							</div>
							<!--姓名-->
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">学生姓名</label>
								<div class="col-sm-10">
									<input type="text" name="stuName" class="form-control" readonly="readonly" id="stuNameLose" placeholder="Please Input  bookName ">
								</div>
							</div>
							<!--原因-->
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">丢失原因</label>
								<div class="col-sm-10">
									<input type="text" name="cause" class="form-control"  id="cause" placeholder="Please Input Cause ">
								</div>
							</div>

						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-primary">提交</button>
							<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="container">
			<div id="top">
				<!--
                	作者：offline
                	时间：2019-02-16
                	描述：添加
                -->
                <!--<button type="button" data-toggle="modal" data-target="#bookModal" class="btn btn-primary" style="margin-top: 10px; margin-left: 0px;">&nbsp;&nbsp;添加图书&nbsp;&nbsp;</button>-->
                <button type="button" class="btn btn btn-success" style="margin-top: 10px;">将数据导出到Excel中</button>
                
                <!--
                	作者：offline
                	时间：2019-02-16
                	描述：搜索
                -->



                <div id="search">
	                <form class="navbar-form navbar-left" role="search" method="post" id="form">
						<input type="hidden" name="pageNo" id="pageNo" value="${page.pageNo}">
					  	<div class="form-group">
					    	<input type="text" class="form-control" placeholder="Search" name="searchValue" value="${condition.searchValue}">
					  	</div>
						<div class="dropdown" id="conditionDiv">
							<select class="form-control" name="searchType">
								<option value="">--请选择筛选条件--</option>
								<option value="bookNo" <c:if test="${condition.searchType == 'bookNo'}">selected="selected"</c:if>>图书编号</option>
								<option value="bookName" <c:if test="${condition.searchType == 'bookName'}">selected="selected"</c:if>>图书名称</option>
								<option value="stuNo" <c:if test="${condition.searchType == 'stuNo'}">selected="selected"</c:if>>学生学号</option>
								<option value="stuName" <c:if test="${condition.searchType == 'stuName'}">selected="selected"</c:if>>学生姓名</option>
								<option value="islose" <c:if test="${condition.searchType == 'islose'}">selected="selected"</c:if>>借阅状态</option>
							</select>
						</div>
					  <button type="submit" class="btn btn-default">提交</button>
					</form>
                </div>
			</div>

			<h3 align="center">借阅信息管理</h3>
			<table class="table table-bordered">
			  	<tr class="danger">
			  		<td>图书编号</td>
			  		<td>图书书名</td>
			  		<td>图书作者</td>
			  		<td>借阅状态</td>
			  		<td>学生学号</td>
			  		<td>学生姓名</td>
			  		<td>操作</td>
			  	</tr>
				<c:forEach items="${page.data}" var="borrow">
				<tr class="warning">
					<td>${borrow.bookNo}</td>
			  		<td>${borrow.bookName}</td>
			  		<td>${borrow.bookAuthor}</td>
			  		<td>
						<c:if test="${borrow.islose == 0}">借阅中</c:if>
						<c:if test="${borrow.islose == 1}">丢失损坏</c:if>
						<c:if test="${borrow.islose == 2}">已经归还</c:if>
					</td>
			  		<td>${borrow.stuNo}</td>
			  		<td>${borrow.stuName}</td>
			  		<td>
						<a id="lose" class="btn btn-warning" data-toggle="modal" data-target="#bookLoseModal" onclick="loseBook(${borrow.borrowId},${borrow.bookId},${borrow.stuNo})">损坏</a>
						&nbsp;&nbsp;&nbsp;
			  			<a class="btn btn-success"  onclick="returnBookByBorrowId(${borrow.borrowId},${borrow.bookId})">还书</a>
			  			&nbsp;&nbsp;&nbsp;
			  			<a class="btn btn-primary" data-toggle="modal" data-target="#bookModal" onclick="selectBorrowById(${borrow.borrowId})">修改</a>
				  		&nbsp;&nbsp;&nbsp;
				  		<a class="btn btn-danger del" data-toggle="modal" data-target="#deleteModal" onclick="deleteBorrowById(${borrow.borrowId})">删除</a>
			  		</td>
				</tr>
				</c:forEach>
			</table>
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
						  <li><a href="#" class="numLink">${varStatus.current}</a></li>
					  </c:forEach>
				    <li>
				      <a href="#" aria-label="Next" id="next">
				        <span aria-hidden="true">下一页</span>
				      </a>
				    </li>
				  <li>
					  <a href="#" aria-label="end" id="end">
						  <span aria-hidden="true">尾页</span>
					  </a>
				  </li>
				  </ul>
				</nav>
				<input type="hidden" name="totalPage" id="totalPage" value="${page.totalPage}">
			</div>
	</body>
</html>
