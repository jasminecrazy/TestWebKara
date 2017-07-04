<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>

<div class="crumb_nav">
	<a href="index.html">home</a> &gt;&gt; ${category.name }

</div>

<div class="title">
	<span class="title_icon"> <img src="images/bullet1.gif" alt=""
		title=""></span>Category products
</div>


<div class="new_products">

	<c:forEach var="product" items="${category.products }">
		<div class="new_prod_box">
			<a href="${pageContext.request.contextPath }/product/detail/${product.id}.html">${product.name }</a>
			<div class="new_prod_bg">
				<a href="${pageContext.request.contextPath }/product/detail/${product.id}.html"> 
				<img src="${pageContext.request.contextPath }/assets/images/${product.photo }" alt=""
					title="" class="thumb" border="0"></a>
			</div>
		</div>
	</c:forEach>

</div>


<div class="clear"></div>
