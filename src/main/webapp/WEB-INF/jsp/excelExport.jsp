<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/header.jsp"%>
<%@ include file="/WEB-INF/jsp/include/background.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>工资表数据导出</title>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column" style="text-align: center">
				<h3 class="text-center text-info">工 资 表 数 据 导 出</h3>
				<br>
				<br>
				<div style="text-align: center;">
					<form action="/sm/export" method="post">
						导出工资日期：<input name="calDate" id="calendar" required="true"> <input
							type="submit" value="导出">
					</form>
					&emsp;&emsp;&emsp;&emsp;&emsp; &emsp;&emsp;&emsp;&emsp;&emsp;
					&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;&nbsp;
					<button id="back">返回</button>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		//返回
		$('#back').click(function() {
			window.location.href = "/sm/main";
		});

		$('#calendar').dcalendarpicker({
			format : 'yyyy-mm-dd'
		});
	</script>
</body>
</html>