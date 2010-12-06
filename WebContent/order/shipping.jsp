<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="register"/></title>
</head>
<body>
<div id="content">
<div class="centered">
		<div class="round4"></div>
		<div class="round2"></div>
		<div class="round1"></div>
		<div class="box-inner">
			<table cellpadding="5" >
				<tbody>
				<tr>
				<td>
				<h2><s:text name="shipping"/></h2>
				<s:form action="shipping" method="post">
					<s:token/>
					<%-- 
					<s:textfield  key="order.orderId" readonly="true"/>
					--%>	                                  
					<s:textfield  key="order.username"	readonly="true"/> 	                      
					<s:textfield  key="order.shipZip" size="10">		                                      
						<a href="http://www.epost114.co.kr" target="_blank">우편번호검색114...</a>
					</s:textfield>                                                              
					<s:textfield  key="order.shipAddress1" size="35"/>	                            
					<s:textfield  key="order.shipAddress2" size="35"/>
          <s:textfield  key="order.shipPhone" size="20"/>                              
          <s:textfield  key="order.shipCellphone" size="20"/>
							
					<s:actionmessage /><br/>
					<s:actionerror /> 
				
					<s:submit value="배송정보등록" ></s:submit>
				</s:form>
				</td>
				</tr>
				</tbody>
			</table>
		</div>
		<div class="round1"></div>
		<div class="round2"></div>
		<div class="round4"></div>
	</div><!-- class:centered -->
</div><!-- id=content -->

</body>
</html>