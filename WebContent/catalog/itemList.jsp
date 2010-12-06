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
<div>
	<h2><s:text name="product.item.list"/></h2>
	<h3><s:property value="item.productId"/> </h3>
<div class="listView">
<s:iterator value="itemList" status="status">
  <div class="result">
    <div class="number"><s:property value="#status.count"/></div>
        <s:url var="itemUrl"  namespace="/shop" action="item_view">
          <s:param name="item.itemId" value="%{itemId}"/>
        </s:url>
    <div class="productImage"><s:a href="%{itemUrl}"><img width="115" height="115" border="0" src="<%=request.getContextPath()%>/images/catalog/dropwort.jpg"/></s:a></div>
    <div class="productData">
      <div class="productTitle"><s:a href="%{itemUrl}"><s:property value="attribute1" escape="false" /></s:a></div>
      <div class="listPrice"><span><s:property value="listPrice" /></span> &nbsp;원</div>
      <div class="status"><s:text name="status"/>: <s:property value="status" /></div>
      <div> <s:text name="itemId"/>: <s:property value="itemId"/></div>
      <div> <s:text name="productId"/>: <s:property value="productId"/></div>
      <div><s:property value="attribute2" escape="false" /></div>
    </div>
    <s:form action="/shop/cart_addItemToCart">
    <div class="quantity">
        <s:hidden name="itemId" value="%{itemId}"/>
        <s:url var="url" namespace="/shop" action="item_list">
        	<s:param name="item.productId">%{item.productId}</s:param>
        </s:url>
        <s:text var="hostname" name="hostname"/>
        <s:hidden name="url" value='%{hostname}%{url}'/>
        <s:text var="quantity" name="quantity"/>
        <s:select label="%{quantity}:" name="quantity" list="#{1:1,2:2,3:3,4:4,5:5,6:6,7:7,8:8,9:9,10:10,11:11,12:12,13:13,14:14,15:15,16:16,17:17,18:18,19:19,20:20,21:21,22:22,23:23,24:24,25:25,26:26,27:27,28:28,29:29,30:30}"/>
        <s:submit value="장바구니담기"/>
     </div>
     </s:form>
  </div><!-- class:result -->
  <br clear="all"/>
</s:iterator>
</div><!-- class:listView -->	

</div><!-- div:centered -->
</div><!-- id=contentc -->
</body>
</html>