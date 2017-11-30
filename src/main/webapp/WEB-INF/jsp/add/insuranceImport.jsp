<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/header.jsp"%>
<%@ include file="/WEB-INF/jsp/include/background.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>保险金维护</title>
<script type="text/javascript">
	function back(){
		window.location.href="/sm/select/ins"; 
	}
</script>

</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<h3 class="text-center text-info">保 险 金 更 新 预 览</h3>

				<!-- 返回 -->
				<button type="button" class="btn btn-default" onclick="back()">返回</button>

				<!-- 保险数据预览 -->
				<form action="/sm/insImport" method="post" id="fm">
				<table class="table table-bordered" id="datagrid">
					<thead>
						<tr>
							<th>工号</th>
							<th>姓名</th>
							<th>保险基数</th>
							<th>养老保险</th>
							<th>医保</th>
							<th>大病医疗</th>
							<th>失业保险</th>
							<th>公积金</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="ins" items="${insurance}" varStatus="i">
							<tr>
								<!-- 和po类里的属性名一样 -->
								<td> <input name="insurance[${i.index}].insId" required="true" value="${ins.insId}" style="width: 70px;"></td>
								<td> <input name="insurance[${i.index}].insName" required="true" value="${ins.insName}" style="width: 70px;"></td>
								<td> <input name="insurance[${i.index}].insCarNumber" value="${ins.insCarNumber}" style="width: 70px;"></td>
								<td> <input name="insurance[${i.index}].insOld" value="${ins.insOld}" style="width: 70px;"></td>
								<td> <input name="insurance[${i.index}].insTreatments" value="${ins.insTreatments}" style="width: 70px;"></td>
								<td> <input name="insurance[${i.index}].insIll" value="${ins.insIll}" style="width: 70px;"></td>
								<td> <input type="text" name="insurance[${i.index}].insUnemp" value="${ins.insUnemp}" style="width: 70px;"></td>
								<td> <input type="text" name="insurance[${i.index}].insAccFund" value="${ins.insAccFund}" style="width: 70px;"></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<p align="center"><input type="submit" id="insId" class="btn btn-sm btn-success" value="更新"/></p>
				</form>
			</div>
		</div>
	</div>

</body>
</html>