<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/sm/import" method="post"  enctype="multipart/form-data">
         请选择Excel：<input type="file" name="upfile"><br>
         请输入月份：    <input type="text" name="calDate" id="calDate">&nbsp;&nbsp;
        <input type="submit" value="导入">
    </form>
    &emsp;&emsp;&emsp;&emsp;&emsp;
    &emsp;&emsp;&emsp;&emsp;&emsp;
    &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
    <button onclick="back()">返回</button>
<script type="text/javascript">
	//返回
	function back(){
		window.location.href="/sm/main"; 
	}
	
	$('#calDate').dcalendarpicker({
		format:'yyyy-mm-dd'
	});
</script>
</body>
</html>