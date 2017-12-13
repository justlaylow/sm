<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/header.jsp"%>
<%@ include file="/WEB-INF/jsp/include/mainback.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="page-header">
					<h1>
						特力液压 <small>工资管理系统</small>
					</h1>
				</div>
				<form class="form-horizontal" role="form" action="/sm/login"
					method="post" id="myform" style="width: 500px;margin-left: 600px;">
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-10">
							<input class="form-control" id="loginname" name="loginname"
								type="text" required="true" style="width: 200px;"/>
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-10">
							<input class="form-control" id="password" name="password"
								type="password" required="true" style="width: 200px;"/>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<div class="checkbox">
								<label><input type="checkbox" />记住登录名和密码</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">登陆</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>