<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
<meta name="viewport"
	content="width=device-width, 
             initial-scale=1.0, 
             maximum-scale=1.0, 
             user-scalable=no">

<script type="text/javascript">
    var path = "${path}";
</script>

<!-- 引入公共的Js和Css -->
<script type="text/javascript" src="${path}/js/jquery/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${path}/css/bootstrap/3.3.6/bootstrap.min.css">
<link rel="stylesheet"
	href="${path}/css/bootstrap/3.3.6/bootstrap-theme.min.css">
<script type="text/javascript" src="${path}/js/bootstrap/bootstrap.min.js"></script>