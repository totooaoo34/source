<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<%
	String sessionid = session.getId();
	pageContext.setAttribute("sessionid", sessionid);

	if (session.getAttribute("image") == null) {
		session.setAttribute("image", ZXingUtil.encodeImage(sessionid));
	}
	String exts = "/image";
	File f = new File(getServletContext().getRealPath("/") + exts);

	File outputFile = new File(f + "/" + sessionid + ".png");

	if (!f.exists()) {
		f.mkdir();
	}

	BufferedImage bimage = (BufferedImage) session
			.getAttribute("image");
	if (!ImageIO.write(bimage, "png", outputFile)) {
		throw new IOException("Could not write an image of format "
				+ "png" + " to ");
	}

	//将sessionid保存起来
	application.setAttribute(sessionid, "");

	String imagePath = request.getContextPath() + exts + "/"
			+ sessionid + ".png";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'index.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

		<script type='text/javascript'>
    //在onload中加载init方法      
    var jsid;
    function init()
    {
    	
    	 
    	 jsid=document.getElementById("sessionid").innerHTML
    	 
    	 
    	sendHttpRequest();
    	//setTimeout(sendHttpRequest,2000);  
    }
    
    function sendHttpRequest()
    {
    	
    	var url = "http://192.168.1.138:8080/zingx/servlet/comfirmServlet?sessionid="+jsid+"&xx="+Math.random();
    	
    	 send_request(
    	 "get",
    	  url,
    	 null,
    	 "text",
    	 onHttpResponse);
    }
    var http_request;
    function send_request(method,url,content,responseType,callback) {
    //初始化、指定处理函数、发送请求的函数
   
    //开始初始化XMLHttpRequest对象
    if(window.XMLHttpRequest) { //Mozilla 浏览器
        http_request = new XMLHttpRequest();
        if (http_request.overrideMimeType) {//设置MiME类别
            http_request.overrideMimeType("text/xml");
        }
    }
    else if (window.ActiveXObject) { // IE浏览器
        try {
            http_request = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            try {
                http_request = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e) {}
        }
    }
   
    if (!http_request) { // 异常，创建对象实例失败
        window.alert("不能创建XMLHttpRequest对象实例.");
        return false;
    }
    if(responseType.toLowerCase()=="text") {
        //http_request.onreadystatechange = processTextResponse;
        http_request.onreadystatechange = callback;
    }
    else if(responseType.toLowerCase()=="xml") {
        //http_request.onreadystatechange = processXMLResponse;
        http_request.onreadystatechange = callback;
    }
    else {
        window.alert("响应类别参数错误。");
        return false;
    }
    // 确定发送请求的方式和URL以及是否异步执行下段代码
    if(method.toLowerCase()=="get") {
        http_request.open(method, url, true);
    }
    else if(method.toLowerCase()=="post") {
        http_request.open(method, url, true);
        http_request.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    }
    else {
        window.alert("http请求类别参数错误。");
        return false;
    }
    
    http_request.send(content);
	}
    
    function onHttpResponse()
    {
    	
    if (http_request.readyState == 4) { // 判断对象状态
        if (http_request.status == 200) { // 信息已经成功返回，开始处理信息
            var response = http_request.responseText;
           
           //alert(response);
           if(response == "")
           {
           		
           		setTimeout(sendHttpRequest,5000); 
           }else{
           	document.getElementById("sessionid").innerHTML
           	= response+"已经登录了"
           }
            
            
            //alert("Text文档响应。");
        } else { //页面不正常
            alert("您所请求的页面有异常。");
        }
    }

    }
    
    function myAlert(strTitle) {
        var message=document.getElementById("myDiv").innerHTML;
        var win1 = new Zapatec.AlertWindow(message, {title:strTitle, modal:true, width : 580,height:330});
    }
    function doCheck() {
    var f = document.forms[0];
        if(f.username.value!="") {
            document.getElementById("feedback_info").innerHTML = "系统正在处理您的请求，请稍后。";
            send_request("GET","checkUsername.jsp?username="+f.username.value,null,"text",showFeedbackInfo);
        }
        else {
            document.getElementById("feedback_info").innerHTML = "请输入用户名称。";
        }
    
	}
	function showFeedbackInfo() {
    if (http_request.readyState == 4) { // 判断对象状态
        if (http_request.status == 200) { // 信息已经成功返回，开始处理信息
            document.getElementById("feedback_info").innerHTML = http_request.responseText;
        } else { //页面不正常
            alert("您所请求的页面有异常。");
        }
    	}
	}
        
</script>

	</head>

	<body onload="init();">
		<div id="sessionid"><%=sessionid%></div>
		<img src=<%=imagePath%> />
	</body>
	
</html>
