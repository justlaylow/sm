<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/header.jsp"%>
<%@ include file="/WEB-INF/jsp/include/background.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工导入预览</title>
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
				<h3 class="text-center text-info">员 工 表 数 据 导 入 预 览</h3>
				<br>
					<form action="/sm/importIEmployee" method="post" enctype="multipart/form-data" id="formSub">
						<table class="table table-bordered" style="white-space: nowrap;">
							<thead>
								<th>工号</th>
								<th>姓名</th>
								<th>部门</th>
								<th>岗位类别</th>
								<th>岗位</th>
								<th>SAP号</th>
								<th>统计类别</th>
								<th>备注</th>
								<th>技能等级</th>
								<th>技能等级工资</th>
								<th>银行账户</th>
							</thead>
							<c:forEach var="exc" items="${employeeList}" varStatus="i">
							<tbody>
								<td><input name="employeeList[${i.index}].salId" value="${exc.salId}"/></td>
								<td><input name="employeeList[${i.index}].salName" value="${exc.salName}"/></td>
								<td><input name="employeeList[${i.index}].salDep" value="${exc.salDep}"/></td>
								<td><input name="employeeList[${i.index}].postCategory" value="${exc.postCategory}"/></td>
								<td><input name="employeeList[${i.index}].salPost" value="${exc.salPost}"/></td>
								<td><input name="employeeList[${i.index}].salOa" value="${exc.salOa}"/></td>
								<td><input name="employeeList[${i.index}].staCategory" value="${exc.staCategory}"/></td>
								<td><input name="employeeList[${i.index}].salRemark" value="${exc.salRemark}"/></td>
								<td><input name="employeeList[${i.index}].salSkilllevel" value="${exc.salSkilllevel}"/></td>
								<td><input name="employeeList[${i.index}].salSkillSalary" value="${exc.salSkillSalary}"/></td>
								<td><input name="employeeList[${i.index}].bankAccount" value="${exc.bankAccount}" style="width: 180px;"/></td>
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