<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="order.submit"/></title>
</head>
<body>
<div id="content">

	<h2> 주문예약 제출이 성공적으로 완료 되었습니다.</h2>
	<div style="line-height:1.5em;">
	 <p>결제 방법은 계좌이체 입니다. 입금이 확인되면 배송이 이루어 집니다.</p>
		<p>
		 계좌번호: 농협  xxx-xxx-xxx <br/>
		 예금자명: 서석진
		</p>
		&nbsp;
		<s:url var="ordersUrl" namespace="/shop" action="order_list">
			<s:param name="order.orderId" value="order.orderId"/>
		</s:url>
		<p><s:a href="%{ordersUrl}"><s:text name="order.list"/></s:a></p>
	</div>
</div><!-- id=content -->
</body>
</html>
  
  
  