package com.sacooliveros.intranet.http;
 
import java.io.IOException; 

import org.apache.http.client.ClientProtocolException;
 
public class HttpControl {
	
	public static String getJson(String url, String json) {
		HttpPoster poster = new HttpPoster();
		poster.setUrl(url);

		poster.setRequest(json);
		try {
			poster.invoke();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch(Exception d){				
			d.printStackTrace();				
		}
		return poster.getResponse();
	}

	public static String getJson(String url) {
		HttpGeter poster = new HttpGeter();
		poster.setUrl(url);

		//poster.setRequest(json);
		try {
			poster.invoke();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch(Exception d){				
			d.printStackTrace();				
		}
		return poster.getResponse();
	} 
}
