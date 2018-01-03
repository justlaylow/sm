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
							<td><input name="insOld" id="old"></td>
							<td><label>养老投保地:</label></td>
							<td><input type="text" name="insurance" id="old1" style="display: none">
								<select id="old2" style="width: 175px;">
									<option style="display: none"></option>
									<option>常德</option>
									<option>长沙</option>
								</select>
							</td>
							
						</tr>
						<tr>
							<td><label>医疗保险:</label></td>
							<td><input name="insTreatments" id="treatment"></td>
							<td><label>医保投保地:</label></td>
							<td><input type="text" name="insSign" id="treatment1" style="display: none;">
								<select id="treatment2" style="width: 175px;">
									<option style="display: none"></option>
									<option>常德</option>
									<option>长沙</option>
								</select>
							</td>
						</tr>
						<tr>
							<td><label>失业保险:</label></td>
							<td><input type="text" name="insUnemp" id="unemp"></td>
							<td><label>失业投保地:</label></td>
							<td><input name="insUnempAddress" id="unemp1" style="display: none;">
								<select id="unemp2" style="width: 175px;">
									<option style="display: none"></option>
									<option>常德</option>
									<option>长沙</option>
								</select>
							</td>
						</tr>
						<tr>
							<td><label>公积金:</label></td>
							<td><input type="text" name="insAccFund" id="accfund"></td>
							<td><label>公积金投保地:</label></td>
							<td><input name="insAccAddress" id="accfund1" style="display: none;">
								<select id="accfund2" style="width: 175px;">
									<option style="display: none"></option>
									<option>常德</option>
									<option>长沙</option>
								</select>
							</td>
						</tr>
						<tr>
							<td><label>大病医疗:</label></td>
							<td><input name="insIll" id="ill"></td>
							<td><label>工伤投保地:</label></td>
							<td><input name="insTreatmentId" id="injury1" style="display: none;">
								<select id="injury2" style="width: 175px;">
									<option style="display: none"></option>
									<option>常德</option>
									<option>长沙</option>
								</select>
							</td>
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
			var old = $('#old').val();
			var treatment = $('#treatment').val();
			var unemp = $('#unemp').val();
			var accfund = $('#accfund').val();
			var ill = $('#ill').val();
			if(id==""){
				alert('工号不能为空');
				return false;
			}
			if(name==""){
				alert('姓名不能为空');
				return false;
			}
			if(old==""){
				alert('养老保险不能为空');
				return false;
			}
			if(treatment==""){
				alert('医保不能为空');
				return false;
			}
			if(ill==""){
				alert('大病医疗不能为空');
				return false;
			}
			if(unemp==""){
				alert('失业保险不能为空');
				return false;
			}
			if(accfund==""){
				alert('公积金不能为空');
				return false;
			}
		}
		
		$('#old2').change(function(){
			var value = $('#old2 option:selected').text();
			$('#old1').val(value);
		})
		
		$('#treatment2').change(function(){
			var value = $('#treatment2 option:selected').text();
			$('#treatment1').val(value);
		})
		
		$('#unemp2').change(function(){
			var value = $('#unemp2 option:selected').text();
			$('#unemp1').val(value);
		})
		
		$('#accfund2').change(function(){
			var value = $('#accfund2 option:selected').text();
			$('#accfund1').val(value);
		})
		
		$('#injury2').change(function(){
			var value = $('#injury2 option:selected').text();
			$('#injury1').val(value);
		})
	</script>
</body>
</html>