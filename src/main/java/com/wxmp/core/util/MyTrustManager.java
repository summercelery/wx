
package com.wxmp.core.util;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * 证书信任管理器（用于https请求） 
 *  
 * @author 
 * @date 
 */  
public class MyTrustManager implements X509TrustManager{
	 public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {  
	    }  
	  
	    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {  
	    }  
	  
	    public X509Certificate[] getAcceptedIssuers() {  
	        return null;  
	    }  
}
