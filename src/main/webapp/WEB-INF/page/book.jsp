<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js" ></script>
		<script type="text/javascript">var  path = "${pageContext.request.contextPath}"</script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/res/book.js"></script>
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
        	描述：借书模态框
        -->
		<!-- Modal -->
			<div class="modal fade" id="borrowModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="myModalLabel">借书(Borrow)</h4>
			      </div>
			      <form class="form-horizontal" id="borrowBook" method="post" action="${pageContext.request.contextPath}/borrow/borrowBook.do">
					  <input type="hidden" name="bookId" id="borrowBookId"/>
					  <input type="hidden" name="stuId" id="borrowStuId"/>
					  <input type="hidden" name="islose" value="0">
				        <div class="modal-body">
				        	<!--图书编号-->
				     		<div class="form-group">
							    <label for="inputEmail3" class="col-sm-2 control-label">图书编号</label>
							    <div class="col-sm-10">
							      <input type="text" readonly="readonly" class="form-control" id="borrowBookNo" name="borrowBookNo" placeholder="Please Input BookNo">
							    </div>
							</div>
							<!--图书名称-->
				     		<div class="form-group">
							    <label for="inputEmail3" class="col-sm-2 control-label">图书名称</label>
							    <div class="col-sm-10">
							      <input type="text" class="form-control" id="borrowBookName" name="borrowBookName" placeholder="Please Input BookName">
							    </div>
							</div>
							<!-- 借阅时间 -->
				     		<div class="form-group">
							    <label for="inputEmail3" class="col-sm-2 control-label">开始时间</label>
							    <div class="col-sm-10">
							      <input type="date" class="form-control" id="startTime" name="startTime" placeholder="Please Select StartTime">
							    </div>
							</div>
							<!-- 还书时间 -->
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">还书时间</label>
								<div class="col-sm-10">
									<input type="date" class="form-control" id="endTime" name="endTime" placeholder="Please Select StartTime">
								</div>
							</div>
				        	<!--学号-->
				     		<div class="form-group">
							    <label for="inputEmail3" class="col-sm-2 control-label">学号</label>
							    <div class="col-sm-10">
							      <input type="text" class="form-control" id="stuNo" name="stuNo" placeholder="Please Input Your No 例如:15320474003">
							    </div>
							</div>
							<!--姓名-->
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">姓名</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="stuName" name="stuName" readonly="readonly">
								</div>
							</div>
							<span id="nameSpan" style="color: red;"></span>
				        </div>
			      <div class="modal-footer">
			      	<input id="submitForm" type="submit" class="btn btn-success" data-dismiss="modal" value="success" />
			        <button type="button" class="btn btn-default" data-dismiss="modal">close</button>
			      </div>
				  </form>
			    </div>
			  </div>
			</div>
		
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
			        <button type="button" id="deleteClose" class="btn btn-default" data-dismiss="modal">close</button>
			        
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
			        <h4 class="modal-title" id="myModalLabel">添加/修改(Add/Edit)</h4>
			      </div>
			        <form class="form-horizontal" id="bookForm" method="post" action="${pageContext.request.contextPath}/book/saveOrUpdateBook.do">
			        	<input type="hidden" name="bookId" id="bookId"/>
				    	<div class="modal-body">
							<!--图书编号-->
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">图书编号</label>
								<div class="col-sm-10">
									<input type="text" name="bookNo" class="form-control" id="bookNo" placeholder="Please Input bookNo ">
								</div>
							</div>
							<!--图书名称-->
							<div class="form-group">
							    <label for="inputEmail3" class="col-sm-2 control-label">图书名称</label>
							    <div class="col-sm-10">
							      <input type="text" name="bookName" class="form-control" id="bookName" placeholder="Please Input  bookName ">
							    </div>
							</div>

							<!--图书作者-->
							<div class="form-group">
							    <label for="inputEmail3" class="col-sm-2 control-label">图书作者</label>
							    <div class="col-sm-10">
							      <input type="text" name="bookAuthor" class="form-control" id="bookAuthor" placeholder="Please Input  bookAuthor ">
							    </div>
							</div>

							<!--图书分类 -->
							<div class="form-group">
							    <label for="inputEmail3" class="col-sm-2 control-label">图书分类</label>
							    <div class="col-sm-10">
							      <!--<input type="email" class="form-control" id="department" placeholder="Please Input Your Department 例如:机电工程学院">-->
							      	<select class="form-control" name="catalog1" id="catalog1">
							    		<option value="">--请选择--</option>
										<c:forEach items="${catalogList}" var="catalog">
											<option value="${catalog.cataId}">${catalog.cataName}</option>
										</c:forEach>
							    	</select>
							    </div>
							</div>

                            <div class="form-group">
                                <label for="inputEmail3" class="col-sm-2 control-label">二级分类</label>
                                <div class="col-sm-10">
                                    <select class="form-control" name="cataId" id="catalog2">
                                        <option>--请选择--</option>
                                    </select>
                                </div>
                            </div>

							<!--数量-->
							<div class="form-group">
							    <label for="inputEmail3" class="col-sm-2 control-label">图书数量</label>
							    <div class="col-sm-10">
							      <input type="text" name="bookNum" id="bookNum" class="form-control"  placeholder="Please Input BookNum">
							    </div>
							</div>

							<!--状态-->
							<div class="form-group">
							    <label for="inputEmail3" class="col-sm-2 control-label">图书状态</label>
							    <div class="col-sm-10">
							      <!--<input type="email" class="form-control" id="department" placeholder="Please Input Your Department 例如:机电工程学院">-->
							      	<select class="form-control" name="bookStatus" id="bookStatus">
							    		<option value="">--请选择--</option>
							    		<option value="1">上架</option>
							    		<option value="0">下架</option>
							    	</select>
							    </div>
							</div>

						</div>
						
				        <div class="modal-footer">
                            <input type="submit" class="btn btn-primary" value="提交">
				      		<button type="submit" id="formSubmit" class="btn btn-primary">提交</button>
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
                <button type="button" data-toggle="modal" data-target="#bookModal" class="btn btn-primary" style="margin-top: 10px; margin-left: 0px;">&nbsp;&nbsp;添加图书&nbsp;&nbsp;</button>
                <button type="button" class="btn btn btn-success" style="margin-top: 10px;">将数据导出到Excel中</button>

					<!--
                   作者：offline
                   时间：2019-02-16
                   描述：搜索
               -->
				<form class="navbar-form navbar-left" method="post" id="form" role="search" action="${pageContext.request.contextPath}/book/selectBookByCondition.do">
					<input type="hidden" name="pageNo" id="pageNo" value="${page.pageNo}"/>
					<div class="form-group">
						<input type="text" name="searchValue" value="${condition.searchValue}" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">提交</button>

					<div class="dropdown" id="conditionDiv">

						<select class="form-control" name="searchType">
							<option value="">--请选择筛选条件--</option>
							<option value="bookNo" <c:if test="${condition.searchType=='bookNo'}">selected="selected"</c:if>>编号</option>
							<option value="bookName" <c:if test="${condition.searchType=='bookName'}">selected="selected"</c:if>>书名</option>
							<option value="bookAuthor" <c:if test="${condition.searchType=='bookAuthor'}">selected="selected"</c:if>>作者</option>
							<option value="cataName" <c:if test="${condition.searchType=='cataName'}">selected="selected"</c:if>>分类</option>
							<option value="bookStatus" <c:if test="${condition.searchType=='bookStatus'}">selected="selected"</c:if>>状态(1:上架,2:下架)</option>
						</select>
					</div>
				</form>
			</div>
			<div id="search">
			</div>
			<!--
				作者：offline
				时间：2019-02-16
				描述：条件
			-->

			<h3 align="center">图书信息管理</h3>
			<table class="table table-bordered" >
				<tr class="danger">
					<td>编号</td>
					<td>书名</td>
					<td>作者</td>
					<td>分类</td>
					<td>数量</td>
					<td>状态</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${page.data}" var="book">
					<tr class="warning">
						<td>${book.bookNo}</td>
						<td>${book.bookName}</td>
						<td>${book.bookAuthor}</td>
						<td>${book.cataName}</td>
						<td>${book.bookNum}</td>
						<td>
							<c:if test="${book.bookStatus == 1}">
								上架
							</c:if>
							<c:if test="${book.bookStatus == 0}">
								下架
							</c:if>
						</td>
						<td>
							<a class="btn btn-success" data-toggle="modal" onclick="selectBook(${book.bookId})" data-target="#borrowModal">借阅</a>
							&nbsp;&nbsp;&nbsp;
							<a class="btn btn-primary" onclick="modifyBook(${book.bookId})" data-toggle="modal" data-target="#bookModal">修改</a>
							&nbsp;&nbsp;&nbsp;
							<a class="btn btn-danger del" onclick="deleteBookById(${book.bookId})" data-toggle="modal" data-target="#deleteModal">删除</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div id="fenye">
				<nav aria-label="Page navigation">
					<ul class="pagination">
						<li>
							<a href="#" aria-label="Previous" id="first">
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
							<a href="#" aria-label="end" id="end">
								<span aria-hidden="true">尾页</span>
							</a>
						</li>
					</ul>
				</nav>
				<input type="hidden" id="totalPage" value="${page.totalPage}"/>
			</div>
		</div>
	</body>
</html>
