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
		window.location.href="/sm/select/ins"; 
	}
	
	//保险维护(单)
	function insAdd(){
		window.location.href="/sm/insuranceAdd"; 
	}
	
	//删除信息
 	function del(userid){
 		if(confirm("您确认删除吗？")){   
            //如果确定删除就访问servlet，这里超链接传值传的是方法里的参数           
            window.location.href="/sm/delete/ins/?id="+userid;
        }
	}
	
	//模糊查询
	function blurrySeach(insId,insName){
		insId = document.getElementById("insId").value;
		insName = document.getElementById("insName").value;
		
		window.location.href="/sm/blurry/ins/?insId="+insId+"&insName="+insName;
		
	}
	
</script>

</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<h3 class="text-center text-info">保险金维护</h3>
				<br /> <br />
				<div class="input-group">
					工号：<input type="text" placeholder="Search for..." name="insId"
						id="insId" value="${param.insId}"> <span>
						<button class="btn btn-default" type="button"
							onclick="blurrySeach()">搜索</button>
					</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 姓名：<input type="text"
						placeholder="Search for..." name="insName" id="insName"
						value="${param.insName}"> <span>
						<button class="btn btn-default" type="button"
							onclick="blurrySeach()">搜索</button>
					</span>
				</div>
				<br />

				<!-- 首页 -->
				<%@ include file="/WEB-INF/jsp/include/main.jsp"%>

				<!-- 刷新 -->
				<button type="button" class="btn btn-primary" onclick="reload()">刷新</button>
				
				<!-- 保险维护(单) -->
				<button type="button" class="btn btn-primary" onclick="insAdd()">保险维护(单)</button>
				<span>${param.deleteInsMsg}</span>

				<!-- 部门列表 -->
				<table class="table table-hover" id="datagrid">
					<thead>
						<tr>
							<th>删除</th>
							<th>修改</th>
							<th>工号</th>
							<th>姓名</th>
							<th>性别</th>
							<th>身份证号</th>
							<th>保险基数</th>
							<th>养老保险</th>
							<th>医保</th>
							<th>大病医疗</th>
							<th>失业保险</th>
							<th>公积金</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="ins" items="${listIns}">
							<tr>
								<!-- 删除 -->
								<td><button type="button" id="insId"
										class="btn btn-primary" onclick="del(${ins.id})">删除</button></td>

								<!-- 修改信息 -->
								<td><button type="button" id="updateDep"
										class="btn btn-primary" data-toggle="modal"
										data-target="#upd${ins.id}">修改</button>
									<div class="modal fade" id="upd${ins.id}"
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
													<form action="/sm/update/ins" method="post" id="fm">
														<input style="display: none" name="id" id="Id" value="${ins.id}">
														<table align="center">
															<tr>
																<td><label>姓名:</label></td><td> <input name="insName" required="true" value="${ins.insName}"></td>
																<td><label>工号:</label></td><td> <input name="insId" required="true" value="${ins.insId}"></td>
															</tr>
															<tr>
																<td><label>性别:</label></td><td> <input name="insSex" value="${ins.insSex}"></td>
																<td><label>出生日期:</label></td><td> <input type="text" name="insBoth" value="<fmt:formatDate value="${ins.insBoth}" type="date"/>"></td>
															</tr>
															<tr>
																<td><label>身份证号:</label></td><td> <input name="insIden" value="${ins.insIden}"></td>
																<td><label>家庭住址:</label></td><td> <input type="text" name="insAddress" value="${ins.insAddress}"></td>
															</tr>
															<tr>
																<td><label>保险基数:</label></td><td> <input name="insCarNumber" value="${ins.insCarNumber}"></td>
																<td><label>养老编号:</label></td><td> <input type="text" name="insOldId" value="${ins.insOldId}"></td>
															</tr>
															<tr>
																<td><label>养老保险:</label></td><td> <input name="insOld" value="${ins.insOld}"></td>
																<td><label>医保编号:</label></td><td> <input type="text" name="insTreatmentId" value="${ins.insTreatmentId}"></td>
															</tr>
															<tr>
																<td><label>医疗保险:</label></td><td> <input name="insTreatments" value="${ins.insTreatments}"></td>
																<td><label>大病编号:</label></td><td> <input type="text" name="insIllId" value="${ins.insIllId}"></td>
															</tr>
															<tr>
																<td><label>大病医疗:</label></td><td> <input name="insIll" value="${ins.insIll}"></td>
																<td><label>保险投保地:</label></td><td> <input type="text" name="insurance" value="${ins.insurance}"></td>
															</tr>
															<tr>
																<td><label>失业编号:</label></td><td> <input name="insUnempId" value="${ins.insUnempId}"></td>
																<td><label>失业保险:</label></td><td> <input type="text" name="insUnemp" value="${ins.insUnemp}"></td>
															</tr>
															<tr>
																<td><label>失业投保地:</label></td><td> <input name="insUnempAddress" value="${ins.insUnempAddress}"></td>
																<td><label>公积金:</label></td><td> <input type="text" name="insAccFund" value="${ins.insAccFund}"></td>
															</tr>
															<tr>
																<td><label>公积金投保地:</label></td><td> <input name="insAccAddress" value="${ins.insAccAddress}"></td>
																<td><label>投标标志:</label></td><td> <input type="text" value="${ins.insSign}"></td>
															</tr>
															<tr>
																<td><label>备注:</label></td><td> <input name="insRemark" value="${ins.insRemark}"></td>
																<td><label> </label></td><td> 保：<input type="radio" value="保"name="insSign">  
																				不保：<input type="radio" value="不保"name="insSign"></td>
															</tr>
														</table>
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
								</td>
								
								<!-- 和po类里的属性名一样 -->
								<td>${ins.insId}</td>
								<td>${ins.insName}</td>
								<td>${ins.insSex}</td>
								<td>${ins.insIden}</td>
								<td>${ins.insCarNumber}</td>
								<td>${ins.insOld}</td>
								<td>${ins.insTreatments}</td>
								<td>${ins.insIll}</td>
								<td>${ins.insUnemp}</td>
								<td>${ins.insAccFund}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>