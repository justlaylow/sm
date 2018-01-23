<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport"
	content="width=device-width, 
             initial-scale=1.0, 
             maximum-scale=1.0, 
             user-scalable=no">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" />
	<meta http-equiv="X-UA-Compatible" content="IE=9" />
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
  	<script src="${path}/js/bootstrap/html5.js"></script>
    <script src="http://apps.bdimg.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<script type="text/javascript" src="${path}/js/jquery/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="${path}/js/bootstrap/bootstrap.js"></script>
<script type="text/javascript" src="${path}/js/calendar/dcalendar.picker.js"></script>
