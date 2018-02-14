<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 
  </head>
  	<style type="text/css">
			 table{
				border-top:1px solid #333;
				border-left:1px solid #333;
				width:500px;
			}
			.title{
				background-color:#ff9900;
			}
			td{
				border-right:1px solid #333;
				border-bottom:1px solid #333; 
			}
			img{
				width:200px;height:200px;
			}
	</style>
  <body>
    <font color='red'>当前用户：${user.uname}</font> <a href="userAction!userClose" >注销</a><br/>
    <img width="100" height="100" src="<%=basePath %>/user_img/${user.uimg}">
    <a href="fwxxAction!findAllFwxx" style="font-size: 20">主页</a>
    <a href="fwxxAction!publishSel" style="font-size: 20">发布</a>
    <a href="#" style="font-size: 20">管理我的租房信息</a>
	<table>
		<tr class="title" align="center">
			<td>标题</td>
			<td>月租金</td>
			<td>发布日期</td>
			<td colspan="2">操作</td>
		</tr>
		<c:forEach items="${fwxxs}" var="v">
		<tr>
			<td>${v.title }</td>
			<td>${v.zj }</td>
			<td>${v.date }</td>
			<td><input type="button"value="删除"onclick="javascript:del('${v.fwid }')"/></td>
			<td><input type="button"value="修改"onclick="javascript:up('${v.fwid }')"/></td>
		</tr>
		</c:forEach>
	</table>
		<script type="text/javascript">
			function del(id){
				if(confirm("确定要删除吗？")){
					window.location.href = "fwxxAction!delByIdFwxx?fwid="+id;
				}
			}
			function up(id){
				window.location.href = "fwxxAction!findByIdFwxx?fwid="+id;
			}
		</script>
  </body>
</html>
