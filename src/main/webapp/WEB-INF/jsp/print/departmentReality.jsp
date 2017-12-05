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
	width: 80px;
	text-align: center;
}
	th {
	text-align: center;
}
</style>
</head>
<body>
<div align="center">
	<h3 align="center">特力公司${maxMonth}月工资汇总表(实得)</h3>
	<table border="1" style="white-space: nowrap;">
		<thead>
			<tr>
				<th>部门名称</th>
				<th>会费</th>
				<th>养老保险</th>
				<th>医保</th>
				<th>大病</th>
				<th>失业</th>
				<th>扣款</th>
				<th>水电费</th>
				<th>公积金</th>
				<th>上月扣款</th>
				<th>所得税</th>
				<th>扣款合计</th>
				<th>实得工资</th>
				<th>下月扣款</th>
				<th>餐补</th>
				<th>合计</th>
			</tr>
		</thead>
		<c:forEach var="should" items="${departmentReality }">
			<tbody>
				<tr>
					<td>${should.department}</td>
					<td>${should.dues}</td>
					<td>${should.old}</td>
					<td>${should.treatments}</td>
					<td>${should.ill}</td>
					<td>${should.unemp}</td>
					<td>${should.withhold}</td>
					<td>${should.waterAndEle}</td>
					<td>${should.accFund}</td>
					<td>${should.lastMonthWithhold}</td>
					<td>${should.incomeTax}</td>
					<td>${should.withholdTotal}</td>
					<td>${should.reality}</td>
					<td></td>
					<td>${should.mealAllowance}</td>
					<td>${should.reality}</td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
	<p align="center"><input type="button" id="print" value="工资条"></p>
</div>
	
<script type="text/javascript">
	$("#print").click(function(){
		window.print();
	});
</script>
</body>
</html>