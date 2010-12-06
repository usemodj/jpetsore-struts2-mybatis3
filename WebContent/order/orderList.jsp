<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="order.list"/></title>
</head>
<body>
<div id="content">
<div class="centered">
	<h2><s:text name="order.list"/></h2>
	<p>Order size:<s:property value="orderList.size"/></p>
	<s:iterator value="orderList" status="orderStatus">	
		<table width="80%" style="cell-padding:3em; border-width:1px;border-color:#eeeeee;">
		<tr><th align="right" width="80"><s:text name="order.orderId" /></th><td><s:property value="orderId" /></td></tr>
		<tr><th align="right" width="80"><s:text name="order.shipZip"/></th><td><s:property value="shipZip"/></td></tr>
		<tr><th align="right" width="80"><s:text name="order.shipAddress1" /></th><td><s:property value="shipAddress1"/></td></tr>
		<tr><th align="right" width="80"><s:text name="order.shipAddress2" /></th><td><s:property value="shipAddress2"/></td></tr>
		<tr><th align="right" width="80"><s:text name="order.shipPhone" /></th><td><s:property value="shipPhone"/></td></tr>
		<tr><th align="right" width="80"><s:text name="order.shipCellphone" /></th><td><s:property value="shipCellphone"/></td></tr>
		</table>
		<table width="80%" style="cell-padding:3em;border-width:1px;border-color:#ffeeff">
			<tr><th><s:text name="lineNumber"/></th>
			<th><s:text name="itemId"/></th>
			<th><s:text name="quantity"/></th>
			<th><s:text name="unitPrice"/></th>
			<th><s:text name="total.cost"/></th>
			<th width="68"><s:text name="order.status"/></th> 
			</tr>
		<s:iterator value="lineItems" status="status">
		   <tr class="<s:if test="#status.odd == true ">odd</s:if><s:else>even</s:else>">
		       <td><s:property value="lineNumber" /></td>
		       <s:url var="itemUrl" namespace="/shop" action="item_view">
		           <s:param name="item.itemId" value="%{itemId}"/>
		       </s:url>
		       <td><s:a href="%{itemUrl}"><s:property value="itemId" /></s:a></td>
		       <td align="right"><s:property value="quantity" /></td>
		       <td align="right"><s:property value="unitPrice" /></td>
		       <td align="right"><s:property value="total" /></td>
		       <td>&nbsp;<s:property value="orderStatuses.get(#status.index).status"/></td>
		   </tr>
		 </s:iterator>
		 	<tr><td colspan="5" align="right">
		 		<b><s:text name="sub.total"/>: 
			  <s:text name="totalPrice">
					<s:param name="value" value="totalPrice"/>
				</s:text>
		 		</b><br/>
		 	</td>
		 	<td>&nbsp;</td>
		 	
		 	</tr>
		</table>
	</s:iterator>
</div><!-- clas:centered -->
</div><!-- id=content -->

</body>
</html>