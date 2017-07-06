<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath }/assets/js/jquery-1.6.2.js" 
type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function(){

	$('#buttonDemo1').click(function(){
		$.ajax({
			type: 'GET', 
			url: '${pageContext.request.contextPath }/demo/work1.html',
			success: function(result) {
				$('#result1').html(result);
			}
		});
	});

	$('#buttonDemo2').click(function(){
		var fullName = $('#fullName').val();
		$.ajax({
			type: 'GET', 
			url: '${pageContext.request.contextPath }/demo/work2/' + fullName + '.html',
			success: function(result) {
				$('#result2').html(result);
			}
		});
	});

	$('#buttonDemo3').click(function(){
		$.ajax({
			type: 'GET', 
			url: '${pageContext.request.contextPath }/demo/work3.html',
			headers: {
				Accept: "application/json",
				"Content-Type": "application/json"
			},
			success: function(result) {
				var s = 'Id: ' + result.id;
				s += '<br>Name: ' + result.name;
				s += '<br>Price: ' + result.price;
				$('#result3').html(s);
			}
		});
	});

	$('#buttonDemo4').click(function(){
		$.ajax({
			type: 'GET', 
			url: '${pageContext.request.contextPath }/demo/work4.html',
			headers: {
				Accept: "application/json",
				"Content-Type": "application/json"
			},
			success: function(result) {
				var s = '<table border="1">';
				s += '<tr><th>Id</th><th>Name</th><th>Price</th></tr>';
				for(var i = 0; i < result.length; i++) {
					s += '<tr>';
					s += '<td>' + result[i].id + '</td>';
					s += '<td>' + result[i].name + '</td>';
					s += '<td>' + result[i].price + '</td>';	
					s += '</tr>';
				}
				s += '</table>';
				$('#result4').html(s);
			}
		});
	});
	
});
</script>
</head>
<body>

<fieldset>
	<legend>Demo 1</legend>	
	<form>
		<input type="button" value="Demo 1" 
		id="buttonDemo1">
		<br>
		<span id="result1"></span>
	</form>
</fieldset>

<fieldset>
	<legend>Demo 2</legend>
	<form>
		Full Name <input type="text" id="fullName">
		<br>
		<input type="button" value="Demo 2" 
		id="buttonDemo2">
		<br>
		<span id="result2"></span>
	</form>
</fieldset>

<fieldset>
	<legend>Demo 3</legend>	
	<form>
		<input type="button" value="Demo 3" 
		id="buttonDemo3">
		<br>
		<span id="result3"></span>
	</form>
</fieldset>

<fieldset>
	<legend>Demo 4</legend>	
	<form>
		<input type="button" value="Demo 4" 
		id="buttonDemo4">
		<br>
		<div id="result4">
			
		</div>
	</form>
</fieldset>


</body>
</html>