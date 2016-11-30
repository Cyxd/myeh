package com.cyxd.bog.util.base.httpclient;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class FileUploadUtils extends Thread{

    public static void main(String[] args) {
	for (int i = 0; i < 10000; i++) {
	    System.out.println("times ===> " + (i+1));
	    new FileUploadUtils().start();
	}
	
	
	
    }
    
    @Override
    public void run() {
	upload("http://192.168.10.49:9096/adminWeb/file/upload/",
		"C:/Users/Administrator.PC/Downloads/图库/02.jpg");
//        super.run();
    }
    

    public static String upload(String url, String filePath) {
	// String fdfsPath = "";
	try (CloseableHttpClient httpclient = HttpClientBuilder.create()
		.build();) {
	    // HttpClient httpclient = new DefaultHttpClient();
	    // CloseableHttpClient closehttpclient =
	    // HttpClientBuilder.create().build();
	    // HttpPost httppost = new
	    // HttpPost("http://127.0.0.1:8082/fileUpload.action");//请求格式
	    HttpPost httppost = new HttpPost(url);
	    // File file = new File(filePath);
	    // String name = file.getName();
	    // InputStream in = new FileInputStream(file);
	    // MultipartEntity reqEntity = new MultipartEntity();
	    // InputStreamBody inputStreamBody = new InputStreamBody(in, name);
	    // StringBody fileNam = new StringBody(name);

	    // StringBody fileType = new StringBody("projectUSA");

	    // httpEntity.addPart("file", inputStreamBody);
	    // httpEntity.addPart("fileType", fileType);

	    httppost.setEntity(MultipartEntityBuilder.create()
		    .addBinaryBody("file", new File(filePath))
		    .addTextBody("fileType", "projectUSA").build());

	    JSONObject json = embedCreeper(httpclient, httppost);
	    System.err.println("lastJsonStr==========>>"+json);

	    // HttpResponse response = httpclient.execute(httppost);
	    // int statusCode = response.getStatusLine().getStatusCode();

	    // if (statusCode == HttpStatus.SC_OK) {
	    // // System.out.println("服务器正常响应.....");
	    // HttpEntity resEntity = response.getEntity();
	    // JSONObject json = new JSONObject(EntityUtils
	    // .toString(resEntity).toString());
	    //
	    // System.out.println(json.getString("returnResult"));
	    // //
	    // System.out.println(EntityUtils.toString(resEntity));//httpclient自带的工具类读取返回数据
	    // // System.out.println(resEntity.getContent());
	    //
	    // EntityUtils.consume(resEntity);
	    // } else if (statusCode == HttpStatus.SC_MOVED_TEMPORARILY) {
	    // String redirectUrl = response.getHeaders("Location")[0]
	    // .getValue();
	    // System.out.println("is redirect URL========>" + redirectUrl);
	    // System.out.println("embed the 302 Url continue..."
	    // + redirectUrl);
	    // }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return "";
    }

    private static JSONObject embedCreeper(
	    final CloseableHttpClient httpclient, HttpPost httppost)
	    throws IOException {
	HttpResponse response2 = httpclient.execute(httppost);
	int statusCode = response2.getStatusLine().getStatusCode();
	if (statusCode == HttpStatus.SC_OK) {
	    // System.out.println("服务器正常响应.....");
	    HttpEntity resEntity = response2.getEntity();
	    JSONObject json = new JSONObject(EntityUtils.toString(resEntity)
		    .toString());
	    // System.out.println(json.getString("returnResult"));
	    // System.out.println(EntityUtils.toString(resEntity));//httpclient自带的工具类读取返回数据
	    // System.out.println(resEntity.getContent());
	    EntityUtils.consume(resEntity);
	    return json;
	} else if (statusCode == HttpStatus.SC_MOVED_TEMPORARILY) {
	    String redirectUrl = response2.getHeaders("Location")[0].getValue();
	    System.err.println("is redirect URL========>" + redirectUrl);
	    System.err.println("embed the 302 Url continue..." + redirectUrl);
	    HttpPost httpPost2 = new HttpPost(redirectUrl);
	    NameValuePair user = new BasicNameValuePair("userName", "admin1");
	    NameValuePair pwd = new BasicNameValuePair("password", "123456");
	    // List<NameValuePair> parameters = new ArrayList<NameValuePair>();
	    httpPost2.setEntity(EntityBuilder.create().setParameters(user, pwd)
		    .build());
	    return embedCreeper(httpclient, httpPost2);
	}
	return new JSONObject("not 200 and 302");
    }

}
