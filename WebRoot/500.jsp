<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	
	<script type="text/javascript">
	
		function fanhui(){
			window.parent.location.href='${pageContext.request.contextPath}/login.jsp';
		}
	
	</script>	

</head>
<body style="text-align:center;">
	<img alt="" src="${pageContext.request.contextPath}/manager/500.png" onclick="fanhui()" />
</body>
</html>