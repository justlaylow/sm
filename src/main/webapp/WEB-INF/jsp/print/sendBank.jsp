<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 送 银 行 文 件 </title>
<style type="text/css">
	td {
	width: 80px;
	text-align: center;
	padding: 0 10px;
}
	th {
	text-align: center;
}
</style>
</head>
<body>
<div align="center">
	<h3 align="center">送 银 行 文 件</h3>
	<form action="/sm/exportBank" method="post">
		<table border="1" style="white-space: nowrap;">
			<thead>
				<tr>
					<th>银行账号</th>
					<th>姓名</th>
					<th>实得</th>
				</tr>
			</thead>
			<c:forEach var="send" items="${sendBank }">
				<tbody>
					<tr>
						<c:forEach var="emp" items="${send.calEmployee }">
							<td>${emp.bankAccount}</td>
						</c:forEach>
						<td>${send.calName}</td>
						<td>${send.calResult}</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
		<p align="center">
			<input type="submit" id="print" value="导出">
		</p>
	</form>
	<button id="back1">返回</button>
</div>
	
<script type="text/javascript">
	$('#back1').click(function(){
		window.location = "/sm/print";
	});
</script>
</body>
</html>