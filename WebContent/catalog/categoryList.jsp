<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="category.list"/></title>
</head>
<body>

<div id="content">
<div class="centered">
	<h2><s:text name="category.list"/></h2>
	<table style="cell-padding:3em;border-width:1px;border-color:#ffeeff">
	 <thead><tr>
	   <th><s:text name="categoryId"/></th>
	   <th><s:text name="name"/></th>
     <th><s:text name="description"/></th>
	 </tr></thead>
	 <tbody>
	<s:iterator value="categoryList" status="status">
	   <tr class="<s:if test="#status.odd == true ">odd</s:if><s:else>even</s:else>">
       <td><s:property value="categoryId" /></td>
       <td><s:property value="name" /></td>
       <s:url id="productUrl" namespace="/shop" action="product_list">
           <s:param name="product.categoryId" value="%{categoryId}"/>
       </s:url>
       <td><s:a href="%{productUrl}"><s:property value="description" escape="false" /></s:a></td>
	   </tr>
	 </s:iterator>
	 </tbody>
	</table>

</div><!-- class:centered -->
</div><!-- id=content -->
</body>
</html>