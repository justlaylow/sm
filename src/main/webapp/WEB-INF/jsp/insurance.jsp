<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/header.jsp"%>
<%@ include file="/WEB-INF/jsp/include/background.jsp"%>
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
	
	//批量更新
	function insUpdateImport(){
		window.location.href="/sm/insUpdateFile"; 
	}
	
	//批量导入
	function insImport(){
		window.location.href="/sm/insImportFile"; 
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
				<h3 class="text-center text-info">保 险 金 维 护</h3>
				<br /> <br />
				<div class="input-group">
					工号：<input type="text" placeholder="Search for..." name="insId"
						id="insId" value="${param.insId}"> <span>
					</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 姓名：<input type="text"
						placeholder="Search for..." name="insName" id="insName"
						value="${param.insName}"> <span>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<button class="btn btn-default" type="button"
							onclick="blurrySeach()">搜索</button>
					</span>
				</div>
				<br />

				<!-- 首页 -->
				<%@ include file="/WEB-INF/jsp/include/main.jsp"%>

				<!-- 刷新 -->
				<button type="button" class="btn btn-default" onclick="reload()">刷新</button>
				
				<!-- 保险维护(单) -->
				<button type="button" class="btn btn-default" onclick="insAdd()">保险维护(单)</button>
				
				<!-- 批量更新 -->
				<button type="button" class="btn btn-default" onclick="insUpdateImport()">批量更新</button>
				
				<!-- 批量导入 -->
				<button type="button" class="btn btn-default" onclick="insImport()">批量导入</button>

				<!-- 部门列表 -->
				<form action="/sm/updateBatch/ins" method="post" id="fm">
				<table class="table table-bordered" id="datagrid" style="white-space: nowrap;">
					<thead>
						<tr>
							<th>删除</th>
							<th>工号</th>
							<th>姓名</th>
							<th>性别</th>
							<!-- <th>身份证号</th> -->
							<th>保险基数</th>
							<th>养老保险</th>
							<th>医保</th>
							<th>大病医疗</th>
							<th>失业保险</th>
							<th>公积金</th>
							<th>养老投保地</th>
							<th>失业投保地</th>
							<th>公积金投保地</th>
							<th>医保投保地</th>
							<th>备注</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="ins" items="${listIns}" varStatus="i">
							<tr>
								<!-- 删除 -->
								<td><button type="button" id="insId"
										class="btn btn-sm btn-warning" onclick="del(${ins.id})">删除</button></td>
								
								<!-- 和po类里的属性名一样 -->
									<td> <input style="display: none" name="insurance[${i.index}].id" id="Id" value="${ins.id}">
										 <input name="insurance[${i.index}].insId" required="true" value="${ins.insId}" style="width: 70px;"></td>
									<td> <input name="insurance[${i.index}].insName" required="true" value="${ins.insName}" style="width: 70px;"></td>
									<td> <input name="insurance[${i.index}].insSex" value="${ins.insSex}" style="width: 40px;text-align: center;"></td>
									<%-- <td> <input name="insurance[${i.index}].insIden" value="${ins.insIden}"></td> --%>
									<td> <input name="insurance[${i.index}].insCarNumber" value="${ins.insCarNumber}" style="width: 70px;"></td>
									<td> <input name="insurance[${i.index}].insOld" value="${ins.insOld}" style="width: 70px;"></td>
									<td> <input name="insurance[${i.index}].insTreatments" value="${ins.insTreatments}" style="width: 70px;"></td>
									<td> <input name="insurance[${i.index}].insIll" value="${ins.insIll}" style="width: 70px;"></td>
									<td> <input type="text" name="insurance[${i.index}].insUnemp" value="${ins.insUnemp}" style="width: 70px;"></td>
									<td> <input type="text" name="insurance[${i.index}].insAccFund" value="${ins.insAccFund}" style="width: 70px;"></td>
									<td> <input type="text" name="insurance[${i.index}].insurance" value="${ins.insurance}" style="width: 80px;text-align: center;"></td>
									<td> <input name="insurance[${i.index}].insUnempAddress" value="${ins.insUnempAddress}" style="width: 80px;text-align: center;"></td>
									<td> <input name="insurance[${i.index}].insAccAddress" value="${ins.insAccAddress}" style="width: 100px;text-align: center;"></td>
									<td> <input type="text" name="insurance[${i.index}].insSign" value="${ins.insSign}" style="width: 70px;"></td>
									<td> <input name="insurance[${i.index}].insRemark" value="${ins.insRemark}" style="width: 100px;"></td>
								
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<p align="center"><input type="submit" id="insId" class="btn btn-sm btn-success" value="修改" style="position: fixed;bottom: 0"/></p>
				</form>
			</div>
		</div>
	</div>

</body>
</html>