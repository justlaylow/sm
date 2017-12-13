<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/mainback.jsp"%>
<%@ include file="/WEB-INF/jsp/include/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>工资管理系统</title>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<nav class="navbar navbar-default" role="navigation">
				

				<div class="collapse navbar-collapse">
					<h2 style="float: left;margin-top: 10px;color: blue;">首 页</h2>
					<h3 align="center" style="margin-top: 12px;color: blue;float: left;margin-left: 350px">特 力 液 压 工 资 管 理 系 统</h3>
					<a href="/sm/login.jsp" class="btn btn-link" style="margin-top: 10px;margin-left:300px">返回登陆</a>
				</div>

				</nav>
				<ul style="list-style-type: none;">
					<a href="/sm/allInform" class="btn btn-primary"><li>进入查询</li></a>
					<br><br>
					<a href="/sm/list/emp" class="btn btn-primary"><li>员工维护</li></a>
					<br><br>
					<a href="/sm/list/dep" class="btn btn-primary"><li>部门类别</li></a>
					<br><br>
					<a href="/sm/print" class="btn btn-primary"><li>工资打印</li></a>
					<br><br>
					<a href="/sm/select/ins" class="btn btn-primary"><li>保险金维护</li></a>
					<br><br>
					<a href="/sm/list/sal" class="btn btn-primary"><li>工资维护</li></a>
					<br><br>
					<a href="/sm/salary" class="btn btn-primary"><li>工资表数据导入</li></a>
					<br><br>
					<a href="/sm/exportExcel" class="btn btn-primary"><li>工资表数据导出</li></a>
					<br>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>