<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 工 资 条 </title>
<style type="text/css">
	td {
	text-align: center;
	padding-left: 5px;
	padding-right: 5px;
}
	th {
	text-align: center;
	padding-left: 5px;
	padding-right: 5px;
}
</style>
</head>
<body>
	<table border="1" style="white-space: nowrap;">
		<c:forEach var="all" items="${listByDepName }">
			<thead>
				<tr>
					<th>部门</th>
					<th>工号</th>
					<th>姓名</th>
					<th>岗位</th>
					<th>基本工资</th>
					<th>岗位工资</th>
					<th>司龄工资</th>
					<th>保密工资</th>
					<th>技能等级</th>
					<th>技能工资</th>
					<th>系数</th>
					<th>效益工资</th>
					<th>工价</th>
					<th>工时</th>
					<th>工时工资</th>
					<th>加班</th>
					<th>奖金</th>
					<th>考评工资</th>
					<th>津贴</th>
					<th>考勤扣款</th>
					<th>工伤产假</th>
					<th>罚款</th>
					<th>其它</th>
					<th>应发工资</th>
					<th>会费</th>
					<th>养老</th>
					<th>医保</th>
					<th>大病</th>
					<th>失业</th>
					<th>公积金</th>
					<th>水电</th>
					<th>扣款</th>
					<th>下月扣款</th>
					<th>所得税</th>
					<th>扣款合计</th>
					<th>实得工资</th>
					<th>餐补</th>
					<th>合计</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${all.salDep}</td>
					<td>${all.salId }</td>
					<td>${all.salName}</td>
					<td>${all.salPost}</td>
					<c:forEach var="cal" items="${all.salSalaryList}">
						<c:if test="${all.salId==cal.calId }">
							<td>${cal.calBasic}</td>
							<td>${cal.calPost}</td>
							<td>${cal.calComage}</td>
							<td>${cal.calSecrecy}</td>
							<td>${all.salSkilllevel}</td>
							<td>${cal.calSkillLevel}</td>
							<td>${cal.calCoefficient}</td>
							<td>${cal.calBenefitwage}</td>
							<td>${cal.labourCost}</td>
							<td>${cal.calManhour}</td>
							<td>${cal.calManhourSalary}</td>
							<td>${cal.calOvertime}</td>
							<td>${cal.calBonus}</td>
							<td>${cal.calCheck}</td>
							<td>${cal.calBenefit}</td>
							<td>${cal.calLeave}</td>
							<td>${cal.calInjury}</td>
							<td>${cal.calPenalty}</td>
							<td>${cal.calOther}</td>
							<td>${cal.calShould}</td>
							<td>${cal.calDues}</td>
							<c:forEach var="ins" items="${all.salInsuranceList }">
								<td>${ins.insOld}</td>
								<td>${ins.insTreatments}</td>
								<td>${ins.insIll}</td>
								<td>${ins.insUnemp}</td>
								<td>${ins.insAccFund}</td>
							</c:forEach>
							<td>${cal.calWaterandele}</td>
							<td>${cal.calWithhold}</td>
							<td>${cal.calLastWithhold}</td>
							<td>${cal.calIncometax}</td>
							<td>${cal.calTotal}</td>
							<td>${cal.calResult}</td>
							<td>${cal.calAllowance}</td>
							<td><fmt:formatNumber type="number" value="${cal.calResult+cal.calAllowance}" pattern="0.00" maxFractionDigits="2"/></td>
						</c:if>
					</c:forEach>
				</tr>
			</tbody>
		</c:forEach>
		
		
			<thead>
				<tr>
					<th></th>
					<th></th>
					<th>合计</th>
					<th></th>
					<th>基本工资</th>
					<th>岗位工资</th>
					<th>司龄工资</th>
					<th>保密工资</th>
					<th>技能等级</th>
					<th>技能工资</th>
					<th>系数</th>
					<th>效益工资</th>
					<th>工价</th>
					<th>工时</th>
					<th>工时工资</th>
					<th>加班</th>
					<th>奖金</th>
					<th>考评工资</th>
					<th>津贴</th>
					<th>考勤扣款</th>
					<th>工伤产假</th>
					<th>罚款</th>
					<th>其它</th>
					<th>应发工资</th>
					<th>会费</th>
					<th>养老</th>
					<th>医保</th>
					<th>大病</th>
					<th>失业</th>
					<th>公积金</th>
					<th>水电</th>
					<th>扣款</th>
					<th>下月扣款</th>
					<th>所得税</th>
					<th>扣款合计</th>
					<th>实得工资</th>
					<th>餐补</th>
					<th>合计</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td></td>
					<td></td>
					<td>部门合计</td>
					<td></td>
					<td>${summing.basic}</td>
					<td>${summing.post}</td>
					<td>${summing.comage}</td>
					<td>${summing.secrecy}</td>
					<td></td>
					<td>${summing.skillSalary}</td>
					<td></td>
					<td>${summing.benefit}</td>
					<td>${summing.labourCost}</td>
					<td>${summing.manhour}</td>
					<td>${summing.manhourSalary}</td>
					<td>${summing.overtime}</td>
					<td>${summing.bonus}</td>
					<td>${summing.check}</td>
					<td>${summing.allowance}</td>
					<td>${summing.leave}</td>
					<td>${summing.injury}</td>
					<td>${summing.penalty}</td>
					<td>${summing.other}</td>
					<td>${summing.should}</td>
					<td>${summing.dues}</td>
					<td>${summing.old}</td>
					<td>${summing.treatments}</td>
					<td>${summing.ill}</td>
					<td>${summing.unemp}</td>
					<td>${summing.accFund}</td>
					<td>${summing.waterAndEle}</td>
					<td>${summing.withhold}</td>
					<td>${summing.lastMonthWithhold}</td>
					<td>${summing.incomeTax}</td>
					<td>${summing.withholdTotal}</td>
					<td>${summing.reality}</td>
					<td>${summing.mealAllowance}</td>
					<td><fmt:formatNumber type="number" value="${summing.reality+summing.mealAllowance}" pattern="0.00" maxFractionDigits="2"/></td>
				</tr>
			</tbody>
	</table>
	<br>
	<p align="center">
		<input type="button" id="print" value="打印">
		<button id="back">返回</button>
	</p>
	
<script type="text/javascript">
	$("#print").click(function(){
		window.print();
	});
	
	$('#back').click(function(){
		window.location = "/sm/print";
	});
</script>
</body>
</html>