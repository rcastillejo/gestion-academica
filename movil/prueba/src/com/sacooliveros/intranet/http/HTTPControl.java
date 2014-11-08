package com.sacooliveros.intranet.http;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import org.apache.http.client.ClientProtocolException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

public class HTTPControl{
	
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

	public static Bitmap downloadImage(String url) {
		
		Bitmap image;
		try{
			URL aurl = new URL(url);
			URLConnection conn = aurl.openConnection();
			conn.connect();
			InputStream is = conn.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			//decodificamos la imagen
			image = BitmapFactory.decodeStream(bis);
			
			bis.close();
			is.close();	
		}catch(Exception e){
			return null;
		}
		
		return image;
	}
	
	public static String downloadVideo(String url, String pathSave, String fileName) {
		
		 try {
	            String RootDir = pathSave;
	            File RootFile = new File(RootDir);
	            RootFile.mkdir();
	            // File root = Environment.getExternalStorageDirectory();
	            URL u = new URL(url);
	            HttpURLConnection c = (HttpURLConnection) u.openConnection();
	            c.setRequestMethod("GET");
	            c.setDoOutput(true);
	            c.connect();
	            FileOutputStream f = new FileOutputStream(new File(RootFile, fileName));
	            InputStream in = c.getInputStream();
	            byte[] buffer = new byte[1024];
	            int len1 = 0;

	            while ((len1 = in.read(buffer)) > 0) {                          
	                f.write(buffer, 0, len1);               
	            }       
	            f.close();
	        } catch (Exception e) {
	            Log.d("Error....", e.toString());
	            return null;
	        }
		 return pathSave + File.separator + fileName;
	}
}
