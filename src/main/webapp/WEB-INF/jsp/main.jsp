<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jsp/include/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<nav class="navbar navbar-default" role="navigation">
				

				<div class="collapse navbar-collapse">
					<h2 style="float: left;margin-top: 10px;color: blue;">首页</h2>
					<h3 align="center" style="margin-top: 12px;color: blue;">特力液压工资管理系统</h3>
				</div>

				</nav>
				<ul>
					<a href="#"><li>初始化</li></a>
					<br>
					<a href="/sm/list/emp"><li>员工维护</li></a>
					<br>
					<a href="/sm/list/dep"><li>部门类别</li></a>
					<br>
					<a href="#"><li>工价工种维护</li></a>
					<br>
					<a href="/sm/select/ins"><li>保险金维护</li></a>
					<br>
					<a href="#"><li>人员岗位维护</li></a>
					<br>
					<a href="#"><li>工资维护</li></a>
					<br>
					<a href="/sm/salary"><li>工资表数据导入</li></a>
					<br>
					<a href="#"><li>工资表数据导出</li></a>
					<br>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>