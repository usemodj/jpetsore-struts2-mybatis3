<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="product.item.list"/></title>
</head>
<body>
<div id="content">
<div class="centered">
	<h2><s:text name="product.item.list"/></h2>
	<h3><s:property value="item.productId"/> </h3>
	<table style="cell-padding:3em;border-width:1px;border-color:#ffeeff">
	<tr><th>itemId</th>
	<th>productId</th>
	<th>listPrice</th>
	<th>unitCost</th>
	<th>supplierId</th>
	<th>status</th>
	<th>attribute1</th>
	<th>attribute2</th>
	<th>attribute3</th>
	<th>attribute4</th>
	<th>attribute5</th></tr>
	<s:iterator value="itemList" status="status">
	   <tr class="<s:if test="#status.odd == true ">odd</s:if><s:else>even</s:else>">
	   		<s:url var="itemUrl"  namespace="/shop" action="item_view">
	   			<s:param name="item.itemId" value="%{itemId}"/>
	   		</s:url>
	     <td><s:a href="%{itemUrl}"><s:property value="itemId" /></s:a></td>
	     <td><s:property value="productId" /></td>
	     <td><s:property value="listPrice" /></td>
	     <td><s:property value="unitCost" /></td>
	     <td><s:property value="supplierId" /></td>
	     <td><s:property value="status" /></td>
	     <td><s:property value="attribute1" escape="false" /></td>
	     <td><s:property value="attribute2" escape="false" /></td>
	     <td><s:property value="attribute3" escape="false" /></td>
	     <td><s:property value="attribute4" escape="false" /></td>
	     <td><s:property value="attribute5" escape="false" /></td>
	   </tr>
	 </s:iterator>
	</table>

</div><!-- div:centered -->
</div><!-- id=contentc -->
</body>
</html>