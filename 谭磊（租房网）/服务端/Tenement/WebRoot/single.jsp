<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
   		<h1>单个详情查看</h1>
   		<table>
   			<tr>
   				<td class="title">电话/手机：</td>
   				<td>${fwxx.telephone}</td>
   			</tr>
   			<tr>
   				<td class="title">联系人：</td>
   				<td>${fwxx.lxr}</td>
   			</tr>
   			<tr>
   				<td class="title">房屋类型：</td>
   				<td>${fwlx.fwlx}</td>
   			</tr>
   			<tr>
   				<td class="title">户型：</td>
   				<td>${fwxx.shi }室${fwxx.ting }厅</td>
   			</tr>
   			<tr>
   				<td class="title">价格：</td>
   				<td>${fwxx.zj}</td>
   			</tr>
   			<tr>
   				<td class="title">地段：</td>
   				<td>${qx.qx }   ${jd.jd}</td>
   			</tr>
   			<tr>
   				<td class="title">发布时间：</td>
   				<td>${fwxx.date}</td>
   			</tr>
   			<tr>
   				<td class="title">详情说明：</td>
   				<td>${fwxx.fwxx}</td>
   			</tr>
   			<tr>
   				<td align="center" colspan="2"><input type="button" value="后退" onclick="back()"></td>
   			</tr>
   		</table>
   		<script   language="javascript">   
			function back(){
			window.history.back();
		}
		</script>
  </body>
</html>
