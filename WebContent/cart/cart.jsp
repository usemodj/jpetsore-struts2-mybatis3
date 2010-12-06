<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="shopping.cart"/></title>
</head>
<body>
<div id="content">
  <div class="centered">
	<h2><s:text name="shopping.cart"/></h2>
	<table id="cart" border="1" style="cell-padding:3em;border-width:1px;border-color:#333">
	<s:form action="cart_updateCartQuantities" method="post">
		<thead><tr><th width="60"><s:text name="itemId"/></th>
			<th width="60"><s:text name="productId"/></th>
			<th width="180"><s:text name="description"/></th>
			<th width="60"><s:text name="inStock"/></th>
			<th width="60"><s:text name="quantity"/></th>
			<th width="80"><s:text name="list.price"/></th>
			<th width="80"><s:text name="total.cost"/></th><th>&nbsp;</th> 
			</tr></thead>
			<tbody>
	<s:iterator value="cart.cartItemList" status="status">
	   <tr class="<s:if test="#status.odd == true ">odd</s:if><s:else>even</s:else>">
	       <s:url id="itemUrl" namespace="/shop" action="item_view">
	           <s:param name="item.itemId" value="%{item.itemId}"/>
	       </s:url>
	        <td><s:a href="%{itemUrl}"><s:property value="item.itemId" /></s:a></td>
	       <td><s:property value="item.productId" /></td>
	       <td><s:property value="item.attribute1" escape="false" />
	       </td>
	       <td><s:property value="inStock" /></td>
	       <td align="right">
	       	 <input name="<s:property value="item.itemId" />" value="<s:property value='quantity' />"  size="3" type="text"/>
	       </td> 
	       <td align="right">
		       	<s:text name="item.listPrice">
							<s:param name="value" value="item.listPrice"/>
						</s:text>
	        </td>
	       <td align="right">
		       	<s:text name="total">
							<s:param name="value" value="total"/>
						</s:text>
						
	        </td>
	       <s:url var="removeUrl" namespace="/shop" action="cart_removeItemFromCart">
	           <s:param name="itemId" value="%{item.itemId}"/>
	       </s:url>
	       <td><s:a href="%{removeUrl}" ><s:text name="remove.button" /></s:a></td>
	   </tr>
	 </s:iterator>
	 	<tr><td colspan="7" align="right">
	 		<s:text name="sub.total"/>: 
	 		<s:text name="cart.subTotal">
				<s:param name="value" value="cart.subTotal"/>
			</s:text>
	 		<br/>
	 		<button type="button" onclick="document.location='<s:property value="url"/>'"> <s:text name="continue.shopping"/></button>
 			<input value='<s:text name="update.button"/>' type="submit" <s:if test="%{cart.numberOfItems < 1}"> disabled="disabled"</s:if> />
       &nbsp;<button type="button" onclick="document.location='<s:url namespace="/shop" action="cart_save"/>'" <s:if test="%{cart.numberOfItems < 1}"> disabled="disabled"</s:if>><s:text name="cart.save.button" /></button>&nbsp;&nbsp;
       <button type="button" onclick="document.location='<s:url namespace="/shop" action="cart_checkout"/>'" <s:if test="%{cart.numberOfItems < 1}"> disabled="disabled"</s:if>><s:text name="checkout.button"/></button>
	 	</td>
	 	<td>&nbsp;</td>
	 	</tr>
	 	</tbody>
	</s:form>
	</table>
  </div><!-- class:centered -->
</div><!-- id=content -->
</body>
</html>