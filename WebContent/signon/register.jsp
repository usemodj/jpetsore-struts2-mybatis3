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
		<div class="round4"></div>
		<div class="round2"></div>
		<div class="round1"></div>
		<div class="centered">
			<table class="pmeta" cellpadding="5">
				<tbody>
				<tr>
				<td>

				<h2><s:text name="register"/></h2>
				
				<s:form action="register_execute" method="post">
					<s:token/>
					<s:textfield key="signon.username" /> 
					<s:password key="signon.password" />
					<s:password key="signon.passwordConfirm" />
					<s:textfield key="account.firstname" />
					<s:textfield key="account.email" /> 
					<s:textfield key="account.phone" />
					<s:textfield key="account.cellphone" />
					<s:textfield key="account.addr1" size="35"/>
					<s:textfield key="account.zip" /> 
					<s:textfield key="account.city" /> 
					<%-- 
					<s:select key="addr2" list="sports" />
					<s:radio key="personBean.gender" list="genders" />
					<s:select key="personBean.residency" list="states" listKey="stateAbbr" listValue="stateName" />
					<s:checkbox key="personBean.over21" />
					<s:checkboxlist key="personBean.carModels" list="carModelsAvailable" />
					--%>
					<s:actionmessage /><br/>
					<s:actionerror /> 
				
					<s:submit value="가입하기" >&nbsp;&nbsp;<s:url id="url" action="login_input"/><s:a href="%{url}"><s:text name="login.submit"/></s:a> &nbsp;&nbsp;</s:submit>
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