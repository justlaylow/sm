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
	<h3 align="center">特力公司${maxMonth}月工资统计表(应发)</h3>
	<table border="1" style="white-space: nowrap;">
		<thead>
			<tr>
				<th>统计类别</th>
				<th>人数</th>
				<th>基本工资</th>
				<th>岗位工资</th>
				<th>司龄工资</th>
				<th>保密工资</th>
				<th>技能工资</th>
				<th>效益工资</th>
				<th>工时工资</th>
				<th>加班</th>
				<th>奖金</th>
				<th>考评工资</th>
				<th>工时</th>
				<th>津贴</th>
				<th>考勤扣款</th>
				<th>工伤产假</th>
				<th>罚款</th>
				<th>其它</th>
				<th>应发工资</th>
			</tr>
		</thead>
		<c:forEach var="should" items="${categoryShould }">
			<tbody>
				<tr>
					<td>${should.category}</td>
					<td>${should.count}</td>
					<td>${should.basic}</td>
					<td>${should.post}</td>
					<td>${should.comage}</td>
					<td>${should.secrecy}</td>
					<td>${should.skillSalary}</td>
					<td>${should.benefit}</td>
					<td>${should.manhourSalary}</td>
					<td>${should.overtime}</td>
					<td>${should.bonus}</td>
					<td>${should.check}</td>
					<td>${should.manhour}</td>
					<td>${should.allowance}</td>
					<td>${should.leave}</td>
					<td>${should.injury}</td>
					<td>${should.penalty}</td>
					<td>${should.other}</td>
					<td>${should.should}</td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
	<br>
	<p align="center">
		<input type="button" id="print" value="打印">
		<button id="categoryShould">导出</button>
		<button id="back">返回</button>
	</p>
</div>
	
<script type="text/javascript">
	$("#print").click(function(){
		window.print();
	});
	
	$('#back').click(function(){
		window.location = "/sm/print";
	});

	$('#categoryShould').click(function(){
		window.location = "/sm/exportCategoryShould"
	});
</script>
</body>
</html>