<!DOCTYPE html>
<html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
<head>
<title>工资管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport"
	content="width=device-width, 
             initial-scale=1.0, 
             maximum-scale=1.0, 
             user-scalable=no">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" />
<script type="text/javascript">
    var path = "${path}";
</script>

<!-- 引入公共的Js和Css -->
<link rel="stylesheet" type="text/css"
	href="${path}/css/bootstrap/3.3.6/bootstrap.min.css">
<link rel="stylesheet"
	href="${path}/css/bootstrap/3.3.6/bootstrap-theme.min.css">
<link rel="stylesheet" href="${path}/css/calendar/dcalendar.picker.css"/>
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
  	<script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<script type="text/javascript" src="${path}/js/jquery/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="${path}/js/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript" src="${path}/js/calendar/dcalendar.picker.js"></script>

</head>
<body>
	<!-- 背景 -->
	<div id="Layer1" style="position:absolute; width:100%; height:100%; background-color: #22C3AA; z-index:-1" >      
		<img src="${path}/img/background5.jpg" height="100%" width="100%"/>      
	</div>
	<!-- bootstrap格栅布局 -->
	
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