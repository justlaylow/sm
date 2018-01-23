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
	共有${requestScope.pageBean.totalRecord }个员工,共${requestScope.pageBean.totalPage }页,当前为${requestScope.pageBean.pageNum}页
	<br/>
	<a href="/sm/xxx?pageNum=1">首页</a>
</body>
</html>