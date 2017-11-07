<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门管理</title>

<script type="text/javascript">
	//刷新
	function reload(){
		window.location.href="/sm/list/dep"; 
	}
	
	//删除信息
 	function del(userid){
 		if(confirm("您确认删除吗？")){   
            //如果确定删除就访问servlet，这里超链接传值传的是方法里的参数           
            window.location.href="/sm/delete/dep/?id="+userid;
        }
	}
</script>

</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<h3 class="text-center text-info">部门管理</h3>
				<br /> <br />
				<div class="input-group">
					编号：<input type="text" placeholder="Search for..."> <span>
						<button class="btn btn-default" type="button">搜索</button>
					</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 部门名称：<input type="text"
						placeholder="Search for..."> <span>
						<button class="btn btn-default" type="button">搜索</button>
					</span>
				</div>
				<br />

				
				<!-- 刷新 -->
				<button type="button" class="btn btn-primary" onclick="reload()">刷新</button>
				
				<!-- 添加部门 -->
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#myModal">添加部门</button>
				<div class="modal fade" id="myModal" data-backdrop="static"
					tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button data-dismiss="modal" class="close" type="button">
									<span aria-hidden="true">×</span><span class="sr-only">Close</span>
								</button>
								<h4 class="modal-title">添加</h4>
							</div>
							<div class="modal-body">
								<form action="/sm/insert/dep" method="post" id="fm">
									<label>部门编号:</label> <input name="depId" required="true"><br><br> 
									<label>部门名称:</label> <input name="depName" required="true"><br><br>
									<div class="modal-footer">
										<button data-dismiss="modal" class="btn btn-default"
											type="button">关闭</button>
										<input class="btn btn-primary" type="submit" value="添加">
									</div>
								</form>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
				
				
				



				<!-- 部门列表 -->
				<table class="table table-hover" id="datagrid">
					<thead>
						<tr>
							<th></th>
							<th>编号</th>
							<th>名称</th>
							<th>删除部门</th>
							<th>修改部门</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="dep" items="${listDep}">
							<tr>
								<!-- 和po类里的属性名一样 -->
								<td></td>
								<td>${dep.depId}</td>
								<td>${dep.depName}</td>
								<!-- 删除部门 -->
								<td><button type="button" id="deleteDep" class="btn btn-primary" onclick="del(${dep.id})">删除</button></td>
								
								<!-- 修改部门信息 -->
								<td><button type="button" id="updateDep" class="btn btn-primary" data-toggle="modal" data-target="#upd${dep.id}">修改</button>
									<div class="modal fade" id="upd${dep.id}" data-backdrop="static"
											tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<button data-dismiss="modal" class="close" type="button">
														<span aria-hidden="true">×</span><span class="sr-only">Close</span>
													</button>
													<h4 class="modal-title" align="center">修改</h4>
												</div>
												<div class="modal-body">
													<form action="/sm/update/dep" method="post" id="fm">
															<label style="display: none">id</label> <input style="display: none" name="id" id="Id" value="${dep.id}"> 
															<label>部门编号:</label> <input name="depId" id="dep_id" value="${dep.depId}"><br><br> 
															<label>部门名称:</label> <input name="depName" id="dep_name" value="${dep.depName}"><br><br>
															<div class="modal-footer">
															<button data-dismiss="modal" class="btn btn-default"
																type="button">关闭</button>
															<input class="btn btn-primary" type="submit" value="修改">
															</div>
													</form>
												</div>
											</div>
											<!-- /.modal-content -->
										</div>
										<!-- /.modal-dialog -->
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>




</body>
</html>