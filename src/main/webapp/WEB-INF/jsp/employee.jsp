<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/header.jsp"%>
<html>
<head>
<title>员工管理</title>
<script type="text/javascript">
	//刷新
	function reload(){
		window.location.href="/sm/list/emp?pageNum=1"; 
	}
	
	//批量导入，选择文件
	function employeeImport(){
		window.location.href="/sm/empImportFile"; 
	}
	
	//删除信息
 	function del(userid){
 		if(confirm("您确认删除吗？")){   
            //如果确定删除就访问servlet，这里超链接传值传的是方法里的参数           
            window.location.href="/sm/delete/emp/?salId="+userid;
        }
	}
	
	//模糊查询
	function blurrySeach(salId,salName,salOa){
		salId = document.getElementById("salId").value;
		salName = document.getElementById("salName").value;
		salOa = document.getElementById("salOa").value;
		
		window.location.href="/sm/blurry/emp/?salId="+salId+"&salName="+salName+"&salOa="+salOa;
	}
	
	
</script>

</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<h3 class="text-center text-info">员 工 管 理</h3>
				<br /> <br />
				<div class="input-group">
					工号：<input type="text" name="salId" id="salId" value="${param.salId}">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
					姓名：<input type="text" name="salName" id="salName" value="${param.salName}">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
					SAP账号：<input type="text" name="salOa" id="salOa" value="${param.salOa}"> 
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<span>
						<button class="btn btn-sm btn-default" type="button" style="height: 25px;margin-top: -5px;width: 48px;font-size: 12px"
							onclick="blurrySeach()">查询</button>
					</span>
				</div>
				<br />

				<!-- 首页 -->
				<%@ include file="/WEB-INF/jsp/include/main.jsp"%>
				
				<!-- 刷新 -->
				<button type="button" class="btn btn-default" onclick="reload()">刷新</button>

				<!-- 添加员工 -->
				<button type="button" class="btn btn-success" data-toggle="modal"
					data-target="#myModal">添加员工</button>
				<div class="modal fade" id="myModal" data-backdrop="static"
					tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
					<div class="modal-dialog" aria-hidden="true">
						<div class="modal-content">
							<div class="modal-header">
								<button id="modalclose1" class="close" type="button">
									<span aria-hidden="true">×</span><span class="sr-only">Close</span>
								</button>
								<h4 class="modal-title">添加</h4>
							</div>
							<div class="modal-body">
								<form action="/sm/insert/emp" method="post" id="fm" onsubmit="return checkAdd()">
									<input name="id" style="display: none"> 
									<label>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</label>
									<input name="salName" required="true" id="checkName">&emsp;&emsp;&emsp;
									<label>部门名称:</label> 
									<input type="text" name="salDep" style="width: 170px;display:none;" id="selectInput">
									<select id="selectDep" style="height: 24px;width: 160px;">
										<option style="display: none;"></option>
										<c:forEach var="dep" items="${listDep}">
											<%-- <option value="${dep.depName}"/> --%>
											<option>${dep.depName}</option>
										</c:forEach>
									</select><br><br>
									<label>岗&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;位:</label>
									<input name="salPost" list="post">&emsp;&emsp;&emsp;
									<!-- <datalist id="post">
									<option>网络工程师</option>
									</datalist> -->
									<label>工&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:</label> 
									<input name="salId" required="true" id="checkId"><br><br>
									<label>岗位类别:</label> 
									<input name="postCategory" list="postCategory">&emsp;&emsp;&emsp;
									<!-- <datalist id="postCategory">
									<option>技术人员</option>
									</datalist> -->
									<label>银行账户:</label>
									<input name="bankAccount" required="true" id="checkBank" style="width: 170px"><br><br> 
									<label>入职日期:</label>
									<input name="salDate" id="mydate">&emsp;&emsp;&emsp; <label>&nbsp;SAP账号:</label>
									<input name="salOa"> <br><br> 
									<label>统计类别:</label> 
									<input name="staCategory" id="staCategoryInput" style="width: 170px;display:none;">
									<select id="staCategory" style="height: 24px;width: 160px;">
										<option style="display: none"></option>
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
									</select>&emsp;&emsp;&nbsp;&nbsp;
									<label>备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:</label> <input name="salRemark"> <br><br>
									<label>技能等级:</label> <input name="salSkilllevel" id="salskill" style="display: none;"> 
									<select id="skill" style="height: 24px;width: 160px;">
										<option style="display: none"></option>
										<option>3</option>
										<option>4</option>
										<option>5</option>
										<option>6</option>
										<option>7</option>
										<option>8</option>
									</select>
									<label>&emsp;技能等级工资:</label> <input name="salSkillSalary" id="skillsalary"> <br><br>
									<label>账号所属省份:</label> <input name="bankAddress">


									<div class="modal-footer">
										<button class="btn btn-default"
											type="button" id="modalclose2">关闭</button>
										<input class="btn btn-primary" type="submit" value="添加">
									</div>
								</form>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
				
				<!-- 批量导入 -->
				<button type="button" class="btn btn-default" onclick="employeeImport()">批量导入</button>

				<!-- 员工列表 -->
				<table class="table table-hover" id="datagrid"
					style="white-space: nowrap;">
					<thead>
						<tr>
							<th>删除</th>
							<th>修改</th>
							<th>姓名</th>
							<th>SAP账号</th>
							<th>工号</th>
							<th>统计类别</th>
							<th>岗位类别</th>
							<th>部门</th>
							<th>岗位</th>
							<th>银行账户</th>
							<th>账户所属省份</th>
							<th>入职日期</th>
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
						<c:forEach var="emp" items="${empList}">
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
																<tr>
																	<td><label>账号所属省份:</label></td><td> <input type="text" name="bankAddress" value="${emp.bankAddress}"></td>
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
									<td>${emp.salOa}</td>
									<td>${emp.salId}</td>
									<td>${emp.staCategory}</td>
									<td>${emp.postCategory}</td>
									<td>${emp.salDep}</td>
									<td>${emp.salPost}</td>
									<td>${emp.bankAccount}</td>
									<td>${emp.bankAddress}</td>
									<td><fmt:formatDate value="${emp.salDate}" type="date"/></td>
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
				<div align="center" id="page">
				共有${requestScope.pageBean.totalRecord }个员工,共${requestScope.pageBean.totalPage }页,当前为${requestScope.pageBean.pageNum}页
				<br/>
				<a href="/sm/list/emp?pageNum=1">首页</a>
				<c:if test="${requestScope.pageBean.pageNum==1 }">
					<c:forEach begin="${requestScope.pageBean.start }" end="${requestScope.pageBean.end }" step="1" var="i">
						<c:if test="${ requestScope.pageBean.pageNum==i }">
							${i }
						</c:if>
						<c:if test="${requestScope.pageBean.pageNum!=i }">
							<a href="/sm/list/emp?pageNum=${i }">${i }</a>
						</c:if>
					</c:forEach>
					<a href="/sm/list/emp?pageNum=${requestScope.pageBean.pageNum+1 }">下一页</a>
				</c:if>
				
				<c:if test="${requestScope.pageBean.pageNum>1&&requestScope.pageBean.pageNum<requestScope.pageBean.totalPage}">
					<a href="/sm/list/emp?pageNum=${requestScope.pageBean.pageNum-1 }">上一页</a>
					<c:forEach begin="${requestScope.pageBean.start }" end="${requestScope.pageBean.end }" step="1" var="i">
						<c:if test="${ requestScope.pageBean.pageNum==i }">
							${i }
						</c:if>
						<c:if test="${requestScope.pageBean.pageNum!=i }">
							<a href="/sm/list/emp?pageNum=${i }">${i }</a>
						</c:if>
					</c:forEach>
					<a href="/sm/list/emp?pageNum=${requestScope.pageBean.pageNum+1 }">下一页</a>
				</c:if>
				
				<c:if test="${requestScope.pageBean.pageNum==requestScope.pageBean.totalPage }">
					<a href="/sm/list/emp?pageNum=${requestScope.pageBean.pageNum-1 }">上一页</a>
					<c:forEach begin="${requestScope.pageBean.start }" end="${requestScope.pageBean.end }" step="1" var="i">
						<c:if test="${ requestScope.pageBean.pageNum==i }">
							${i }
						</c:if>
						<c:if test="${requestScope.pageBean.pageNum!=i }">
							<a href="/sm/list/emp?pageNum=${i }">${i }</a>
						</c:if>
					</c:forEach>
				</c:if>
				<a href="/sm/list/emp?pageNum=${requestScope.pageBean.totalPage }">尾页</a>
				</div>
				
			</div>
		</div>
	</div>
<script type="text/javascript">
	//日期插件
	$('#mydate').dcalendarpicker({
	format : 'yyyy-mm-dd'
	});
	
	//下拉框的值赋给部门名称输入框
	$('#selectDep').change(function (){
		var dep = $('#selectDep option:selected').text();
		$('#selectInput').val(dep);
	}) ;
	
	//下拉框的值赋给统计类别输入框,
	$('#staCategory').change(function (){
		var dep = $('#staCategory option:selected').text();
		$('#staCategoryInput').val(dep);
	});
	
	//模态框关闭，ie中data-dismiss不起作用
	$('#modalclose1').click(function(){
		$('#myModal').modal('hide');
	}); 
	$('#modalclose2').click(function(){
		$('#myModal').modal('hide');
	});
	
	//添加员工必填项
	function checkAdd(){
		var name = $('#checkName').val();
		var account = $('#checkBank').val();
		var id = $('#checkId').val();
		var stacotegory = $('#staCategoryInput').val();
		
		if(name==""){
			alert('姓名不能为空');
			return false;
		}
		if(account==""){
			alert('银行账户不能为空');
			return false;
		}
		if(id==""){
			alert('工号不能为空');
			return false;
		}
		if(stacotegory==""){
			alert('统计类别不能为空');
			return false;
		}
	};
	
	//技能等级选择
	$('#skill').change(function (){
		var dep = $('#skill option:selected').text();
		$('#salskill').val(dep);
		switch(dep){
		case '3':$('#skillsalary').val('960');
		break;
		case '4':$('#skillsalary').val('780');
		break;
		case '5':$('#skillsalary').val('630');
		break;
		case '6':$('#skillsalary').val('510');
		break;
		case '7':$('#skillsalary').val('390');
		break;
		case '8':$('#skillsalary').val('300');
		break;
		default:$('#skillsalary').val('0');
		}
	});
	
	//分页显示
	$(function(){
		if(${blurry==1}){
			$("#page").hide();
		}
	});
	
</script>
</body>
</html>