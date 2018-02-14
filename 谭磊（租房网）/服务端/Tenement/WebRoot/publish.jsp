<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
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
	<h1>发布租房信息 ☞ <a href="fwxxAction!findAllFwxx">返回主页</a></h1>
	<h1></h1>
	
	<s:form action="fwxxAction!addMessage" enctype="multipart/form-data">
	<input style="display: none;" name="fwxx.fwid" value="${fwxx.fwid}">
	<input name="uid" value="${user.uid}"/>
		<table>
			<tr>
				<td class="title">标题：</td>
				<td><input name="fwxx.title"/></td>
			</tr>
			<tr>
				<td class="title">区县：</td>
				<td>
					<SELECT name="qx.qxid" onchange="ajaxJd()" id="qxid">
						<option value="0">-请选择-</option>
						<c:forEach items="${qxs}" var="v">
							<option value="${v.qxid }">${v.qx }</option>
						</c:forEach>
					</SELECT>
					<SCRIPT type="text/javascript">
						//区县与街道的二级联动ajax
						function ajaxJd(){
							var qxid = document.getElementById("qxid").value;
							// 创建XMLHttpRequst请求对象
							var xhr = new XMLHttpRequest();
							var url = "fwxxAction!findByJd?qxid="+qxid;
							xhr.open("get",url,true);
							xhr.onreadystatechange = function(){
								if(xhr.readyState == 4 && xhr.status == 200){
									var obj = xhr.responseText;
									var op = document.getElementById("jdid");
									op.options.length=0;
									var ajaxJd = obj.split(",");
									var ajaxJdId = obj.split("|");
									for(var i=0;i<ajaxJd.length-1;i++){
										var opt = new Option();
										opt.value=ajaxJdId[i];
										opt.innerHTML=ajaxJd[i];
										op.appendChild(opt);
									}
								}
							}
							xhr.send();
						}
					</SCRIPT>
				</td>
			</tr>
			<tr>
				<td class="title">街道：</td>
				<td>
					<SELECT name="fwxx.jdid" id="jdid" onchange="jd()">
						<option value="0">-请选择-</option>
					</SELECT>
					<SCRIPT type="text/javascript">
						function jd(){
							var a=document.getElementById("jdid").value;
						}
					</SCRIPT>
				</td>
			</tr>
			<tr>
				<td class="title">租金：</td>
				<td><input name="fwxx.zj" value="${fwxx.zj }"/> 元/月</td>
			</tr>
			<tr>
				<td class="title">户型：</td>
				<td>
					<SELECT name="fwxx.shi">
						<c:forEach begin="0" end="9" var="shi">
							<option value="${shi}">${shi}</option>
						</c:forEach>
					</SELECT>室
					<SELECT name="fwxx.ting">
						<c:forEach begin="0" end="9" var="ting">
							<option value="${ting}">${ting}</option>
						</c:forEach>
					</SELECT>厅
					<script type="text/javascript">
						var shiId = document.getElementsByName("fwxx.shi")[0];
						var tingId = document.getElementsByName("fwxx.ting")[0];
						for(var i = 0; i < shiId.length; i++){
							if(${fwxx.shi}==shiId[i].value){
								shiId[i].selected="selected";
							}
							if(${fwxx.ting}==tingId[i].value){
								tingId[i].selected="selected";
							}
						}
					</script>
				</td>
			</tr>
			<tr>
				<td class="title">房屋类型：</td>
				<td>
					<select name="fwxx.lxid">
						<option value="0">-请选择-</option>
						<c:forEach items="${fwlxs}" var="v">
							<option value="${v.lxid}">${v.fwlx}</option>
						</c:forEach>						
					</select>
				</td>
			</tr>
			<tr>
				<td class="title">联系电话：</td>
				<td><input name="fwxx.telephone" value="${fwxx.telephone }"/></td>
			</tr>
			<tr>
				<td class="title">联系人：</td>
				<td><input name="fwxx.lxr" value="${fwxx.lxr }"/></td>
			</tr>
			<tr>
				<td class="title">照片名字：</td>
				<td><input type="text" name="imgName">.PNG</td>
			</tr>
			<tr>
				<td class="title">路径：</td>
				<td><input type="file" name="pic" /></td>
			</tr>
			<tr>
				<td class="title">房屋信息：</td>
				<td><textarea name="fwxx.fwxx" rows="5" cols="25" title="房屋信息">${fwxx.fwxx }</textarea></td>
			</tr>
			<tr>
				<td colspan="2" >
					<s:submit value="确认发布" align="center"></s:submit>
				</td>
			</tr>
		</table>
		
	</s:form>
	
  </body>
</html>
