<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script src="${pageContext.request.contextPath }/assets/js/jquery-1.6.2.js" 
type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/assets/js/jquery-ui-1.8.2.custom.js" 
type="text/javascript"></script>
<link href="${pageContext.request.contextPath }/assets/css/themes/base/jquery.ui.all.css" 
type="text/css" rel="stylesheet">

<script type="text/javascript">
$(document).ready(function(){
	$('#keyword').autocomplete({
		source: '${pageContext.request.contextPath }/demo/process.html'
	});	
});
</script>

</head>
<body>

Search <input type="text" id="keyword">

</body>
</html>