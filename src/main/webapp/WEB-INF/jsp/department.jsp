<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门管理</title>

<script type="text/javascript">
	//刷新
	function reload(){
		window.location.href="/sm/list/dep"; 
	}
	
	//删除信息
 	function del(userid){
 		if(confirm("您确认删除吗？")){   
            //如果确定删除就访问servlet，这里超链接传值传的是方法里的参数           
            window.location.href="/sm/delete/dep/?id="+userid;
        }
	}
	
	//模糊查询
	function blurrySeach(depId,depName){
		depId = document.getElementById("depId").value;
		depName = document.getElementById("depName").value;
		
		window.location.href="/sm/blurryF/dep/?depId="+depId+"&depName="+depName;
		
	}
</script>

</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<h3 class="text-center text-info">部 门 管 理</h3>
				<br /> <br />
				<div class="input-group">
					部门代码：<input type="text" name="depId" id="depId" value="${param.depId}">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
					部门名称：<input type="text" name="depName" id="depName" value="${param.depName}">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
					<span>
						<button class="btn btn-sm btn-default" type="button" onclick="blurrySeach()" style="height: 25px;margin-top: -5px;width: 48px;font-size: 12px">搜索</button>
					</span>
				</div>
				<br />

				<!-- 首页 -->
				<%@ include file="/WEB-INF/jsp/include/main.jsp"%>
				
				<!-- 刷新 -->
				<button type="button" class="btn btn-default" onclick="reload()">刷新</button>
				
				<!-- 添加部门 -->
				<button type="button" class="btn btn-success" data-toggle="modal"
					data-target="#myModal">添加部门</button>
				<div class="modal fade" id="myModal" data-backdrop="static"
					tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button id="close1" class="close" type="button">
									<span aria-hidden="true">×</span><span class="sr-only">Close</span>
								</button>
								<h4 class="modal-title">添加</h4>
							</div>
							<div class="modal-body">
								<form action="/sm/insert/dep" method="post" id="fm1" onsubmit="return checkAdd()">
									<label>部门代码:</label> <input name="depId" id="idcheck" required="true"><br><br> 
									<label>部门名称:</label> <input name="depName" id="namecheck" required="true"><br><br>
									<label>成本类别:</label> <input name="depCostCategory"><br><br>
									<label>备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:</label> <input type="text" name="depRemark" id="selectDepInput" style="display :none;">
									<select id="selectDep" style="height: 24px;width: 160px;">
										<option style="display :none;"></option>
										<option>在用</option>
										<option>废弃</option>
                       				</select>
									<div class="modal-footer">
										<button id="close2" class="btn btn-default"
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
				
				
				



				<!-- 部门列表 -->
				<table class="table table-hover" id="datagrid">
					<thead>
						<tr>
							<th></th>
							<th>部门代码</th>
							<th>部门名称</th>
							<th>成本类别</th>
							<th>备注</th>
							<th>删除部门</th>
							<th>修改部门</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="dep" items="${listDep}">
							<tr>
								<!-- 和po类里的属性名一样 -->
								<td></td>
								<td>${dep.depId}</td>
								<td>${dep.depName}</td>
								<td>${dep.depCostCategory}</td>
								<td>${dep.depRemark}</td>
								<!-- 删除部门 -->
								<td><button type="button" id="deleteDep" class="btn btn-sm btn-warning" onclick="del(${dep.id})" style="height: 25px;margin-top: -5px;width: 48px;font-size: 11px;margin-top: 2px">删除</button></td>
								
								<!-- 修改部门信息 -->
								<td><button type="button" id="updateDep" class="btn btn-sm btn-default" data-toggle="modal" data-target="#upd${dep.id}" style="height: 25px;margin-top: -5px;width: 48px;font-size: 11px;margin-top: 2px">修改</button>
									<div class="modal fade" id="upd${dep.id}" data-backdrop="static"
											tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<button id="close3${dep.id}" class="close" type="button">
														<span aria-hidden="true">×</span><span class="sr-only">Close</span>
													</button>
													<h4 class="modal-title" align="center">修改</h4>
												</div>
												<div class="modal-body">
													<form action="/sm/update/dep" method="post" id="fm">
															<label style="display: none">id</label> <input style="display: none" name="id" id="Id" value="${dep.id}"> 
															<label>部门代码:</label> <input name="depId" id="dep_id" value="${dep.depId}"><br><br> 
															<label>部门名称:</label> <input name="depName" id="dep_name" value="${dep.depName}"><br><br>
															<label>成本类别:</label> <input name="depCostCategory" value="${dep.depCostCategory}"><br><br>
															<label>备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:</label> <input name="depRemark" value="${dep.depRemark}" id="selectDepInput2${dep.id}" style="display: none;">
															<select id="selectDep2${dep.id}" style="height: 27px;width: 170px;">
																<option style="display: none;">${dep.depRemark}</option>
																<option>在用</option>
																<option>废弃</option>
                       										</select>
															<div class="modal-footer">
															<button id="close4${dep.id}" class="btn btn-default"
																type="button">关闭</button>
															<input class="btn btn-primary" type="submit" value="修改">
															</div>
													</form>
													<script type="text/javascript">
														//模态框关闭	
														$('#close3'+${dep.id}).click(function() {
															$('#upd'+${dep.id}).modal('hide');
														});
														$('#close4'+${dep.id}).click(function() {
															$('#upd'+${dep.id}).modal('hide');
														});
														
														$('#selectDep2'+${dep.id}).change(function() {
															var selectDep = $('#selectDep2'+${dep.id}+' option:selected').text();
															$('#selectDepInput2'+${dep.id}).val(selectDep);
														});
													</script>
												</div>
											</div>
											<!-- /.modal-content -->
										</div>
										<!-- /.modal-dialog -->
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<%-- <!-- 分页 -->
				<div align="center">
					<ul class="pagination" id="pag">
						<li><a href="?start=0">首页</a></li>
						<li><a href="?start=${page.start-page.count>=0?page.start-page.count:0}">上一页</a></li>
						<li><a href="?start=${page.start+page.count<=page.last?page.start+page.count:page.last}">下一页</a></li>
    					<li><a href="?start=${page.last}">末页</a></li>
					</ul>
				</div> --%>
				
			</div>
		</div>
	</div>

<script type="text/javascript">
	$('#selectDep').change(function() {
		var selectDep = $('#selectDep option:selected').text();
		$('#selectDepInput').val(selectDep);
	});
	
	//模态框关闭
	$('#close1').click(function() {
		$('#myModal').modal('hide');
	});
	$('#close2').click(function() {
		$('#myModal').modal('hide');
	});
	
	function checkAdd(){
		var id = $('#idcheck').val();
		var name = $('#namecheck').val();
		if(id==""){
			alert('部门代码不能为空');
			return false;
		}
		if(name==""){
			alert('部门名称不能为空');
			return false;
		}
	}
</script>

</body>
</html>