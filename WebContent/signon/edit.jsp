<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="account.update"/></title>
</head>
<body>
<div id="content">
<div class="centered">
  <h2><s:text name="account.update"/></h2>

	<s:form action="signon_execute" method="post">
	<s:token/>
	<s:textfield key="account.userid" readonly="true"/> 
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

	<s:submit value="저 장"><s:url id="url" action="changePassword_input"/> 
	<s:a href="%{url}"><s:text name="change.password"/></s:a> </s:submit>
	</s:form>
</div><!-- class:centered -->
</div><!-- id=content -->
</body>
</html>