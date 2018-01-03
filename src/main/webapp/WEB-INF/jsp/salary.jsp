<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/header.jsp"%>
<%@ include file="/WEB-INF/jsp/include/background.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>工资维护</title>
<style>
tbody {
overflow:scroll;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<h3 class="text-center text-info">工 资 维 护</h3>
				<br /> <br />
				<div class="input-group">
					工号：<input type="text" placeholder="Search for..." name="calId"
						id="calId" value="${param.calId}"> <span></span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
					姓名：<input type="text"
						placeholder="Search for..." name="calName" id="calName"
						value="${param.calName}"> <span></span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
					工资时间：<input type="text"
						placeholder="Search for..." name="calDate" id="calDate"> <span>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<button class="btn btn-sm btn-default" type="button"
							onclick="blurrySeach()">搜索</button>
					</span>
				</div>
				<br />

				<!-- 首页 -->
				<%@ include file="/WEB-INF/jsp/include/main.jsp"%>

				<!-- 刷新 -->
				<button type="button" class="btn btn-default" onclick="reload()">刷新</button>
				
				<!-- 新增工资信息 -->
				<button type="button" class="btn btn-success" onclick="calAdd()">新增工资信息</button>

				<!-- 部门列表 -->
				<form action="/sm/updateBatch/sal" method="post" id="fm">
				<table class="table table-hover" id="datagrid" style="white-space: nowrap;">
					<thead>
						<tr>
							<!-- <th>删除</th>
							<th>查看</th> -->
							<th>工号</th>
							<th>姓名</th>
							<th>部门</th>
							<th>基本工资</th>
							<th>岗位工资</th>
							<th>司龄工资</th>
							<th>保密工资</th>
							<th>技能工资</th>
							<th>浮动工资</th>
							<th>系数</th>
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
							<th>工时工资</th>
							<th>会费</th>
							<th>所得税</th>
							<th>应发工资</th>
							<th>实得工资</th>
							<th>工资时间</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="sal" items="${salList}" varStatus="i">
							<c:if test="${sal.id!=null }">
								<tr>
									<!-- 和po类里的属性名一样 -->
									<!-- 如果工资日期不为为最大 则无法修改 -->
									<c:if test="${maxMonth!=sal.calDate}">
									<td>${sal.calId}</td>
									<td>${sal.calName}</td>
									<c:forEach var="emp" items="${sal.calEmployee}">
										<c:if test="${emp==sal.calEmployee[0]}">
											<td>${emp.salDep}</td>
										</c:if>
										
									</c:forEach>
									<!-- 删除员工之后calEmployee为空，部门得不到需占一格 -->
									<c:if test="${sal.calEmployee[0]==null}">
											<td> </td>
									</c:if>
									<td>${sal.calBasic}</td>
									<td>${sal.calPost}</td>
									<td>${sal.calComage}</td>
									<td>${sal.calSecrecy}</td>
									<td>${sal.calSkillLevel}</td>
									<td>${sal.calFloat}</td>
									<td>${sal.calCoefficient}</td>
									<td>${sal.calBonus}</td>
									<td>${sal.calOvertime}</td>
									<td>${sal.calBenefit}</td>
									<td>${sal.calCheck}</td>
									<td>${sal.calInjury}</td>
									<td>${sal.calLeave}</td>
									<td>${sal.calOther}</td>
									<td>${sal.calPenalty}</td>
									<td>${sal.calWithhold}</td>
									<td>${sal.calWaterandele}</td>
									<td>${sal.calAllowance}</td>
									<td>${sal.calManhourSalary}</td>
									<td>${sal.calDues}</td>
									<td>${sal.calIncometax}</td>
									<td>${sal.calShould}</td>
									<td>${sal.calResult}</td>
									<td><fmt:formatDate value="${sal.calDate}" type="date" pattern="yyyy-MM-dd"/></td>
									</c:if>
									
									<!-- 如果工资日期为最大 则可以修改 -->
									<c:if test="${maxMonth==sal.calDate}">
									<td><input name="salary[${i.index}].id" value="${sal.id}" style="display: none;">
										<input name="salary[${i.index}].calId" value="${sal.calId}" style="width: 80px;"></td>
									<td><input name="salary[${i.index}].calName" value="${sal.calName}" style="width: 80px;"></td>
									<c:forEach var="emp" items="${sal.calEmployee}">
										<c:if test="${emp==sal.calEmployee[0]}">
											<td><input value="${emp.salDep}"></td>
										</c:if>
										
									</c:forEach>
									<!-- 删除员工之后calEmployee为空，部门得不到需占一格 -->
									<c:if test="${sal.calEmployee[0]==null}">
											<td> </td>
									</c:if>
									<td><input name="salary[${i.index}].calBasic" value="${sal.calBasic}" style="width: 80px;"></td>
									<td><input name="salary[${i.index}].calPost" value="${sal.calPost}" style="width: 80px;"></td>
									<td><input name="salary[${i.index}].calComage" value="${sal.calComage}" style="width: 80px;"></td>
									<td><input name="salary[${i.index}].calSecrecy" value="${sal.calSecrecy}" style="width: 80px;"></td>
									<td><input name="salary[${i.index}].calSkillLevel" value="${sal.calSkillLevel}" style="width: 80px;"></td>
									<td><input name="salary[${i.index}].calFloat" value="${sal.calFloat}" style="width: 80px;"></td>
									<td><input name="salary[${i.index}].calCoefficient" value="${sal.calCoefficient}" style="width: 80px;"></td>
									<td><input name="salary[${i.index}].calBonus" value="${sal.calBonus}" style="width: 80px;"></td>
									<td><input name="salary[${i.index}].calOvertime" value="${sal.calOvertime}" style="width: 80px;"></td>
									<td><input name="salary[${i.index}].calBenefit" value="${sal.calBenefit}" style="width: 80px;"></td>
									<td><input name="salary[${i.index}].calCheck" value="${sal.calCheck}" style="width: 80px;"></td>
									<td><input name="salary[${i.index}].calInjury" value="${sal.calInjury}" style="width: 80px;"></td>
									<td><input name="salary[${i.index}].calLeave" value="${sal.calLeave}" style="width: 80px;"></td>
									<td><input name="salary[${i.index}].calOther" value="${sal.calOther}" style="width: 80px;"></td>
									<td><input name="salary[${i.index}].calPenalty" value="${sal.calPenalty}" style="width: 80px;"></td>
									<td><input name="salary[${i.index}].calWithhold" value="${sal.calWithhold}" style="width: 80px;"></td>
									<td><input name="salary[${i.index}].calWaterandele" value="${sal.calWaterandele}" style="width: 80px;"></td>
									<td><input name="salary[${i.index}].calAllowance" value="${sal.calAllowance}" style="width: 80px;"></td>
									<td><input name="salary[${i.index}].calManhourSalary" value="${sal.calManhourSalary}" style="width: 80px;"></td>
									<td><input name="salary[${i.index}].calDues" value="${sal.calDues}" style="width: 80px;"></td>
									<td><input name="salary[${i.index}].calIncometax" value="${sal.calIncometax}" style="width: 80px;"></td>
									<td><input name="salary[${i.index}].calShould" value="${sal.calShould}" style="width: 80px;"></td>
									<td><input name="salary[${i.index}].calResult" value="${sal.calResult}" style="width: 80px;"></td>
									<td><input value="<fmt:formatDate value="${sal.calDate}" type="date" pattern="yyyy-MM-dd"/>" style="width: 120px;"></td>
									</c:if>
								</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
				<div style="position: fixed;bottom: 0;margin-left:550px;"><input type="submit" id="insId" class="btn btn-sm btn-success" value="修改"/></div>
				</form>
			</div>
		</div>
	</div>

<script type="text/javascript">
	//刷新
	function reload(){
		window.location.href="/sm/list/sal"; 
	}
	
	//新增工资信息
	function calAdd(){
		window.location.href="/sm/calculateAdd"; 
	}
	
	//删除信息
 	function del(calId){
 		if(confirm("您确认删除吗？")){   
            //如果确定删除就访问servlet，这里超链接传值传的是方法里的参数           
            window.location.href="/sm/delete/sal/?id="+calId;
        }
	}
	
	//模糊查询
	function blurrySeach(calId,calName,calDate){
		calId = document.getElementById("calId").value;
		calName = document.getElementById("calName").value;
		calDate = document.getElementById("calDate").value;
		
		window.location.href="/sm/blurry/sal/?calId="+calId+"&calName="+calName+"&calDate="+calDate+"&calId2="+calId+"&calName2="+calName+"&calDate2="+calDate;
		
	}
	
	$('#calDate').dcalendarpicker({
		format:'yyyy-mm-dd'
	});
	
</script>
</body>
</html>