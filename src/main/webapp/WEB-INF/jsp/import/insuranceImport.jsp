<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/header.jsp"%>
<%@ include file="/WEB-INF/jsp/include/background.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>保险导入预览</title>
<style type="text/css">
	.table td input{
		width: 70px
	}
</style>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column" style="text-align: center">
				<h3 class="text-center text-info">保 险 表 数 据 导 入 预 览</h3>
				<br>
					<form action="/sm/importInsurance" method="post" enctype="multipart/form-data" id="formSub">
						<table class="table table-bordered" style="white-space: nowrap;">
							<thead>
								<th>工号</th>
								<th>姓名</th>
								<th>性别</th>
								<th>保险基数</th>
								<th>养老保险</th>
								<th>医疗保险</th>
								<th>大病医疗</th>
								<th>失业保险</th>
								<th>公积金</th>
								<th>养老投保地</th>
								<th>医保投保地</th>
								<th>失业投保地</th>
								<th>公积金投保地</th>
								<th>工伤投保地</th>
							</thead>
							<c:forEach var="exc" items="${insuranceList}" varStatus="i">
							<tbody>
								<td><input name="insuranceList[${i.index}].insId" value="${exc.insId}"/></td>
								<td><input name="insuranceList[${i.index}].insName" value="${exc.insName}"/></td>
								<td><input name="insuranceList[${i.index}].insSex" value="${exc.insSex}"/></td>
								<td><input name="insuranceList[${i.index}].insCarNumber" value="${exc.insCarNumber}"/></td>
								<td><input name="insuranceList[${i.index}].insOld" value="${exc.insOld}"/></td>
								<td><input name="insuranceList[${i.index}].insTreatments" value="${exc.insTreatments}"/></td>
								<td><input name="insuranceList[${i.index}].insIll" value="${exc.insIll}"/></td>
								<td><input name="insuranceList[${i.index}].insUnemp" value="${exc.insUnemp}"/></td>
								<td><input name="insuranceList[${i.index}].insAccFund" value="${exc.insAccFund}"/></td>
								<td><input name="insuranceList[${i.index}].insurance" value="${exc.insurance}"/></td>
								<td><input name="insuranceList[${i.index}].insSign" value="${exc.insSign}"/></td>
								<td><input name="insuranceList[${i.index}].insUnempAddress" value="${exc.insUnempAddress}"/></td>
								<td><input name="insuranceList[${i.index}].insAccAddress" value="${exc.insAccAddress}"/></td>
								<td><input name="insuranceList[${i.index}].insTreatmentId" value="${exc.insTreatmentId}"/></td>
							</tbody>
							</c:forEach>
						</table>
						<input type="submit" class="btn btn-sm btn-success" value="导入"/>
					</form>
					<h3>${importMsg}</h3>
					<button onclick="back()">返回</button>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		//返回
		function back() {
			window.location.href = "/sm/main";
		}

	</script>	
</body>
</html>