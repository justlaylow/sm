<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 员工列表 -->
				<table class="table table-hover" id="datagrid"
					style="white-space: nowrap;">
					<thead>
						<tr>
							<th>删除</th>
							<th>修改</th>
							<th>姓名</th>
							<th>工号</th>
							<th>银行账户</th>
							<th>岗位类别</th>
							<th>部门</th>
							<th>岗位</th>
							<th>入职日期</th>
							<th>SAP账号</th>
							<th>统计类别</th>
							<th>备注</th>
							<th>技能等级</th>
							<th>技能等级工资</th>
							<th>性别</th>
							<th>身份证号</th>
							<th>保险基数</th>
							<th>养老保险</th>
							<th>医疗保险</th>
							<th>大病医疗</th>
							<th>失业保险</th>
							<th>公积金</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="emp" items="${list}">
							<c:if test="${emp.salName!=null }">
								<tr>
									<!-- 删除员工 -->
									<td><button type="button" id="deleteDep" class="btn btn-warning" onclick="del('${emp.salId}')" style="height: 25px;margin-top: -5px;width: 48px;font-size: 11px">删除</button></td>
								
									<!-- 修改信息 -->
									<td><button type="button" id="updateDep" style="height: 25px;margin-top: -5px;width: 48px;font-size: 11px"
											class="btn btn-default" data-toggle="modal"
											data-target="#upd${emp.id}">修改</button>
										<div class="modal fade" id="upd${emp.id}"
											data-backdrop="static" tabindex="-1" role="dialog"
											aria-labelledby="myModalLabel">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
														<button id="modalclose1${emp.id}" class="close" type="button">
															<span aria-hidden="true">×</span><span class="sr-only">Close</span>
														</button>
														<h4 class="modal-title" align="center">修改</h4>
													</div>
													<div class="modal-body">
														<form action="/sm/update/emp" method="post" id="fm${emp.id}">
															<input name="id" style="display: none" value="${emp.id }">
															<table align="center" style="border-collapse:separate; border-spacing:15px;white-space: nowrap;">
																<tr>
																	<td><label>姓名:</label></td><td> <input name="salName" required="true" value="${emp.salName}"></td>
																	<td><label>工号:</label></td><td> <input name="salId" required="true" value="${emp.salId}"></td>
																</tr>
																<tr>
																	<td><label>银行账号:</label></td><td> <input name="bankAccount" value="${emp.bankAccount}"></td>
																	<td><label>岗位类别:</label></td><td> <input type="text" name="postCategory" value="${emp.postCategory}"></td>
																</tr>
																<tr>
																	<td><label>部门:</label></td><td> <input name="salDep" value="${emp.salDep}" id="updateDepInput${emp.id}" style="display:none;">
																	<select id="updateDepSelect${emp.id}" style="height: 24px;width: 160px;">
																		<option style="display: none;">${emp.salDep}</option>
																		<c:forEach var="dep" items="${listDep}">
																			<option>${dep.depName}</option>
																		</c:forEach>
																	</select></td>
																	<td><label>岗位:</label></td><td> <input type="text" name="salPost" value="${emp.salPost}"></td>
																</tr>
																<tr>
																	<td><label>入职日期:</label></td><td> <input name="salDate" id="salDate${emp.id}" value="<fmt:formatDate value="${emp.salDate}" type="date"/>"></td>
																	<td><label>SAP账号:</label></td><td> <input type="text" name="salOa" value="${emp.salOa}"></td>
																</tr>
																<tr>
																	<td><label>统计类别:</label></td><td> <input type="text" name="staCategory" id="UpdateStaCategoryInput${emp.id}" value="${emp.staCategory}" style="display: none;">
																	<select id="UpdateStaCategory${emp.id}" style="height: 24px;width: 160px;">
																		<option style="display: none;">${emp.staCategory}</option>
																		<option>管理-二级机构负责人</option>
																		<option>管理-三级机构负责人</option>
																		<option>管理-一般管理</option>
																		<option>技术-IT技术</option>
																		<option>技术-技术服务</option>
																		<option>技术-技术开发</option>
																		<option>技术-技术研究</option>
																		<option>生产人员-计件</option>
																		<option>生产人员-计时</option>
																		<option>事务人员</option>
																		<option>营销人员-售后</option>
																	</select></td>
																	<td><label>备注:</label></td><td> <input name="salRemark" value="${emp.salRemark}"></td>
																</tr>
																<tr>
																	<td><label>技能等级:</label></td><td> <input type="text" name="salSkilllevel" value="${emp.salSkilllevel}" id="salskill${emp.id}" style="display: none;">
																	<select id="skill${emp.id}" style="height: 24px;width: 160px;">
																		<option style="display: none"></option>
																		<option>3</option>
																		<option>4</option>
																		<option>5</option>
																		<option>6</option>
																		<option>7</option>
																		<option>8</option>
																	</select></td>
																	<td><label>技能工资:</label></td><td> <input type="text" name="salSkillSalary" value="${emp.salSkillSalary}" id="skillsalary${emp.id}"></td>
																</tr>
															</table>
															<div class="modal-footer">
																<button id="modalclose2${emp.id}" class="btn btn-default"
																	type="button">关闭</button>
																<input class="btn btn-primary" type="button" id="submitUpdate${emp.id}" value="修改">
															</div>
														</form>
														<script type="text/javascript">
														$('#submitUpdate'+${emp.id}).click(function(){
														var salDate = $('#salDate'+${emp.id}).val();
														var reg = /^[0-9]{4}-(0[1-9]|[1-9]|1[0-2])-(0[1-9]|[1-9]|[1-2][0-9]|3[0-1])$/;
														if(reg.test(salDate)!=true){
															confirm("入职日期格式或时间出错 xxxx-xx-xx");
															return false;
														}
														$('#fm'+${emp.id}).submit();
														});
														
														//数据修改,从数据库取得部门名到select中,从select中选择部门名
														$('#updateDepSelect'+${emp.id}).change(function (){
															var dep = $('#updateDepSelect'+${emp.id}+' option:selected').text();
															$('#updateDepInput'+${emp.id}).val(dep);
														});
														//从select中选择统计类别
														$('#UpdateStaCategory'+${emp.id}).change(function (){
															var dep = $('#UpdateStaCategory'+${emp.id}+' option:selected').text();
															$('#UpdateStaCategoryInput'+${emp.id}).val(dep);
														});
														
														//关闭模态窗
														$('#modalclose1'+${emp.id}).click(function(){
															$('#upd'+${emp.id}).modal('hide');
														}); 
														$('#modalclose2'+${emp.id}).click(function(){
															$('#upd'+${emp.id}).modal('hide');
														});
														
														//技能等级选择
														$('#skill'+${emp.id}).change(function (){
															var dep = $('#skill'+${emp.id}+' option:selected').text();
															$('#salskill'+${emp.id}).val(dep);
															switch(dep){
															case '3':$('#skillsalary'+${emp.id}).val('960');
															break;
															case '4':$('#skillsalary'+${emp.id}).val('780');
															break;
															case '5':$('#skillsalary'+${emp.id}).val('630');
															break;
															case '6':$('#skillsalary'+${emp.id}).val('510');
															break;
															case '7':$('#skillsalary'+${emp.id}).val('390');
															break;
															case '8':$('#skillsalary'+${emp.id}).val('300');
															break;
															default:$('#skillsalary'+${emp.id}).val('0');
															}
														});
														</script>
													</div>
												</div>
												<!-- /.modal-content -->
											</div>
											<!-- /.modal-dialog -->
										</div></td>
									
									<td>${emp.salName}</td>
									<td>${emp.salId}</td>
									<td>${emp.bankAccount}</td>
									<td>${emp.postCategory}</td>
									<td>${emp.salDep}</td>
									<td>${emp.salPost}</td>
									<td><fmt:formatDate value="${emp.salDate}" type="date"/></td>
									<td>${emp.salOa}</td>
									<td>${emp.staCategory}</td>
									<td>${emp.salRemark}</td>
									<td>${emp.salSkilllevel}</td>
									<td>${emp.salSkillSalary}</td>
									<c:forEach var="ins" items="${emp.salInsuranceList}">
										<td>${ins.insSex}</td>
										<td>${ins.insIden}</td>
										<td>${ins.insCarNumber}</td>
										<td>${ins.insOld}</td>
										<td>${ins.insTreatments}</td>
										<td>${ins.insIll}</td>
										<td>${ins.insUnemp}</td>
										<td>${ins.insAccFund}</td>
									</c:forEach>
								</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
	
共有${requestScope.pageBean.totalRecord }个员工,共${requestScope.pageBean.totalPage }页,当前为${requestScope.pageBean.pageNum}页
	<br/>
	<a href="/sm/xxx?pageNum=1">首页</a>
	<c:if test="${requestScope.pageBean.pageNum==1 }">
		<c:forEach begin="${requestScope.pageBean.start }" end="${requestScope.pageBean.end }" step="1" var="i">
			<c:if test="${ requestScope.pageBean.pageNum==i }">
				${i }
			</c:if>
			<c:if test="${requestScope.pageBean.pageNum!=i }">
				<a href="/sm/xxx?pageNum=${i }">${i }</a>
			</c:if>
		</c:forEach>
		<a href="/sm/xxx?pageNum=${requestScope.pageBean.pageNum+1 }">下一页</a>
	</c:if>
	
	<c:if test="${requestScope.pageBean.pageNum>1&&requestScope.pageBean.pageNum<requestScope.pageBean.totalPage}">
		<a href="/sm/xxx?pageNum=${requestScope.pageBean.pageNum-1 }">上一页</a>
		<c:forEach begin="${requestScope.pageBean.start }" end="${requestScope.pageBean.end }" step="1" var="i">
			<c:if test="${ requestScope.pageBean.pageNum==i }">
				${i }
			</c:if>
			<c:if test="${requestScope.pageBean.pageNum!=i }">
				<a href="/sm/xxx?pageNum=${i }">${i }</a>
			</c:if>
		</c:forEach>
		<a href="/sm/xxx?pageNum=${requestScope.pageBean.pageNum+1 }">下一页</a>
	</c:if>
	
	<c:if test="${requestScope.pageBean.pageNum==requestScope.pageBean.totalPage }">
		<a href="/sm/xxx?pageNum=${requestScope.pageBean.pageNum-1 }">上一页</a>
		<c:forEach begin="${requestScope.pageBean.start }" end="${requestScope.pageBean.end }" step="1" var="i">
			<c:if test="${ requestScope.pageBean.pageNum==i }">
				${i }
			</c:if>
			<c:if test="${requestScope.pageBean.pageNum!=i }">
				<a href="/sm/xxx?pageNum=${i }">${i }</a>
			</c:if>
		</c:forEach>
	</c:if>
	
	<a href="/sm/xxx?pageNum=${requestScope.pageBean.totalPage }">尾页</a>
</body>
</html>