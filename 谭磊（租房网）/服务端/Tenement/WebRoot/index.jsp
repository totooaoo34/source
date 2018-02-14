<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%@ page import="java.io.FileInputStream"%>
<%@ page import="java.io.ByteArrayOutputStream"%>
<%@ page import="java.io.IOException"%>
<%@ page import="java.io.InputStream"%>
<%@ page import="java.awt.image.BufferedImage"%>
<%@ page import="javax.imageio.ImageIO"%>
<%@ page import="java.io.File"%>
<%@ page import="java.util.Hashtable"%>
<%@ page import="com.utils.ZXingUtil"%>
<%@ page import="javax.imageio.ImageIO"%>
<%@ page import="java.io.IOException"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="org.apache.struts2.ServletActionContext" %>

<%
String imagePath="";

HttpServletRequest hsr = ServletActionContext.getRequest();
HttpSession hs = request.getSession();
String sid=hs.getId();//获取到sessionId号
	if (session.getAttribute("image") == null) {
		session.setAttribute("image", ZXingUtil.encodeImage(sid));
	}
	String exts = "/image";
	File f = new File(getServletContext().getRealPath("/") + exts);

	File outputFile = new File(f + "/" + sid + ".png");

	if (!f.exists()) {
		f.mkdir();
	}

	BufferedImage bimage = (BufferedImage) session
			.getAttribute("image");
	if (!ImageIO.write(bimage, "png", outputFile)) {
		throw new IOException("Could not write an image of format "
				+ "png" + " to ");
	}

	imagePath = request.getContextPath() + exts + "/"
			+ sid + ".png";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script type="text/javascript" src="/js/ZXing.js"></script>
	</head>
	<style type="text/css">
table {
	border-top: 1px solid #333;
	border-left: 1px solid #333;
	width: 500px;
}

.title {
	background-color: #ff9900;
}

td {
	border-right: 1px solid #333;
	border-bottom: 1px solid #333;
}

img {
	width: 200px;
	height: 200px;
}
</style>


	<body onload="init();">
		<font color='red'>当前用户：${user.uname}</font>
		<a style="font-size: 20" href="userAction!userClose">注销</a>
		<a href="fwxxAction!findAllFwxx" style="font-size: 20">主页</a>
		<br>
		<img width="100" height="100"
			src="<%=basePath%>/user_img/${user.uimg}">
		<div id="sessionid" style="display: none"><%=sid%></div>
		<img src=<%=imagePath%> />
		<br />
		<button style="font-size: 20" onclick="publish('${user.uid}')">
			发布租房
		</button>
		&nbsp;
		<button style="font-size: 20" onclick="manage('${user.uid}')">
			管理租房信息
		</button>
		<hr>
		<table>
			<tr class="title" align="center">
				<td>
					标题
				</td>
				<td>
					月租金
				</td>
				<td>
					发布日期
				</td>
				<td>
					房屋图片
				</td>
				<td>
					操作
				</td>
			</tr>
			<c:forEach items="${fwxxs}" var="v">
				<tr>
					<td>
						${v.title }
					</td>
					<td>
						${v.zj }
					</td>
					<td>
						${v.date }
					</td>
					<td>
						<img width="20xp" height="20xp"
							src="<%=basePath%>/house_img/${v.img}" />
					</td>
					<td width="70xp" height="100xp">
						<button style="font-size: 20" onclick="byid('${v.fwid}');">
							查看详情
						</button>
					</td>
				</tr>
			</c:forEach>
		</table>
		<script type="text/javascript">
function publish(uid) {
	if (uid == '') {
		alert("未登录账户!");
		window.location.href = "fwxxAction!findAllFwxx";
	} else {
		window.location.href = "fwxxAction!publishSel";
	}
}
function manage(uid) {
	window.location.href = "fwxxAction!findByUidFwxx?uid=" + uid;
}
function byid(fwid) {
	window.location.href = "fwxxAction!findSingleFwxx?fwid=" + fwid;
}
</script>
	</body>
</html>
