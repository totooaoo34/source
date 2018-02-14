<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
	<s:form action="/userAction!userLogin" method="Post">
		<s:textfield name="user.uname" label="用户名"></s:textfield>
		<s:password name="user.upass" label="密码"></s:password>
		<s:submit value="登录"></s:submit>
	</s:form>
  </body>
</html>
