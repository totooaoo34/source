<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
    <a href="fwxxAction!findAllFwxx" style="font-size: 20">主页</a>
	<s:form action="/userAction!userLogin">
		<s:textfield name="user.ulogin" label="用户名"></s:textfield>
		<s:password name="user.upass" label="密码"></s:password>
		<s:submit value="登录"></s:submit>
		<s:a href="register.jsp" >注册新用户</s:a>
	</s:form>
  </body>
</html>
