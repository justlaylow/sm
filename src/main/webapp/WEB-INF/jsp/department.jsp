<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门管理</title>


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
				<br /> <br />
				<table class="table table-hover">
					<thead>
						<tr>
							<th></th>
							<th>编号</th>
							<th>名称</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="dep" items="${listDep}">
							<tr>
								<!-- 和po类里的属性名一样 -->
								<td></td>
								<td>${dep.depId}</td>
								<td>${dep.depName}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>