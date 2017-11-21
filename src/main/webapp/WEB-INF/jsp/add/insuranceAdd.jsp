<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>保险金维护(单)</title>
<script type="text/javascript">
	//返回
	function back(){
		window.location.href="/sm/select/ins"; 
	}
</script>
</head>
<body>
	<div style="text-align: center;">
		<h3>保险金维护(单)</h3>
		<!-- 添加保险 -->
		<form action="/sm/insert/ins" method="post">
			<table align="center" style="border-collapse:separate; border-spacing:15px;">
				<tr>
					<td><label>姓名:</label></td><td> <input name="insName" required="true"></td>
					<td><label>工号:</label></td><td> <input name="insId" required="true"></td>
				</tr>
				<tr>
					<td><label>性别:</label></td><td> <input name="insSex"></td>
					<td><label>出生日期:</label></td><td> <input type="text" name="insBoth" id="calendar"></td>
				</tr>
				<tr>
					<td><label>身份证号:</label></td><td> <input name="insIden"></td>
					<td><label>家庭住址:</label></td><td> <input type="text" name="insAddress" size="30px"></td>
				</tr>
				<tr>
					<td><label>保险基数:</label></td><td> <input name="insCarNumber"></td>
					<td><label>养老编号:</label></td><td> <input type="text" name="insOldId"></td>
				</tr>
				<tr>
					<td><label>养老保险:</label></td><td> <input name="insOld"></td>
					<td><label>医保编号:</label></td><td> <input type="text" name="insTreatmentId"></td>
				</tr>
				<tr>
					<td><label>医疗保险:</label></td><td> <input name="insTreatments"></td>
					<td><label>大病编号:</label></td><td> <input type="text" name="insIllId"></td>
				</tr>
				<tr>
					<td><label>大病医疗:</label></td><td> <input name="insIll"></td>
					<td><label>保险投保地:</label></td><td> <input type="text" name="insurance"></td>
				</tr>
				<tr>
					<td><label>失业编号:</label></td><td> <input name="insUnempId"></td>
					<td><label>失业保险:</label></td><td> <input type="text" name="insUnemp"></td>
				</tr>
				<tr>
					<td><label>失业投保地:</label></td><td> <input name="insUnempAddress"></td>
					<td><label>公积金:</label></td><td> <input type="text" name="insAccFund"></td>
				</tr>
				<tr>
					<td><label>公积金投保地:</label></td><td> <input name="insAccAddress"></td>
					<td><label>投标标志:</label></td><td> 保：<input type="radio" value="保"name="insSign">  
									不保：<input type="radio" value="不保"name="insSign"></td>
				</tr>
				<tr>
					<td><label>备注:</label></td><td> <input name="insRemark"></td>
				</tr>
			</table>
			<button data-dismiss="modal" class="btn btn-default"
				type="button" onclick="back()">返回</button>
			<input class="btn btn-primary" type="submit" value="添加">
		</form>
	</div>
	
<script type="text/javascript">
	$('#calendar').dcalendarpicker({
		format:'yyyy-mm-dd'
	});
</script>
</body>
</html>