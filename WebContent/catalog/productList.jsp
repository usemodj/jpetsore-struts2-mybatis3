<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head />
<!-- PageDecoratorMapper -->
<META name="decorator" content="main">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="category.product.list" /></title>
</head>
<body>
<div id="content">
<div class="centered">
<h2><s:text name="category.product.list" /></h2>
<h3><s:property value="product.categoryId" /></h3>
<table	style="cell-padding: 3em; border-width: 1px; border-color: #ffeeff">
	<thead>
		<tr>
			<th><s:text name="categoryId" /></th>
			<th><s:text name="productId" /></th>
			<th><s:text name="name" /></th>
			<th><s:text name="description" /></th>
		</tr>
	</thead>
	<s:iterator value="productList" status="status">
		<tr
			class="<s:if test="#status.odd == true ">odd</s:if><s:else>even</s:else>">

			<td><s:property value="categoryId" /></td>
			<td><s:property value="productId" /></td>
			<td><s:property value="name" /></td>
			<s:url id="itemUrl" namespace="/shop" action="item_list">
				<s:param name="item.productId" value="%{productId}" />
			</s:url>
			<td><s:a href="%{itemUrl}">
				<s:property value="description" escape="false" />
			</s:a></td>
		</tr>
	</s:iterator>
</table>
</div><!-- div:centered -->
</div><!-- id=content -->
</body>
</html>