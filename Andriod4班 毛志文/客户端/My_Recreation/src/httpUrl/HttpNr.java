package httpUrl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/// Http����
public class HttpNr {
	static public String sendHttpGet(String path)
	{
		//1,����װ��
		HttpClient httpClient= new DefaultHttpClient();
		//2,���͵�����
		HttpGet request = new HttpGet(path);
		
		//3,��������
		try {
			HttpResponse response = httpClient.execute(request);
			
			int code = response.getStatusLine().getStatusCode();
			StringBuffer sb;
			if (code==200) {
				//��÷��ص�����
				HttpEntity entity = response.getEntity();
				InputStream is = entity.getContent();
				BufferedReader br=new BufferedReader(new InputStreamReader(is));
				String line=null;
				sb = new StringBuffer();
				while( (line =br.readLine()) !=null )
				{
					sb.append(line);
				}
				br.close();
				is.close();
				return sb.toString();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
}
