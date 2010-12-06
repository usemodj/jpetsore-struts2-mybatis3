<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Login</title>
</head>

<body>

	<div id="content">
		<div class="round4"></div>
		<div class="round2"></div>
		<div class="round1"></div>
		<div class="centered">
			<table cellpadding="5">
				<tbody>
				<tr>
				<td>
					<s:form action="login" method="post">
					    <s:hidden key="url"/>
					    <s:textfield key="signon.username"/>
					    <s:password key="signon.password" />
					    <s:actionerror /><br/>
					    <s:actionmessage/>
					    <s:submit value="로그인"> <s:url id="url" action="register_input"/> <s:a href="%{url}"><s:text name="register"/></s:a> </s:submit>
					</s:form>

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


