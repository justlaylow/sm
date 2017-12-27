<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/header.jsp"%>
<%@ include file="/WEB-INF/jsp/include/background.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>工资导入预览</title>
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
				<h3 class="text-center text-info">工 资 表 数 据 导 入 预 览</h3>
				<br>
					<form action="/sm/import" method="post" enctype="multipart/form-data" id="formSub">
						<table class="table table-bordered">
							<thead>
								<th>SAP账号</th>
								<th>工号</th>
								<th>姓名</th>
								<th>基本工资</th>
								<th>岗位工资</th>
								<th>浮动工资</th>
								<th>系数</th>
								<th>效益工资</th>
								<th>保密工资</th>
								<th>技能等级工资</th>
								<th>司龄工资</th>
								<th>奖金</th>
								<th>加班工资</th>
								<th>津贴</th>
								<th>考评工资</th>
								<th>工伤工资</th>
								<th>缺勤</th>
								<th>其他</th>
								<th>罚款</th>
								<th>扣款</th>
								<th>水电</th>
								<th>餐补</th>
								<!-- <th>会费</th> -->
								<th>工时工资</th>
								<!-- <th>扣款合计</th>
								<th>所得税</th>
								<th>应发工资</th>
								<th>实得工资</th>-->
								<th>工资时间</th>
							</thead>
							<c:forEach var="exc" items="${salaryList}" varStatus="i">
							<tbody>
								<td><input name="salaryList[${i.index}].calHr" value="${exc.calHr}"/></td>
								<td><input name="salaryList[${i.index}].calId" value="${exc.calId}"/></td>
								<td><input name="salaryList[${i.index}].calName" value="${exc.calName}"/></td>
								<td><input name="salaryList[${i.index}].calBasic" value="${exc.calBasic}"/></td>
								<td><input name="salaryList[${i.index}].calPost" value="${exc.calPost}"/></td>
								<td><input name="salaryList[${i.index}].calFloat" value="${exc.calFloat}"/></td>
								<td><input name="salaryList[${i.index}].calCoefficient" value="${exc.calCoefficient}"/></td>
								<td><input name="salaryList[${i.index}].calBenefitwage" value="${exc.calBenefitwage}"/></td>
								<td><input name="salaryList[${i.index}].calSecrecy" value="${exc.calSecrecy}"/></td>
								<td><input name="salaryList[${i.index}].calSkillLevel" value="${exc.calSkillLevel}" style="width: 100px;"/></td>
								<td><input name="salaryList[${i.index}].calComage" value="${exc.calComage}"/></td>
								<td><input name="salaryList[${i.index}].calBonus" value="${exc.calBonus}"/></td>
								<td><input name="salaryList[${i.index}].calOvertime" value="${exc.calOvertime}"/></td>
								<td><input name="salaryList[${i.index}].calBenefit" value="${exc.calBenefit}"/></td>
								<td><input name="salaryList[${i.index}].calCheck" value="${exc.calCheck}"/></td>
								<td><input name="salaryList[${i.index}].calInjury" value="${exc.calInjury}"/></td>
								<td><input name="salaryList[${i.index}].calLeave" value="${exc.calLeave}"/></td>
								<td><input name="salaryList[${i.index}].calOther" value="${exc.calOther}"/></td>
								<td><input name="salaryList[${i.index}].calPenalty" value="${exc.calPenalty}"/></td>
								<td><input name="salaryList[${i.index}].calWithhold" value="${exc.calWithhold}"/></td>
								<td><input name="salaryList[${i.index}].calWaterandele" value="${exc.calWaterandele}"/></td>
								<td><input name="salaryList[${i.index}].calAllowance" value="${exc.calAllowance}"/>
								<input name="salaryList[${i.index}].calDues" value="${exc.calDues}" style="display: none;"/></td>
								<td><input name="salaryList[${i.index}].calManhourSalary" value="${exc.calManhourSalary}"/>
								<input name="salaryList[${i.index}].calTotal" value="${exc.calTotal}" style="display: none;"/>
								<input name="salaryList[${i.index}].calIncometax" value="${exc.calIncometax}" style="display: none;"/>
								<input name="salaryList[${i.index}].calShould" value="${exc.calShould}" style="display: none;"/>
								<input name="salaryList[${i.index}].calResult" value="${exc.calResult}" style="display: none;"/></td>
								<td><input name="salaryList[${i.index}].calDate" value="<fmt:formatDate value="${exc.calDate}" type="date"/>" style="width: 100px;"/></td>
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