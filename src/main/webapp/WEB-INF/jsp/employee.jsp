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
		window.location.href="/sm/list/emp"; 
	}
	
	//删除信息
 	function del(userid){
 		if(confirm("您确认删除吗？")){   
            //如果确定删除就访问servlet，这里超链接传值传的是方法里的参数           
            window.location.href="/sm/delete/emp/?id="+userid;
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
				<h3 class="text-center text-info">部门管理</h3>
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
										name="salId" required="true"> <br> <label>岗&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;位:</label>
									<input name="salPost" list="post">&emsp;&emsp;&emsp;
									<datalist id="post">
									<option>网络工程师</option>
									</datalist>
									<label>银行账户:</label> <input name="bankAccount" required="true"
										style="width: 170px"> <br> <label>岗位类别:</label> <input
										name="postCategory" list="postCategory">&emsp;&emsp;&emsp;
									<datalist id="postCategory">
									<option>技术人员</option>
									</datalist>
									<label>部门名称:</label> <input type="text" name="salDep"
										list="selectDep" style="width: 170px">
									<datalist id="selectDep">
									<option>技术部-信息化组</option>
									</datalist>
									<br> <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Gzsj:</label>
									<input name="salDate">&emsp;&emsp;&emsp; <label>&nbsp;&nbsp;&nbsp;OA账号:</label>
									<input name="salOa"> <br> <label>统计类别:</label> <input
										name="staCategory" list="staCategory">&emsp;&emsp;&emsp;
									<datalist id="staCategory">
									<option>技术-IT技术</option>
									</datalist>
									<label>备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:</label> <input
										name="salRemark"> <br> <label>基本工资:</label> <input
										name="salBasic">&emsp;&emsp;&emsp; <label>会&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;费:</label>
									<input name="salDues"> <br> <label>工&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时:</label>
									<input name="salManhour">&emsp;&emsp;&emsp; <label>岗位工资:</label>
									<input name="salPostsal"> <br> <label>养老保险:</label>
									<input name="endInsurance">&emsp;&emsp;&emsp; <label>工&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价:</label>
									<input name="labourCost"> <br> <label>系&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数:</label>
									<input name="salCoef">&emsp;&emsp;&emsp; <label>效益工资:</label>
									<input name="salBenefitwage"> <br> <label>奖&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;金:</label>
									<input name="salBonus">&emsp;&emsp;&emsp; <label>工&nbsp;&nbsp;时&nbsp;&nbsp;奖:</label>
									<input name="salManhourBonus"> <br> <label>工时工资:</label>
									<input name="salManhourSalary">&emsp;&emsp;&emsp; <label>加&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;班:</label>
									<input name="salOvertime"> <br> <label>津&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;贴:</label>
									<input name="salBenefit">&emsp;&emsp;&emsp; <label>福&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;利:</label>
									<input name="salWelfare"> <br> <label>考评工资:</label>
									<input name="salCheck">&emsp;&emsp;&emsp; <label>工伤产假:</label>
									<input name="salHoliday"> <br> <label>缺&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;勤:</label>
									<input name="salAbsence">&emsp;&emsp;&emsp; <label>其&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;他:</label>
									<input name="salOther"> <br> <label>医&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;保:</label>
									<input name="salHeathInsurance">&emsp;&emsp;&emsp; <label>失&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业:</label>
									<input name="salUnemp"> <br> <label>大&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;病:</label>
									<input name="salIll">&emsp;&emsp;&emsp; <label>消&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;耗:</label>
									<input name="salConsume"> <br> <label>罚&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;款:</label>
									<input name="salPenalty">&emsp;&emsp;&emsp; <label>扣&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;款:</label>
									<input name="salWithhold"> <br> <label>工&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;废:</label>
									<input name="salWaste">&emsp;&emsp;&emsp; <label>水&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电:</label>
									<input name="salWaterandele"> <br> <label>公&nbsp;&nbsp;积&nbsp;&nbsp;金:</label>
									<input name="salAccFund">&emsp;&emsp;&emsp; <label>上月扣款:</label>
									<input name="salLastWithhold"> <br> <label>所&nbsp;&nbsp;得&nbsp;&nbsp;税:</label>
									<input name="salIncometax">&emsp;&emsp;&emsp; <label>餐&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;补:</label>
									<input name="salAllowance"> <br> <label>司龄工资:</label>
									<input name="salYears">&emsp;&emsp;&emsp; <label>保密工资:</label>
									<input name="salSecrecy"> <br> <label>应发工资:</label>
									<input name="salShould">&emsp;&emsp;&emsp; <label>技能等级:</label>
									<input name="salSkilllevel"> <br> <label>技能工资:</label>
									<input name="salSkillsalary">&emsp;&emsp;&emsp; <label>实&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;得:</label>
									<input name="salRealization">


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
							<th>Gzsj</th>
							<th>OA账号</th>
							<th>统计类别</th>
							<th>备注</th>
							<th>基本工资</th>
							<th>会费</th>
							<th>工时</th>
							<th>岗位工资</th>
							<th>养老保险</th>
							<th>工价</th>
							<th>系数</th>
							<th>效益工资</th>
							<th>奖金</th>
							<th>工时奖</th>
							<th>工时工资</th>
							<th>加班</th>
							<th>津贴</th>
							<th>福利</th>
							<th>考评工资</th>
							<th>工伤产假</th>
							<th>缺勤</th>
							<th>其他</th>
							<th>应发工资</th>
							<th>医保</th>
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
							<th>技能等级</th>
							<th>技能工资</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="emp" items="${empList}">
							<tr>
								<!-- 删除部门 -->
								<td><button type="button" id="deleteDep"
										class="btn btn-primary" onclick="del(${emp.id})">删除</button></td>

								<!-- 修改部门信息 -->
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
														<input name="id" style="display: none" value="${emp.id }"> <label>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</label>
														<input name="salName" required="true" value="${emp.salName }">&emsp;&emsp;&emsp;
														<label>工&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:</label>
														<input name="salId" required="true" value="${emp.salId }"> <br> <label>岗&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;位:</label>
														<input name="salPost" list="post" value="${emp.salPost }">&emsp;&emsp;&emsp;
														<datalist id="post">
														<option>网络工程师</option>
														</datalist>
														<label>银行账户:</label> <input name="bankAccount"
															required="true" style="width: 170px" value="${emp.bankAccount }"> <br> <label>岗位类别:</label>
														<input name="postCategory" list="postCategory" value="${emp.postCategory }">&emsp;&emsp;&emsp;
														<datalist id="postCategory">
														<option>技术人员</option>
														</datalist>
														<label>部门名称:</label> <input type="text" name="salDep"
															list="selectDep" style="width: 170px" value="${emp.salDep }">
														<datalist id="selectDep">
														<option>技术部-信息化组</option>
														</datalist>
														<br> <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Gzsj:</label>
														<input name="salDate" value="${emp.salDate }">&emsp;&emsp;&emsp; <label>&nbsp;&nbsp;&nbsp;OA账号:</label>
														<input name="salOa" value="${emp.salOa }"> <br> <label>统计类别:</label>
														<input name="staCategory" list="staCategory" value="${emp.staCategory }">&emsp;&emsp;&emsp;
														<datalist id="staCategory">
														<option>技术-IT技术</option>
														</datalist>
														<label>备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:</label>
														<input name="salRemark" value="${emp.salRemark }"> <br> <label>基本工资:</label>
														<input name="salBasic" value="${emp.salBasic }">&emsp;&emsp;&emsp; <label>会&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;费:</label>
														<input name="salDues" value="${emp.salDues }"> <br> <label>工&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时:</label>
														<input name="salManhour" value="${emp.salManhour }">&emsp;&emsp;&emsp; <label>岗位工资:</label>
														<input name="salPostsal" value="${emp.salPostsal }"> <br> <label>养老保险:</label>
														<input name="endInsurance" value="${emp.endInsurance }">&emsp;&emsp;&emsp; <label>工&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价:</label>
														<input name="labourCost" value="${emp.labourCost }"> <br> <label>系&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数:</label>
														<input name="salCoef" value="${emp.salCoef }">&emsp;&emsp;&emsp; <label>效益工资:</label>
														<input name="salBenefitwage" value="${emp.salBenefitwage }"> <br> <label>奖&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;金:</label>
														<input name="salBonus" value="${emp.salBonus }">&emsp;&emsp;&emsp; <label>工&nbsp;&nbsp;时&nbsp;&nbsp;奖:</label>
														<input name="salManhourBonus" value="${emp.salManhourBonus }"> <br> <label>工时工资:</label>
														<input name="salManhourSalary" value="${emp.salManhourSalary }">&emsp;&emsp;&emsp;
														<label>加&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;班:</label>
														<input name="salOvertime" value="${emp.salOvertime }"> <br> <label>津&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;贴:</label>
														<input name="salBenefit" value="${emp.salBenefit }">&emsp;&emsp;&emsp; <label>福&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;利:</label>
														<input name="salWelfare" value="${emp.salWelfare }"> <br> <label>考评工资:</label>
														<input name="salCheck" value="${emp.salCheck }">&emsp;&emsp;&emsp; <label>工伤产假:</label>
														<input name="salHoliday" value="${emp.salHoliday }"> <br> <label>缺&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;勤:</label>
														<input name="salAbsence" value="${emp.salAbsence }">&emsp;&emsp;&emsp; <label>其&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;他:</label>
														<input name="salOther" value="${emp.salOther }"> <br> <label>医&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;保:</label>
														<input name="salHeathInsurance" value="${emp.salHeathInsurance }">&emsp;&emsp;&emsp;
														<label>失&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业:</label>
														<input name="salUnemp" value="${emp.salUnemp }"> <br> <label>大&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;病:</label>
														<input name="salIll" value="${emp.salIll }">&emsp;&emsp;&emsp; <label>消&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;耗:</label>
														<input name="salConsume" value="${emp.salConsume }"> <br> <label>罚&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;款:</label>
														<input name="salPenalty" value="${emp.salPenalty }">&emsp;&emsp;&emsp; <label>扣&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;款:</label>
														<input name="salWithhold" value="${emp.salWithhold }"> <br> <label>工&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;废:</label>
														<input name="salWaste" value="${emp.salWaste }">&emsp;&emsp;&emsp; <label>水&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电:</label>
														<input name="salWaterandele" value="${emp.salWaterandele }"> <br> <label>公&nbsp;&nbsp;积&nbsp;&nbsp;金:</label>
														<input name="salAccFund" value="${emp.salAccFund }">&emsp;&emsp;&emsp; <label>上月扣款:</label>
														<input name="salLastWithhold" value="${emp.salLastWithhold }"> <br> <label>所&nbsp;&nbsp;得&nbsp;&nbsp;税:</label>
														<input name="salIncometax" value="${emp.salIncometax }">&emsp;&emsp;&emsp; <label>餐&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;补:</label>
														<input name="salAllowance" value="${emp.salAllowance }"> <br> <label>司龄工资:</label>
														<input name="salYears" value="${emp.salYears }">&emsp;&emsp;&emsp; <label>保密工资:</label>
														<input name="salSecrecy" value="${emp.salSecrecy }"> <br> <label>应发工资:</label>
														<input name="salShould" value="${emp.salShould }">&emsp;&emsp;&emsp; <label>技能等级:</label>
														<input name="salSkilllevel" value="${emp.salSkilllevel }"> <br> <label>技能工资:</label>
														<input name="salSkillsalary" value="${emp.salSkillsalary }">&emsp;&emsp;&emsp; <label>实&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;得:</label>
														<input name="salRealization" value="${emp.salRealization }">
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
								<td>${emp.salDate}</td>
								<td>${emp.salOa}</td>
								<td>${emp.staCategory}</td>
								<td>${emp.salRemark}</td>
								<td>${emp.salBasic}</td>
								<td>${emp.salDues}</td>
								<td>${emp.salManhour}</td>
								<td>${emp.salPostsal}</td>
								<td>${emp.endInsurance}</td>
								<td>${emp.labourCost}</td>
								<td>${emp.salCoef}</td>
								<td>${emp.salBenefitwage}</td>
								<td>${emp.salBonus}</td>
								<td>${emp.salManhourBonus}</td>
								<td>${emp.salManhourSalary}</td>
								<td>${emp.salOvertime}</td>
								<td>${emp.salBenefit}</td>
								<td>${emp.salWelfare}</td>
								<td>${emp.salCheck}</td>
								<td>${emp.salHoliday}</td>
								<td>${emp.salAbsence}</td>
								<td>${emp.salOther}</td>
								<td>${emp.salShould}</td>
								<td>${emp.salHeathInsurance}</td>
								<td>${emp.salUnemp}</td>
								<td>${emp.salIll}</td>
								<td>${emp.salConsume}</td>
								<td>${emp.salPenalty}</td>
								<td>${emp.salWithhold}</td>
								<td>${emp.salWaste}</td>
								<td>${emp.salWaterandele}</td>
								<td>${emp.salAccFund}</td>
								<td>${emp.salLastWithhold}</td>
								<td>${emp.salIncometax}</td>
								<td>${emp.salRealization}</td>
								<td>${emp.salAllowance}</td>
								<td>${emp.salYears}</td>
								<td>${emp.salSecrecy}</td>
								<td>${emp.salSkilllevel}</td>
								<td>${emp.salSkillsalary}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>