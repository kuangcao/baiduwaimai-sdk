package com.jiabangou.baiduwaimaisdk.client;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/**
 * httpclient 4.3.x
 * @author Yi
 *
 */
public class HttpClientFactory {

	//读取证书
	public static KeyStore readCertKeyFile(String partner,String cert_dir) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException
	{
		//指定读取证书格式为PKCS12
    	KeyStore keyStore  = KeyStore.getInstance("PKCS12");
    	//读取本机存放的PKCS12证书文件
    	FileInputStream instream = new FileInputStream(new File(cert_dir));
        try 
        {
        	//指定PKCS12的密码(商户ID)
            keyStore.load(instream, partner.toCharArray());
        } finally {
            instream.close();
        }
        
        return keyStore;
	}

	/**
	 *
	 * @param partner 微信支付商户号
	 * @param cert_dir 微信支付证书路径
     * @return
     */
	//创建SSL连接client
	public static CloseableHttpClient createCloseableHttpClient(String partner,String cert_dir){
		try {					
			
			KeyStore keyStore = readCertKeyFile(partner,cert_dir);
	        // Trust own CA and all self-signed certs
	        SSLContext sslcontext = SSLContexts.custom()
	                .loadKeyMaterial(keyStore, partner.toCharArray())
	                .build();
	        //指定TLS版本
	        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
	                sslcontext,
	                new String[] { "TLSv1" },
	                null,
	                SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
			
			return HttpClientBuilder.create().setSSLSocketFactory(sslsf).build();
	        
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
				return null;
	}
		
	//SSL连接下此方法不可行
//	public static CloseableHttpClient createCloseableHttpClient(int maxTotal,int maxPerRoute) {
//		try {		
//			
//			KeyStore keyStore = readCertKeyFile();
//	        // Trust own CA and all self-signed certs
//	        SSLContext sslcontext = SSLContexts.custom()
//	                .loadKeyMaterial(keyStore,  WePayConfig.PARTNER.toCharArray())
//	                .build();
//	        //指定TLS版本
//	        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
//	                sslcontext,
//	                new String[] { "TLSv1" },
//	                null,
//	                SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
//	        			
//			PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();
//			poolingHttpClientConnectionManager.setMaxTotal(maxTotal);
//			poolingHttpClientConnectionManager.setDefaultMaxPerRoute(maxPerRoute);
//			return HttpClientBuilder.create()
//									.setConnectionManager(poolingHttpClientConnectionManager)
//									.setSSLSocketFactory(sslsf)
//									.build();
//			
//			
//		} catch (KeyManagementException e) {
//			e.printStackTrace();
//		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
//		} catch (Exception e){
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	public static HttpClient createHttpClient() {
		try {
			SSLContext sslContext = SSLContexts.custom().useSSL().build();
			SSLConnectionSocketFactory sf = new SSLConnectionSocketFactory(sslContext,SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			return HttpClientBuilder.create().setSSLSocketFactory(sf).build();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static HttpClient createHttpClient(int maxTotal,int maxPerRoute) {
		try {
			SSLContext sslContext = SSLContexts.custom().useSSL().build();
			SSLConnectionSocketFactory sf = new SSLConnectionSocketFactory(sslContext,SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();
			poolingHttpClientConnectionManager.setMaxTotal(maxTotal);
			poolingHttpClientConnectionManager.setDefaultMaxPerRoute(maxPerRoute);
			return HttpClientBuilder.create()
									.setConnectionManager(poolingHttpClientConnectionManager)
									.setSSLSocketFactory(sf)
									.build();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}


}
