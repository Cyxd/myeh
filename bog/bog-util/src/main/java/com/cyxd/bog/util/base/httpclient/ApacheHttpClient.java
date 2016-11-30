package com.cyxd.bog.util.base.httpclient;

import java.io.IOException;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * <li>ClassFullName: com.cyxd.bog.util.base.httpclient.ApacheHttpClient
 * <li>ClassName: ApacheHttpClient
 * <li>CreateDateTime: 2016年10月17日 15:37:03
 *
 * <p>
 * Description:Apache commons-httpclient
 *
 * @author Slil
 * @version 1.0.0
 * @since 1.0.0
 *
 * @see org.apache.commons.httpclient.HttpClient
 * @see org.apache.commons.httpclient.methods.GetMethod
 * @see org.apache.commons.httpclient.methods.PostMethod
 *
 */
public class ApacheHttpClient {

    private final Logger log = LoggerFactory.getLogger(getClass());

    public String doGet(String url) {
	HttpClient httpClient = new HttpClient();
	GetMethod method = new GetMethod(url);
	String str = "";
	try {
	    str = responseCodeHander(method, httpClient.executeMethod(method));
	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    method.releaseConnection();
	}
	return str;
    }

    public String doPost(String uri, NameValuePair[] formData) {
	HttpClient httpClient = new HttpClient();
	PostMethod method = new PostMethod(uri);
	method.setRequestBody(formData);
	String str = "";
	try {
	    str = responseCodeHander(method, httpClient.executeMethod(method));
	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    method.releaseConnection();
	}
	return str;
    }

    private String responseCodeHander(HttpMethod method, int responseCode)
	    throws IOException {
	String str = "";
	// 301 302
	if (requestIsMovedOrMoving(responseCode)) {
	    movingRequestHandler(method);
	} else {
	    log.debug(method.getStatusLine().toString());
	    str = method.getResponseBodyAsString();
	    log.debug(str);
	}
	return str;
    }

    private boolean requestIsMovedOrMoving(int responseCode) {
	return responseCode == HttpStatus.SC_MOVED_PERMANENTLY
		|| responseCode == HttpStatus.SC_MOVED_TEMPORARILY;
    }

    private void movingRequestHandler(HttpMethod method) {
	Header locationHeader = method.getResponseHeader("location");
	String location = null;
	String estr;
	if (locationHeader != null) {
	    location = locationHeader.getValue();
	    estr = "The page was redirected to:" + location;
	} else {
	    estr = "Location field value is null.";
	}
	throw new IllegalStateException(estr);
    }

    public static void main(String[] args) {
	ApacheHttpClient client = new ApacheHttpClient();
	// System.out.println(client.doGet("http://192.168.10.49:9096/adminWeb/areas/ag/?parentId=2A51B7E2C63D012CE050AA0A1B2B28E3"));
	NameValuePair[] formData = { new NameValuePair("parentId",
		"2A51B7E2C63D012CE050AA0A1B2B28E3") };
	System.out
		.println(client
			.doPost("http://192.168.10.49:9096/adminWeb/areas/ag/?parentId=2A51B7E2C63D012CE050AA0A1B2B28E3",
				formData));

    }

}
