<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>保险金维护</title>
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
		
		window.location.href="/sm/blurry/sal/?calId="+calId+"&calName="+calName+"&calDate="+calDate;
		
	}
	
</script>

</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<h3 class="text-center text-info">工资维护</h3>
				<br /> <br />
				<div class="input-group">
					工号：<input type="text" placeholder="Search for..." name="calId"
						id="calId" value="${param.calId}"> <span>
						<button class="btn btn-default" type="button"
							onclick="blurrySeach()">搜索</button>
					</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 姓名：<input type="text"
						placeholder="Search for..." name="calName" id="calName"
						value="${param.calName}"> <span>
						<button class="btn btn-default" type="button"
							onclick="blurrySeach()">搜索</button>
					</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 工资时间：<input type="text"
						placeholder="Search for..." name="calDate" id="calDate"
						value="${param.calDate}"> <span>
						<button class="btn btn-default" type="button"
							onclick="blurrySeach()">搜索</button>
					</span>
				</div>
				<br />

				<!-- 首页 -->
				<%@ include file="/WEB-INF/jsp/include/main.jsp"%>

				<!-- 刷新 -->
				<button type="button" class="btn btn-primary" onclick="reload()">刷新</button>
				
				<!-- 新增工资信息 -->
				<button type="button" class="btn btn-primary" onclick="calAdd()">新增工资信息</button>

				<!-- 部门列表 -->
				<table class="table table-hover" id="datagrid">
					<thead>
						<tr>
							<th>删除</th>
							<th>查看</th>
							<th>工号</th>
							<th>姓名</th>
							<th>部门代码</th>
							<th>基本工资</th>
							<th>岗位工资</th>
							<th>司龄工资</th>
							<th>保密工资</th>
							<th>技能工资</th>
							<th>工资时间</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="sal" items="${salList}">
							<c:if test="${sal.id!=null }">
								<tr>
									<!-- 删除 -->
									<td><button type="button" id="calId"
											class="btn btn-primary" onclick="del(${sal.id })">删除</button></td>
	
									<!-- 修改信息 -->
									<td><button type="button" id="updateDep"
											class="btn btn-primary" data-toggle="modal"
											data-target="#upd${sal.id }">查看</button>
										<div class="modal fade" id="upd${sal.id }"
											data-backdrop="static" tabindex="-1" role="dialog"
											aria-labelledby="myModalLabel">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
														<button data-dismiss="modal" class="close" type="button">
															<span aria-hidden="true">×</span><span class="sr-only">Close</span>
														</button>
														<h4 class="modal-title" align="center">修改</h4>
													</div>
													<div class="modal-body">
														<form action="/sm/update/sal" method="post" id="fm">
															<input style="display: none" name="id" id="Id" value="${sal.id}">
															<table align="center">
																<tr>
																	<td><label>姓名:</label></td><td> <input name="calName" required="true" value="${sal.calName}"></td>
																	<td><label>工号:</label></td><td> <input name="calId" required="true" value="${sal.calId}"></td>
																</tr>
																<tr>
																	<td><label>HR号:</label></td><td> <input name="calHr" value="${sal.calHr}"></td>
																	<td><label>基本工资:</label></td><td> <input type="text" name="calBasic" value="${sal.calBasic}"></td>
																</tr>
																<tr>
																	<td><label>岗位工资:</label></td><td> <input name="calPost" value="${sal.calPost}"></td>
																	<td><label>浮动工资:</label></td><td> <input type="text" name="calFloat" value="${sal.calFloat}"></td>
																</tr>
																<tr>
																	<td><label>系数:</label></td><td> <input name="calCoefficient" value="${sal.calCoefficient}"></td>
																	<td><label>保密工资:</label></td><td> <input type="text" name="calSecrecy" value="${sal.calSecrecy}"></td>
																</tr>
																<tr>
																	<td><label>技能等级工资:</label></td><td> <input name="calSkillLevel" value="${sal.calSkillLevel}"></td>
																	<td><label>司龄工资:</label></td><td> <input type="text" name="calComage" value="${sal.calComage}"></td>
																</tr>
																<tr>
																	<td><label>奖金:</label></td><td> <input name="calBonus" value="${sal.calBonus}"></td>
																	<td><label>加班工资:</label></td><td> <input type="text" name="calOvertime" value="${sal.calOvertime}"></td>
																</tr>
																<tr>
																	<td><label>津贴:</label></td><td> <input name="calBenefit" value="${sal.calBenefit}"></td>
																	<td><label>考评工资:</label></td><td> <input type="text" name="calCheck" value="${sal.calCheck}"></td>
																</tr>
																<tr>
																	<td><label>工伤工资:</label></td><td> <input name="calInjury" value="${sal.calInjury}"></td>
																	<td><label>缺勤:</label></td><td> <input type="text" name="calLeave" value="${sal.calLeave}"></td>
																</tr>
																<tr>
																	<td><label>其他:</label></td><td> <input name="calOther" value="${sal.calOther}"></td>
																	<td><label>罚款:</label></td><td> <input type="text" name="calPenalty" value="${sal.calPenalty}"></td>
																</tr>
																<tr>
																	<td><label>扣款:</label></td><td> <input name="calWithhold" value="${sal.calWithhold}"></td>
																	<td><label>水电:</label></td><td> <input type="text" name="calWaterandele" value="${sal.calWaterandele}"></td>
																</tr>
																<tr>
																	<td><label>餐补:</label></td><td> <input name="calAllowance" value="${sal.calAllowance}"></td>
																	<td><label>工资时间:</label></td><td> <input type="text" name="calDate" value="<fmt:formatDate value="${sal.calDate}" type="date"/>" required="true"></td>
																</tr>
																<tr>
																	<td><label>会费:</label></td><td> <input name="calDues" value="${sal.calDues}"></td>
																	<td><label>工时:</label></td><td> <input type="text" name="calManhour" value="${sal.calManhour}"></td>
																</tr>
																<tr>
																	<td><label>工价:</label></td><td> <input name="labourCost" value="${sal.labourCost}"></td>
																	<td><label>效益工资:</label></td><td> <input type="text" name="calBenefitwage" value="${sal.calBenefitwage}"></td>
																</tr>
																<tr>
																	<td><label>工时奖:</label></td><td> <input name="calManhourBonus" value="${sal.calManhourBonus}"></td>
																	<td><label>工时工资:</label></td><td> <input type="text" name="calManhourSalary" value="${sal.calManhourSalary}"></td>
																</tr>
																<tr>
																	<td><label>福利:</label></td><td> <input name="calWelfare" value="${sal.calWelfare}"></td>
																	<td><label>应发工资:</label></td><td> <input type="text" name="calShould" value="${sal.calShould}"></td>
																</tr>
																<tr>
																	<td><label>工废:</label></td><td> <input name="calWaste" value="${sal.calWaste}"></td>
																	<td><label>上月扣款:</label></td><td> <input type="text" name="calLastWithhold" value="${sal.calLastWithhold}"></td>
																</tr>
																<tr>
																	<td><label>所得税:</label></td><td> <input name="calIncometax" value="${sal.calIncometax}"></td>
																	<td><label>实得工资:</label></td><td> <input type="text" name="calResult" value="${sal.calResult}"></td>
																</tr>
															</table>
															<div class="modal-footer">
																<button data-dismiss="modal" class="btn btn-default"
																	type="button">关闭</button>
																<input class="btn btn-primary" type="submit" value="修改">
															</div>
														</form>
													</div>
												</div>
												<!-- /.modal-content -->
											</div>
											<!-- /.modal-dialog -->
										</div>
									</td>
									
									<!-- 和po类里的属性名一样 -->
									<td>${sal.calId}</td>
									<td>${sal.calName}</td>
									<c:forEach var="emp" items="${sal.calEmployee}">
										<c:if test="${emp==sal.calEmployee[0]}">
											<td>${emp.salDep}</td>
										</c:if>
									</c:forEach>
									<td>${sal.calBasic}</td>
									<td>${sal.calPost}</td>
									<td>${sal.calComage}</td>
									<td>${sal.calSecrecy}</td>
									<td>${sal.calSkillLevel}</td>
									<td><fmt:formatDate value="${sal.calDate}" type="date"/></td>
									<td></td>
								</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>