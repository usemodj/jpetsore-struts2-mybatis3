<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head />
<!-- PageDecoratorMapper -->
<%-- META name="decorator" content="widget"--%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="item.view"/></title>
</head>
<body>
<div id="content">
<div class="centered">
	<h2><s:text name="item.view"/></h2>
	<h3><s:property value="item.productId"/> </h3>
	<table style="padding:1em 3em;border-width:1px;border-color:#feeeeee">
	   <tr class="odd"><th>itemId</th><td><s:property value="item.itemId" /></td></tr>
	     <tr class="even"><th>productId</th><td><s:property value="item.productId" /></td></tr>
	     <tr class="odd"><th>listPrice</th><td><s:property value="item.listPrice" /></td></tr>
	     <tr class="even"><th>unitCost</th><td><s:property value="item.unitCost" /></td></tr>
	     <tr class="odd"><th>supplierId</th><td><s:property value="item.supplierId" /></td></tr>
	     <tr class="even"><th>status</th><td><s:property value="item.status" /></td></tr>
	     <tr class="odd"><th>attribute1</th><td><s:property value="item.attribute1" escape="false" /></td></tr>
	     <tr class="even"><th>attribute2</th><td><s:property value="item.attribute2" escape="false" /></td></tr>
	     <tr class="odd"><th>attribute3</th><td><s:property value="item.attribute3" escape="false" /></td></tr>
	     <tr class="even"><th>attribute4</th><td><s:property value="item.attribute4" escape="false" /></td></tr>
	     <tr class="odd"><th>attribute5</th><td><s:property value="item.attribute5" escape="false" /></td></tr>
	   	</table>
</div><!-- class:centered -->
</div><!-- id=content -->
</body>
</html>

