<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	</head>
	<body>
		<h1>
			注册
		</h1>
		<script   language="javascript">   
			function back(){
			window.history.back();
		}
		</script>
		<s:form action="/userAction!userAdd" enctype="multipart/form-data">
			<s:textfield name="user.ulogin" label="登录账号："></s:textfield>
			<s:password name="user.upass" label="密码："></s:password>
			<s:textfield name="user.uname" label="姓名："></s:textfield>
			<s:textfield name="imgName" label="头像名："></s:textfield>
			<s:file name="pic" label="用户头像："></s:file>
			<s:submit value="submit"></s:submit>
			<input type="reset" value="重置">&nbsp;
			<input type="button" value="后退" onclick="back()">
		</s:form>
	</body>
</html>
