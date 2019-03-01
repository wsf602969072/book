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
        <script type="text/javascript" src="${pageContext.request.contextPath}/res/lose.js" ></script>
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
				width: 300px;
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
			        <button type="button" id="close" class="btn btn-default" data-dismiss="modal">close</button>
			        
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
			        <form class="form-horizontal">
			        	<input type="hidden" name="stuId" id="stuId"/>
				    	<div class="modal-body">
				      		
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
							<!--图片上传-->
							  <div class="form-group" >
							  	<label for="inputEmail3" class="col-sm-2 control-label" style="float: left;margin-right:16px;">图书作者</label>
							    <input type="file" id="exampleInputFile" style="float: left;">
								<img width="150px" height="150px" border="1" />
							  </div>
							<!--图书分类 -->
							<div class="form-group">
							    <label for="inputEmail3" class="col-sm-2 control-label">图书分类</label>
							    <div class="col-sm-10">
							      <!--<input type="email" class="form-control" id="department" placeholder="Please Input Your Department 例如:机电工程学院">-->
							      	<select class="form-control" name="catalog">
							    		<option>--请选择--</option>
							    		<option>生活</option> 
							    		<option>计算机</option> 
							    		<option>国学</option> 
							    		<option>机械</option> 
							    		<option>生物学</option> 
							    		<option>物理学</option> 
							    		<option>经济学</option> 
							    	</select>
							    </div>
							</div>
							<!--数量-->
							<div class="form-group">
							    <label for="inputEmail3" class="col-sm-2 control-label">图书数量</label>
							    <div class="col-sm-10">
							      <input type="text" name="bookNum" id="bookNum" class="form-control" id="grade" placeholder="Please Input BookNum">
							    </div>
							</div>
							<!--状态-->
							<div class="form-group">
							    <label for="inputEmail3" class="col-sm-2 control-label">图书状态</label>
							    <div class="col-sm-10">
							      <!--<input type="email" class="form-control" id="department" placeholder="Please Input Your Department 例如:机电工程学院">-->
							      	<select class="form-control" name="bookStatus">
							    		<option>--请选择--</option>
							    		<option>上架</option> 
							    		<option>下架</option> 
							    	</select>
							    </div>
							</div>
						</div>
						
				        <div class="modal-footer">
				      		<button type="button" class="btn btn-primary">提交</button>
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
				<form class="navbar-form navbar-left" role="search" id="form" method="post">
					<input type="hidden" name="pageNo" id="pageNo" value="${page.pageNo}">
                <!--
                	作者：offline
                	时间：2019-02-16
                	描述：搜索
                -->
                <div id="search">
					  <div class="form-group">
					    <input type="text" class="form-control" name="searchValue" placeholder="Search">
					  </div>
					  <button type="submit" class="btn btn-default">提交</button>
                </div>
                <!--
                	作者：offline
                	时间：2019-02-16
                	描述：条件
                -->
                <div class="dropdown" id="conditionDiv">
					<select class="form-control" name="searchType">
			    		<option value="">--请选择筛选条件--</option>
			    		<option value="bookNo">图书编号</option>
			    		<option value="stuNo">学生编号</option>

			    	</select>
				</div>
				</form>

			</div>
			
			<h3 align="center">丢失损坏管理</h3>
			<table class="table table-bordered">
			  	<tr class="danger">
			  		<td>图书编号</td>
			  		<td>图书书名</td>
			  		<td>图书分类</td>
			  		<td>学生学号</td>
			  		<td>学生姓名</td>
					<td>处理状态</td>
			  		<td>操作</td>
			  	</tr>
				<c:forEach items="${page.data}" var="lose">
					<tr class="warning">
						<td>${lose.bookNo}</td>
						<td>${lose.bookName}</td>
						<td>${lose.bookAuthor}</td>
						<td>${lose.stuNo}</td>
						<td>${lose.stuName}</td>
						<td>
							<c:if test="${lose.isDeal==1}">
								处理成功
							</c:if>
							<c:if test="${lose.isDeal == 0}">
								待处理
							</c:if>
						</td>
						<td>
							<a class="btn btn-primary" onclick="dealLoseById(${lose.loseId})">处理</a>
							&nbsp;&nbsp;&nbsp;
							<a class="btn btn-danger del" data-toggle="modal" data-target="#deleteModal" onclick="deleteLoseById(${lose.loseId})">删除</a>
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
                          <a href="#" aria-label="Previous" id="first">
                              <span aria-hidden="true">首页</span>
                          </a>
                      </li>
				    <li>
				      <a href="#" aria-label="Previous">
				        <span aria-hidden="true">上一页</span>
				      </a>
				    </li>
				    <c:forEach begin="1" end="${page.totalPage}" varStatus="varStatus">
                        <li><a href="#" class="numLink">${varStatus.current}</a></li>
                    </c:forEach>
				    <li>
				      <a href="#" aria-label="Next">
				        <span aria-hidden="true">下一页</span>
				      </a>
				    </li>
                      <li>
                          <a href="#" aria-label="Next" id="end">
                              <span aria-hidden="true">尾页</span>
                          </a>
                      </li>
				  </ul>
                    <input type="hidden" id="totalPage" name="totalPage" value="${page.totalPage}">
				</nav>
			</div>
	</body>
</html>
