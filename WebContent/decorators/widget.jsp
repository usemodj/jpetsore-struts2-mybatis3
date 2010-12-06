<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<html>
<head>
	<link href="<%=request.getContextPath()%>/decorators/widget.css" rel="stylesheet" type="text/css">
	<decorator:head />
</head>
<body>
	<div class="pmeta_bubble_bg">
		<div class="round4"></div>
		<div class="round2"></div>
		<div class="round1"></div>
		<div class="box-inner">
			<table class="pmeta" cellpadding="5">
				<tbody>
				<tr>
				<td><decorator:body />
				</td>
				</tr>
				</tbody>
			</table>
		</div>
		<div class="round1"></div>
		<div class="round2"></div>
		<div class="round4"></div>
	</div>
	
</body>
</html>