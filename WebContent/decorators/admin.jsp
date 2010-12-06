<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="decorator"	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
<title><decorator:title default="순천만 미나리" /></title>
<link href="<%=request.getContextPath()%>/decorators/main.css" rel="stylesheet" type="text/css"/>
<decorator:head />
</head>

<body>

	<div id="main">
		<div id="topbar">
			<div style="float:left"><a href="<%=request.getContextPath()%>">홈:순천만 미나리</a></div>
			
		<% if(null == session.getAttribute("login")){ %>
		  <a href="<%=request.getContextPath()%>/login_input?url=<s:text name='hostname'/><%=request.getRequestURI()%>?<%=request.getQueryString() %>"><s:text name="login"/></a>
		<% }else {%>
		  <a href="<%=request.getContextPath()%>/logout?url=<s:text name='hostname'/><%=request.getRequestURI()%>?<%=request.getQueryString() %>"><s:text name="logout"/></a>
		 | <a href='<s:url namespace="/" action="signon_input"/>'><s:text name="signon.input"/></a>
		<% }%>
		
		| <a href="<%= request.getContextPath() %>/shop/cart"><s:text name="cart"/></a> &nbsp;
		</div>
		<%-- 
		<div style="float: right; width: 20em; margin: 0pt 0pt 1em 2em;">
			<page:applyDecorator name="widget" page="/google.html" />
			<page:applyDecorator name="widget" page="/tiny-panel.html" /> 
		</div>
		--%>
		<decorator:body />
		
		<br class="clear:both"/>
		<br/>
		<div id="footer">
			<p class="copyright">Copyright &copy; 2010 usemodj.com. All rights reserved.</p>
		</div>
	</div><!--/main-->

</body>
</html>