package com.jiabangou.baiduwaimaisdk.client;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.IOException;

public class LocalSSLHttpClient {

	protected CloseableHttpClient SSLHttpClient;

	public LocalSSLHttpClient(String partner,String cert_dir){
		SSLHttpClient = HttpClientFactory
				.createCloseableHttpClient(partner,cert_dir);
	}

	public HttpResponse execute(HttpUriRequest request) {
		try {
			return SSLHttpClient.execute(request);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public <T> T execute(HttpUriRequest request,
			ResponseHandler<T> responseHandler) {
		try {
			return SSLHttpClient.execute(request, responseHandler);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
