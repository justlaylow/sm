<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/header.jsp"%>
<%@ include file="/WEB-INF/jsp/include/background.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column" style="text-align: center">
				<h3 class="text-center text-info">工 资 表 数 据 导 入</h3>
				<br>
				<div style="text-align: center; width: 400px; margin: auto;">
					<form action="/sm/beforeImport" method="post"
						enctype="multipart/form-data" id="formSub">
						&emsp;请选择Excel： <input type="file" name="upfile"
							style="margin-left: 130px; margin-top: 10px" id="excelFile"><br> <span
							style="margin-left: -50px">请输入工资月份：</span> <input type="text"
							name="calDate" id="calDate" required="true"> <input
							value="导入" type="button" id="import">
					</form>
					&emsp;&emsp;&emsp;&emsp;&emsp; &emsp;&emsp;&emsp;&emsp;&emsp;
					&emsp;&emsp;&emsp;&emsp;&emsp;
					<button onclick="back()">返回</button>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		//返回
		function back() {
			window.location.href = "/sm/main";
		}

		$('#calDate').dcalendarpicker({
			format : 'yyyy-mm-dd'
		});
		
		$('#import').click(function(){
			var excelFile = $('#excelFile').val();
			var calDate = $('#calDate').val();
			if(excelFile==0){
				confirm("请选择文件");
				return false;
			}else if(calDate==0){
				confirm("请选择日期");
				return false;
			}
			$('#formSub').submit();
		});
		
	</script>
</body>
</html>