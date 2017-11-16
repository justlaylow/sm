<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工管理</title>

<script type="text/javascript">
	//刷新
	function reload(){
		window.location.href="/sm/list/emp"; 
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
				<h3 class="text-center text-info">员工管理</h3>
				<br /> <br />
				<div class="input-group">
					工号：<input type="text" placeholder="Search for..." name="salId"
						id="salId" value="${param.salId}"> <span>
						<button class="btn btn-default" type="button"
							onclick="blurrySeach()">搜索</button>
					</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 姓名：<input type="text"
						placeholder="Search for..." name="salName" id="salName"
						value="${param.salName}"> <span>
						<button class="btn btn-default" type="button"
							onclick="blurrySeach()">搜索</button>
					</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; OA账号：<input type="text"
						placeholder="Search for..." name="salOa" id="salOa"
						value="${param.salOa}"> <span>
						<button class="btn btn-default" type="button"
							onclick="blurrySeach()">搜索</button>
					</span>
				</div>
				<br />

				<!-- 首页 -->
				<%@ include file="/WEB-INF/jsp/include/main.jsp"%>
				
				<!-- 刷新 -->
				<button type="button" class="btn btn-primary" onclick="reload()">刷新</button>

				<!-- 添加员工 -->
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#myModal">添加员工</button>
				<div class="modal fade" id="myModal" data-backdrop="static"
					tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button data-dismiss="modal" class="close" type="button">
									<span aria-hidden="true">×</span><span class="sr-only">Close</span>
								</button>
								<h4 class="modal-title">添加</h4>
							</div>
							<div class="modal-body">
								<form action="/sm/insert/emp" method="post" id="fm">
									<input name="id" style="display: none"> <label>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</label>
									<input name="salName" required="true">&emsp;&emsp;&emsp;
									<label>工&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:</label> <input
										name="salId" required="true"> <br><br> <label>岗&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;位:</label>
									<input name="salPost" list="post">&emsp;&emsp;&emsp;
									<datalist id="post">
									<option>网络工程师</option>
									</datalist>
									<label>银行账户:</label> <input name="bankAccount" required="true"
										style="width: 170px"> <br><br> <label>岗位类别:</label> <input
										name="postCategory" list="postCategory">&emsp;&emsp;&emsp;
									<datalist id="postCategory">
									<option>技术人员</option>
									</datalist>
									<label>部门名称:</label> <input type="text" name="salDep"
										list="selectDep" style="width: 170px">
									<datalist id="selectDep">
										<option>技术部-信息化组</option>
										<option>质量部</option>
									</datalist>
									<br><br> <label>入职日期:</label>
									<input name="salDate">&emsp;&emsp;&emsp; <label>&nbsp;&nbsp;&nbsp;OA账号:</label>
									<input name="salOa"> <br><br> <label>统计类别:</label> <input
										name="staCategory" list="staCategory">&emsp;&emsp;&emsp;
									<datalist id="staCategory">
									<option>技术-IT技术</option>
									</datalist>
									<label>备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:</label> <input name="salRemark"> <br><br>
									<label>技能等级:</label> <input name="salSkilllevel"> 


									<div class="modal-footer">
										<button data-dismiss="modal" class="btn btn-default"
											type="button">关闭</button>
										<input class="btn btn-primary" type="submit" value="添加">
									</div>
								</form>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>






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
							<th>部门代码</th>
							<th>岗位</th>
							<th>入职日期</th>
							<th>OA账号</th>
							<th>统计类别</th>
							<th>备注</th>
							<th>技能等级</th>
							<th>性别</th>
							<th>出生日期</th>
							<th>身份证号</th>
							<th>家庭住址</th>
							<th>保险基数</th>
							<th>养老编号</th>
							<th>养老保险</th>
							<th>医保编号</th>
							<th>医疗保险</th>
							<th>大病编号</th>
							<th>大病医疗</th>
							<th>保险投保地</th>
							<th>失业编号</th>
							<th>失业保险</th>
							<th>失业投保地</th>
							<th>公积金</th>
							<th>公积金投保地</th>
							<th>投保标志</th>
							<th>保险备注</th>
							<th>失业</th>
							<th>大病</th>
							<th>消耗</th>
							<th>罚款</th>
							<th>扣款</th>
							<th>工废</th>
							<th>水电</th>
							<th>公积金</th>
							<th>上月扣款</th>
							<th>所得税</th>
							<th>实得</th>
							<th>餐补</th>
							<th>司龄工资</th>
							<th>保密工资</th>
							<th>技能工资</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="emp" items="${empList}">
							<c:if test="${emp.salName!=null }">
								<tr>
									<!-- 删除部门 -->
									<td><button type="button" id="deleteDep"
											class="btn btn-primary" onclick="del(${emp.salId})">删除</button></td>
	
									<!-- 修改信息 -->
									<td><button type="button" id="updateDep"
											class="btn btn-primary" data-toggle="modal"
											data-target="#upd${emp.id}">修改</button>
										<div class="modal fade" id="upd${emp.id}"
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
														<form action="/sm/update/emp" method="post" id="fm">
															<input name="id" style="display: none" value="${emp.id }">
															<table align="center" style="border-collapse:separate; border-spacing:15px;">
																<tr>
																	<td><label>姓名:</label></td><td> <input name="salName" required="true" value="${emp.salName}"></td>
																	<td><label>工号:</label></td><td> <input name="salId" required="true" value="${emp.salId}"></td>
																</tr>
																<tr>
																	<td><label>银行账号:</label></td><td> <input name="bankAccount" value="${emp.bankAccount}"></td>
																	<td><label>岗位类别:</label></td><td> <input type="text" name="postCategory" value="${emp.postCategory}"></td>
																</tr>
																<tr>
																	<td><label>部门代码:</label></td><td> <input name="salDep" value="${emp.salDep}"></td>
																	<td><label>岗位:</label></td><td> <input type="text" name="salPost" value="${emp.salPost}"></td>
																</tr>
																<tr>
																	<td><label>入职日期:</label></td><td> <input name="salDate" value="<fmt:formatDate value="${emp.salDate}" type="date"/>"></td>
																	<td><label>OA账号:</label></td><td> <input type="text" name="salOa" value="${emp.salOa}"></td>
																</tr>
																<tr>
																	<td><label>统计类别:</label></td><td> <input type="text" name="staCategory" value="${emp.staCategory}"></td>
																	<td><label>备注:</label></td><td> <input name="salRemark" value="${emp.salRemark}"></td>
																</tr>
																<tr>
																	<td><label>技能等级:</label></td><td> <input type="text" name="salSkilllevel" value="${emp.salSkilllevel}"></td>
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
									<c:forEach var="ins" items="${emp.salInsuranceList}">
										<td>${ins.insSex}</td>
										<td><fmt:formatDate value="${ins.insBoth}" type="date"/></td>
										<td>${ins.insIden}</td>
										<td>${ins.insAddress}</td>
										<td>${ins.insCarNumber}</td>
										<td>${ins.insOldId}</td>
										<td>${ins.insOld}</td>
										<td>${ins.insTreatmentId}</td>
										<td>${ins.insTreatments}</td>
										<td>${ins.insIllId}</td>
										<td>${ins.insIll}</td>
										<td>${ins.insurance}</td>
										<td>${ins.insUnempId}</td>
										<td>${ins.insUnemp}</td>
										<td>${ins.insUnempAddress}</td>
										<td>${ins.insAccFund}</td>
										<td>${ins.insAccAddress}</td>
										<td>${ins.insSign}</td>
										<td>${ins.insRemark}</td>
									</c:forEach>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
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