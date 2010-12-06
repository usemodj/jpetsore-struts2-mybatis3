<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="order.submit"/></title>
</head>
<body>
<div id="content">
<div class="centered">
	<h2><s:text name="order.submit"/></h2>
	
	<table width="100%" style="cell-padding:3em; border-width:1px;border-color:#eeeeee;">
	<tr><th align="right" width="80"><s:text name="order.shipZip" 			/></th><td><s:property value="order.shipZip"     /></td></tr>
	<tr><th align="right" width="80"><s:text name="order.shipAddress1" /></th><td><s:property value="order.shipAddress1"/></td></tr>
	<tr><th align="right" width="80"><s:text name="order.shipAddress2" /></th><td><s:property value="order.shipAddress2"/></td></tr>
  <tr><th align="right" width="80"><s:text name="order.shipPhone" /></th><td><s:property value="order.shipPhone"/></td></tr>
  <tr><th align="right" width="80"><s:text name="order.shipCellphone" /></th><td><s:property value="order.shipCellphone"/></td></tr>
	</table>
	<table width="100%" style="cell-padding:3em;border-width:1px;border-color:#ffeeff">
		<tr><th><s:text name="itemId"/></th><th><s:text name="productId"/></th><th><s:text name="description"/></th>
				<th><s:text name="inStock"/></th><th><s:text name="quantity"/></th><th><s:text name="list.price"/></th>
				<th><s:text name="total.cost"/></th><th>&nbsp;</th> </tr>
	<s:iterator value="cart.cartItemList" status="status">
	   <tr class="<s:if test="#status.odd == true ">odd</s:if><s:else>even</s:else>">
	       <s:url var="itemUrl" namespace="/shop" action="item_view">
	           <s:param name="item.itemId" value="%{item.itemId}"/>
	       </s:url>
	        <td><s:a href="%{itemUrl}"><s:property value="item.itemId" /></s:a></td>
	       <td><s:property value="item.productId" /></td>
	       <td><s:property value="item.attribute1" escape="false" />
	       			<s:property value="item.attribute2" escape="false" />
	       			<s:property value="item.attribute3" escape="false" />
	       			<s:property value="item.attribute4" escape="false" />
	       			<s:property value="item.attribute5" escape="false" />
	       </td>
	       <td><s:property value="inStock" /></td>
	       <td align="right">
	       	 <s:property value='quantity' />
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
	       <td>&nbsp;</td>
	   </tr>
	 </s:iterator>
	 	<tr><td colspan="7" align="right">
	 		<b><s:text name="sub.total"/>: 
		  <s:text name="cart.subTotal">
				<s:param name="value" value="cart.subTotal"/>
			</s:text>
	 		</b><br/>
	    <button type="button" onclick="document.location='<s:url namespace="/shop" action="order"/>'">
	    <s:text name="order.submit"/></button>
	 	</td>
	 	<td>&nbsp;</td>
	 	</tr>
	</table>
	</div><!-- class:centered -->
</div><!-- id=content -->

</body>
</html>