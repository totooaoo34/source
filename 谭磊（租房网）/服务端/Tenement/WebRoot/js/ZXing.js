function init() {
	jsid = document.getElementById("sessionid").innerHTML
	sendHttpRequest();
}
//�ύ����
function sendHttpRequest() {
	var url = "http://192.168.100.4:8080/Tenement/userAction/inntUserLogin?sessionid=" + jsid + "&xx=" + Math.random();
	send_request("get", url, null, "text", onHttpResponse);
}

var http_request;
function send_request(method, url, content, responseType, callback) {
	//��ʼ����ָ������������������ĺ���

	//��ʼ��ʼ��XMLHttpRequest����
	if (window.XMLHttpRequest) { //Mozilla �����
		http_request = new XMLHttpRequest();
		if (http_request.overrideMimeType) {//����MiME���
			http_request.overrideMimeType("text/xml");
		}
	} else if (window.ActiveXObject) { // IE�����
		try {
			http_request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				http_request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
			}
		}
	}
	if (!http_request) { // �쳣����������ʵ��ʧ��
        window.alert("���ܴ���XMLHttpRequest����ʵ��.");
        return false;
    }
    if(responseType.toLowerCase()=="text") {
        http_request.onreadystatechange = callback;
    }
    else if(responseType.toLowerCase()=="xml") {
        http_request.onreadystatechange = callback;
    }
    else {
        window.alert("��Ӧ����������");
        return false;
    }
    // ȷ����������ķ�ʽ��URL�Լ��Ƿ��첽ִ���¶δ���
    if(method.toLowerCase()=="get") {
        http_request.open(method, url, true);
    }
    else if(method.toLowerCase()=="post") {
        http_request.open(method, url, true);
        http_request.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    }
    else {
        window.alert("http��������������");
        return false;
    }
    
    http_request.send(content);
	}
    
    function onHttpResponse()
    {
    	
    if (http_request.readyState == 4) { // �ж϶���״̬
        if (http_request.status == 200) { // ��Ϣ�Ѿ��ɹ����أ���ʼ������Ϣ
            var response = http_request.responseText;
           
           //alert(response);
           if(response == "")
           {
           		
           		setTimeout(sendHttpRequest,5000); 
           }else{
           	document.getElementById("sessionid").innerHTML = response+"�Ѿ���¼��"
           }
        } else { //ҳ�治����
            alert("���������ҳ�����쳣��");
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
            document.getElementById("feedback_info").innerHTML = "ϵͳ���ڴ��������������Ժ�";
            send_request("GET","checkUsername.jsp?username="+f.username.value,null,"text",showFeedbackInfo);
        }
        else {
            document.getElementById("feedback_info").innerHTML = "�������û����ơ�";
        }
    
	}
	function showFeedbackInfo() {
    if (http_request.readyState == 4) { // �ж϶���״̬
        if (http_request.status == 200) { // ��Ϣ�Ѿ��ɹ����أ���ʼ������Ϣ
            document.getElementById("feedback_info").innerHTML = http_request.responseText;
        } else { //ҳ�治����
            alert("���������ҳ�����쳣��");
        }
    	}
	}