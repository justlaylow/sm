<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/header.jsp"%>
<%@ include file="/WEB-INF/jsp/include/background.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询</title>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column" style="text-align: center">
				<h3>工 资 查 询</h3>
				<!-- 添加保险 -->
				<form action="/sm/list/all" method="post">
					工号：<input name="salId" value="${param.salId}">
					姓名：<input name="salName" value="${param.salName}"> 
					工资日期：<input name="calDate" tyep="text" id="mydatepicker"> 
					<input type="submit" value="查询" id="find">
					<input id="maxMonth" value="${maxMonth}" style="display: none;">
					<input id="checkMonth" value="${param.calDate}" style="display: none;">
					<button type="button" onclick="back()">返回</button>
				</form>
				<c:forEach var="all" items="${listAll }">
					<form action="/sm/allInfo" method="post">
						<table align="center"
							style="border-collapse: separate; border-spacing: 15px;">
							<tr>
									<td><label>姓名:</label></td>
									<td><input name="calName" required="true"
										value="${cal.calName}"></td>
									<td><label>工号:</label></td>
									<td><input name="salId" required="true"
										value="${all.salId}"></td>
									<td><label>银行账号:</label></td>
									<td><input name="bankAccount" value="${all.bankAccount}"
										size="30px"></td>
							</tr>
							<tr>
								<td><label>岗位类别:</label></td>
								<td><input type="text" name="postCategory"
									value="${all.postCategory}"></td>
								<td><label>部门代码:</label></td>
								<td><input name="salDep" value="${all.salDep}"></td>
								<td><label>岗位:</label></td>
								<td><input type="text" name="salPost"
									value="${all.salPost}"></td>
							</tr>
							<tr>
								<td><label>SAP账号:</label></td>
								<td><input type="text" name="salOa" value="${all.salOa}"></td>
								<td><label>统计类别:</label></td>
								<td><input type="text" name="staCategory"
									value="${all.staCategory}"></td>
							</tr>
						</table>
						<input class="btn btn-success" type="submit" value="修改" id="updateAll">
						<button class="btn btn-warning" type="button"
							onclick="del('${all.salId}')">删除员工</button>
						
						<script type="text/javascript">
							//最大日期显示修改按钮	
							$(function() {
								var dt = $("#checkMonth").val();
								var maxmonth = $("#maxMonth").val();
								 if($.trim(dt) == $.trim(maxmonth)){
									$("#updateAll").show();
								}else{
									$("#updateAll").hide();
								}
							});
						</script>
					</form>
				</c:forEach>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		//返回
		function back() {
			window.location.href = "/sm/main";
		}

		//删除
		function del(salId) {
			if (confirm("确定删除吗？")) {
				window.location.href = "/sm/allInfo/del?salId=" + salId;
			}

		}

		//bootstrap日期选择
		$('#mydatepicker').dcalendarpicker({
			format : 'yyyy-mm-dd'
		});
		
		$('#find').click(function(){
		var salDate = $('#mydatepicker').val();
		var reg = /^[0-9]{4}-(0[1-9]|[1-9]|1[0-2])-(0[1-9]|[1-9]|[1-2][0-9]|3[0-1])$/;
		if(reg.test(salDate)!=true){
			confirm("日期格式或时间出错 xxxx-xx-xx");
		}
		});
		
		
	</script>
	
</body>
</html>