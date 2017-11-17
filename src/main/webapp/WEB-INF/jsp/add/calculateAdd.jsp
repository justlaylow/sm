<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增工资信息</title>
<script type="text/javascript">
	//返回
	function back(){
		window.location.href="/sm/list/sal"; 
	}
</script>
</head>
<body>
	<div style="text-align: center;">
		<h3>新增工资信息</h3>
		<!-- 新增 -->
		<form action="/sm/insert/sal" method="post">
			<table align="center" style="border-collapse:separate; border-spacing:15px;">
				<tr>
					<td><label>姓名:</label></td><td> <input name="calName" required="true"></td>
					<td><label>工号:</label></td><td> <input name="calId" required="true"></td>
				</tr>
				<tr>
					<td><label>HR号:</label></td><td> <input name="calHr"></td>
					<td><label>基本工资:</label></td><td> <input type="text" name="calBasic"></td>
				</tr>
				<tr>
					<td><label>岗位工资:</label></td><td> <input name="calPost"></td>
					<td><label>浮动工资:</label></td><td> <input type="text" name="calFloat"></td>
				</tr>
				<tr>
					<td><label>系数:</label></td><td> <input name="calCoefficient"></td>
					<td><label>保密工资:</label></td><td> <input type="text" name="calSecrecy"></td>
				</tr>
				<tr>
					<td><label>技能等级工资:</label></td><td> <input name="calSkillLevel"></td>
					<td><label>司龄工资:</label></td><td> <input type="text" name="calComage"></td>
				</tr>
				<tr>
					<td><label>奖金:</label></td><td> <input name="calBonus"></td>
					<td><label>加班工资:</label></td><td> <input type="text" name="calOvertime"></td>
				</tr>
				<tr>
					<td><label>津贴:</label></td><td> <input name="calBenefit"></td>
					<td><label>考评工资:</label></td><td> <input type="text" name="calCheck"></td>
				</tr>
				<tr>
					<td><label>工伤工资:</label></td><td> <input name="calInjury"></td>
					<td><label>缺勤:</label></td><td> <input type="text" name="calLeave"></td>
				</tr>
				<tr>
					<td><label>其他:</label></td><td> <input name="calOther"></td>
					<td><label>罚款:</label></td><td> <input type="text" name="calPenalty"></td>
				</tr>
				<tr>
					<td><label>扣款:</label></td><td> <input name="calWithhold"></td>
					<td><label>水电:</label></td><td> <input type="text" name="calWaterandele"></td>
				</tr>
				<tr>
					<td><label>餐补:</label></td><td> <input name="calAllowance"></td>
					<td><label>工资时间:</label></td><td> <input type="text" name="calDate" required="true"></td>
				</tr>
				<tr>
					<td><label>会费:</label></td><td> <input name="calDues"></td>
					<td><label>工时:</label></td><td> <input type="text" name="calManhour"></td>
				</tr>
				<tr>
					<td><label>工价:</label></td><td> <input name="labourCost"></td>
					<td><label>效益工资:</label></td><td> <input type="text" name="calBenefitwage"></td>
				</tr>
				<tr>
					<td><label>工时奖:</label></td><td> <input name="calManhourBonus"></td>
					<td><label>工时工资:</label></td><td> <input type="text" name="calMnahourSalary"></td>
				</tr>
				<tr>
					<td><label>福利:</label></td><td> <input name="calWelfare"></td>
					<td><label>应发工资:</label></td><td> <input type="text" name="calShould"></td>
				</tr>
				<tr>
					<td><label>工废:</label></td><td> <input name="calWaste"></td>
					<td><label>上月扣款:</label></td><td> <input type="text" name="calLastWithhold"></td>
				</tr>
				<tr>
					<td><label>所得税:</label></td><td> <input name="calIncometax"></td>
					<td><label>实得工资:</label></td><td> <input type="text" name="calResult"></td>
				</tr>
			</table>
			<button data-dismiss="modal" class="btn btn-default"
				type="button" onclick="back()">返回</button>
			<input class="btn btn-primary" type="submit" value="添加">
		</form>
	</div>
</body>
</html>