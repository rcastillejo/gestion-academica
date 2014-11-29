package com.sacooliveros.intranet.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
 
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.util.Log;

public class HttpGeter {
	private String url;
	private String request;
	private String response;
	private String contentType = "text/plain";
	private int timeOut = 60000;
	private int status;
	private String tag = "HttpPoster";
	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public int getStatus() {
		return status;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public int getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}

	public String getResponse() {
		return response;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	//private String HEADER_BEGIN_TAG = "<string xmlns=\"http://schemas.microsoft.com/2003/10/Serialization/\">";
	//private String HEADER_END_TAG = "</string>";

	public void invoke() throws ClientProtocolException, IOException, Exception {
		HttpParams httpParams = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParams, this.timeOut);
		HttpConnectionParams.setSoTimeout(httpParams, this.timeOut);
		
		DefaultHttpClient httpClient = new DefaultHttpClient(httpParams);
		//httpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
		
		
		HttpGet httpGet = new HttpGet(this.url);

		Log.d(tag, "URL = " + this.url);
		Log.d(tag, "Request = " + request);
		StringBuffer sf = new StringBuffer();
		this.response = "";

		sf.append(request);
		
		//StringEntity stringRequest = new StringEntity(request);
		//stringRequest.setContentType(this.contentType);
		//httpGet.setEntity(stringRequest);

		HttpResponse response = httpClient.execute(httpGet);
		this.status = response.getStatusLine().getStatusCode();
		Log.d("STATUS", String.valueOf(this.status));

		if (HttpStatus.SC_OK == this.status) {
			//String rp = stream2String(response.getEntity().getContent());
			String rp = EntityUtils.toString(response.getEntity(), HTTP.ISO_8859_1);			
			Log.d("Encrypted response", rp);
			this.response = rp.toString();
		}
	}

	private String stream2String(InputStream input) throws IOException {
		BufferedReader buffer = new BufferedReader(
				new InputStreamReader(input), 8 * 1024);
		StringBuilder sb = new StringBuilder();
		String line;

		while ((line = buffer.readLine()) != null) {
			sb.append(line);
		}
		return sb.toString();
	}
}