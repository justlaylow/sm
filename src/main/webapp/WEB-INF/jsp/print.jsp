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
				    <button type="button" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">
				      	导 出 工 资 文 件
				      <span class="caret"></span>          
				    </button>
				    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				      <c:forEach var="dep" items="${listDep }">
					      <li>
					         <a href="javascript:void(0)" id="a${dep.id}">${dep.depName}</a>             
					      </li>
					      <script type="text/javascript">
							 $("#a"+${dep.id}).click(function() {
								var a1 = $('#a'+${dep.id}).text();
								window.location = "/sm/departmentSalary?salDep="+a1;
							 });
						  </script>
				      </c:forEach>
				      <li role="presentation">
				         <a href="#">CSS</a>              
				      </li>
				 
				      <li role="presentation">
				         <a href="#">Javascript</a>           
				      </li>
				      <li role="presentation">
				         <a href="#">AJAX</a>             
				      </li>
				    </ul>
				</div>
			</div>
		</div>
	</div>
	

</body>
</html>