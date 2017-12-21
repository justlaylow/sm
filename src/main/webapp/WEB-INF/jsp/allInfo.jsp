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
							style="border-collapse: separate; border-spacing: 15px;white-space: nowrap;">
							<tr>
								<c:forEach var="cal" items="${all.salSalaryList }">
									<td><label>姓名:</label></td>
									<td><input name="calName" required="true"
										value="${cal.calName}"></td>
									<td><label>工号:</label></td>
									<td><input name="salId" required="true"
										value="${all.salId}" readonly="readonly"></td>
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
								<td><label>Gzsj:</label></td>
								<td><input name="calDate"
									value="<fmt:formatDate value="${cal.calDate}" type="date"/>" readonly="readonly"></td>
								<td><label>SAP账号:</label></td>
								<td><input type="text" name="salOa" value="${all.salOa}"></td>
								<td><label>统计类别:</label></td>
								<td><input type="text" name="staCategory"
									value="${all.staCategory}"></td>
							</tr>
							<tr>
								<td><label>基本工资:</label></td>
								<td><input type="text" name="calBasic"
									value="${cal.calBasic}"></td>
								<td><label>岗位工资:</label></td>
								<td><input name="calPost" value="${cal.calPost}"></td>
								<td><label>系数:</label></td>
								<td><input type="text" name="calCoefficient"
									value="${cal.calCoefficient}"></td>
							</tr>
							<tr>
								<td><label>效益工资:</label></td>
								<td><input name="calBenefitwage"
									value="${cal.calBenefitwage}"></td>
								<td><label>奖金:</label></td>
								<td><input type="text" name="calBonus"
									value="${cal.calBonus}"></td>
								<td><label>工时工资:</label></td>
								<td><input type="text" name="calManhourSalary"
									value="${cal.calManhourSalary}"></td>
							</tr>
							<tr>
								<td><label>加班:</label></td>
								<td><input name="calOvertime" value="${cal.calOvertime}"></td>
								<td><label>津贴:</label></td>
								<td><input type="text" name="calBenefit"
									value="${cal.calBenefit}"></td>
								<td><label>考评工资:</label></td>
								<td><input type="text" name="calCheck"
									value="${cal.calCheck}"></td>
							</tr>
							<tr>
								<td><label>工伤产假:</label></td>
								<td><input name="calInjury" value="${cal.calInjury}"></td>
								<td><label>缺勤:</label></td>
								<td><input type="text" name="calLeave"
									value="${cal.calLeave}"></td>
								<td><label>其他:</label></td>
								<td><input name="calOther" value="${cal.calOther}"></td>
							</tr>
							<tr>
								<td><label>会费:</label></td>
								<td><input type="text" name="calDues"
									value="${cal.calDues}"></td>
								<c:forEach var="ins" items="${all.salInsuranceList }">
									<td><label>养老保险:</label></td>
									<td><input name="insOld" value="${ins.insOld}"></td>
									<td><label>医保:</label></td>
									<td><input type="text" name="insTreatments"
										value="${ins.insTreatments}"></td>
							</tr>
							<tr>
								<td><label>失业:</label></td>
								<td><input name="insUnemp" value="${ins.insUnemp}"></td>
								<td><label>大病:</label></td>
								<td><input type="text" name="insIll" value="${ins.insIll}"></td>
								<td><label>罚款:</label></td>
								<td><input type="text" name="calPenalty"
									value="${cal.calPenalty}"></td>
							</tr>
							<tr>
								<td><label>扣款:</label></td>
								<td><input name="calWithhold" value="${cal.calWithhold}"></td>
								<td><label>水电:</label></td>
								<td><input name="calWaterandele"
									value="${cal.calWaterandele}"></td>
								<td><label>公积金:</label></td>
								<td><input type="text" name="insAccFund"
									value="${ins.insAccFund}"></td>
								</c:forEach>
							</tr>
							<tr>
								<td><label>上月扣款:</label></td>
								<td><input name="calLastWithhold"
									value="${cal.calLastWithhold}"></td>
								<td><label>所得税:</label></td>
								<td><input type="text" name="calIncometax"
									value="${cal.calIncometax}"></td>
								<td><label>工时:</label></td>
								<td><input name="calManhour" value="${cal.calManhour}"></td>
							</tr>
							<tr>
								<td><label>工价:</label></td>
								<td><input type="text" name="labourCost"
									value="${cal.labourCost}"></td>
								<td><label>餐补:</label></td>
								<td><input name="calAllowance" value="${cal.calAllowance}"></td>
								<td><label>司龄工资:</label></td>
								<td><input type="text" name="calComage"
									value="${cal.calComage}"></td>
							</tr>
							<tr>
								<td><label>保密工资:</label></td>
								<td><input name="calSecrecy" value="${cal.calSecrecy}"></td>
								<td><label>应发工资:</label></td>
								<td><input type="text" name="calShould"
									value="${cal.calShould}"></td>
								<td><label>技能等级:</label></td>
								<td><input type="text" name="salSkilllevel"
									value="${all.salSkilllevel}"></td>
							</tr>
							<tr>
								<td><label>技能工资:</label></td>
								<td><input name="calSkillLevel"
									value="${cal.calSkillLevel}" id="calSkill">
									<input name="salSkillSalary" style="display: none;" id="salSkill"></td>
								<td><label>实得:</label></td>
								<td><input name="calResult" value="${cal.calResult}"></td>
							</tr>
							</c:forEach>
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
		
		//ie中input只读bug处理,按退格键会触发history.back()方法
		$("input[readOnly]").keydown(function(e) {
            e.preventDefault();
       });
		
	</script>
	
</body>
</html>