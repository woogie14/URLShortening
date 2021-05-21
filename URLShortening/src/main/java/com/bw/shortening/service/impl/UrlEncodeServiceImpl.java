package com.bw.shortening.service.impl;

import org.springframework.stereotype.Service;

import com.bw.shortening.service.UrlEncodeService;

@Service
public class UrlEncodeServiceImpl implements UrlEncodeService{
	 private final String DEFULT_URL = "http://localhost/";
	    private final int BASE62 = 62;
	    private final String BASE62_CHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	    /*
	     * encoding BASE62를 사용한이유는 BASE64가 
	     * '/', '='을 포함하기 때문에 
	     * 해당 기호를 url호출로 사용하면 제대로 처리되지 않을 수 있기때문에
	     * BASE62를 사용함
	    */
	    @Override
	    public String urlEncoding(int param) {
	    	if(param < 0) {
	    		param *= -1;
	    	}
	        StringBuffer sb = new StringBuffer();
	        while(param > 0) {
	            sb.append(BASE62_CHAR.charAt((int) (param % BASE62)));
	            param /= BASE62;
	        }
	        return DEFULT_URL + sb.toString();
	    }
}
