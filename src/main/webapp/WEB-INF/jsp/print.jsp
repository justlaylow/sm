<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>打印工资</title>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="dropdown">
				    <button type="button" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown" style="margin-top: 35px">
				      	导 出 工 资 文 件
				      <span class="caret"></span>          
				    </button>
				    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				    <c:forEach var="dep" items="${listDep }">
					      <li>
					         <a href="javascript:void(0)" id="a${dep.id}">${dep.depName}</a>             
					      </li>
					      <script type="text/javascript">
							 $("#a"+${dep.id} ).click(function() {
								var a1 = $('#a'+${dep.id} ).text();
								window.location = "/sm/departmentSalary?salDep="+a1;
							 });
						  </script>
				      </c:forEach>
				      <li role="presentation">
				         <a href="javascript:void(0)" id="az">月工资汇总(应发)</a>              
				      </li>
				 
				      <li role="presentation">
				         <a href="javascript:void(0)" id="ax">月工资汇总(实得)</a>           
				      </li>
				      
				      <li role="presentation">
				         <a href="javascript:void(0)" id="ac">月工资统计(应发)</a>           
				      </li>
				      
				      <li role="presentation">
				         <a href="javascript:void(0)" id="av">月工资统计(实得)</a>           
				      </li>
				      
				      <li role="presentation">
				         <a href="javascript:void(0)" id="ab">送银行文件</a>           
				      </li>
				    </ul>
				</div>
			</div>
		</div>
	</div>
	
<script type="text/javascript">
	$("#az").click(function() {
		window.location = "/sm/departmentShould";
	});
	
	$("#ax").click(function() {
		window.location = "/sm/departmentReality";
	});
	
	$("#ac").click(function() {
		window.location = "/sm/categoryShould";
	});
	
	$("#av").click(function() {
		window.location = "/sm/categoryReality";
	});
	$("#ab").click(function() {
		window.location = "/sm/sendBank";
	});
</script>
</body>
</html>