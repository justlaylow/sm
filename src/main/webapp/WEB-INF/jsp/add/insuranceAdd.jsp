<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/header.jsp"%>
<%@ include file="/WEB-INF/jsp/include/background.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>保险金维护(单)</title>
<script type="text/javascript">
	//返回
	function back() {
		window.location.href = "/sm/select/ins";
	}
</script>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column" style="text-align: center">
				<h3 class="text-center text-info">保 险 金 维 护 (单)</h3>
				<!-- 添加保险 -->
				<form action="/sm/insert/ins" method="post" onsubmit="return checkAdd()">
					<table align="center"
						style="border-collapse: separate; border-spacing: 15px;white-space: nowrap;">
						<tr>
							<td><label>姓名:</label></td>
							<td><input name="insName" required="true" id="namecheck"></td>
							<td><label>工号:</label></td>
							<td><input name="insId" required="true" id="idcheck"></td>
						</tr>
						<tr>
							<td><label>性别:</label></td>
							<td><input name="insSex"></td>
							<td><label>身份证号:</label></td>
							<td><input name="insIden"></td>
						</tr>
						<tr>
							<td><label>保险基数:</label></td>
							<td><input name="insCarNumber"></td>
							<td><label>备注:</label></td>
							<td><input name="insRemark"></td>
						</tr>
						<tr>
							<td><label>养老保险:</label></td>
							<td><input name="insOld"></td>
							<td><label>养老投保地:</label></td>
							<td><input type="text" name="insurance"></td>
							
						</tr>
						<tr>
							<td><label>医疗保险:</label></td>
							<td><input name="insTreatments"></td>
							<td><label>医保投保地:</label></td>
							<td><input type="text" name="insSign"></td>
						</tr>
						<tr>
							<td><label>失业保险:</label></td>
							<td><input type="text" name="insUnemp"></td>
							<td><label>失业投保地:</label></td>
							<td><input name="insUnempAddress"></td>
						</tr>
						<tr>
							<td><label>公积金:</label></td>
							<td><input type="text" name="insAccFund"></td>
							<td><label>公积金投保地:</label></td>
							<td><input name="insAccAddress"></td>
						</tr>
						<tr>
							<td><label>大病医疗:</label></td>
							<td><input name="insIll"></td>
						</tr>
					</table>
					<button class="btn btn-default" type="button"
						onclick="back()">返回</button>
					<input class="btn btn-success" type="submit" value="添加">
				</form>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$('#calendar').dcalendarpicker({
			format : 'yyyy-mm-dd'
		});
		
		function checkAdd(){
			var id = $('#idcheck').val();
			var name = $('#namecheck').val();
			if(id==""){
				alert('工号不能为空');
				return false;
			}
			if(name==""){
				alert('姓名不能为空');
				return false;
			}
		}
	</script>
</body>
</html>