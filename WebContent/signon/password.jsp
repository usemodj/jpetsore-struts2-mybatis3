<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<s:head />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><s:text name="change.password"/></title>
</head>
<body>
<div id="content" class="centered">
		<div class="round4"></div>
		<div class="round2"></div>
		<div class="round1"></div>
		<div class="box-inner">
			<table cellpadding="5">
				<tbody>
				<tr>
				<td>
					<s:form action="changePassword_execute" method="post">
							<s:token/>
					    <s:password key="signon.password" />
					    <s:password key="signon.passwordNew" />
					    <s:password key="signon.passwordConfirm" />
					    <s:actionerror /><br/>
					    <s:actionmessage/>
					    <s:submit value="비밀번호 변경"> <s:url var="url" action="signon_input"/> <s:a href="%{url}"><s:text name="signon.input"/></s:a> </s:submit>
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