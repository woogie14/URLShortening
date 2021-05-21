package com.bw.shortening.model;

import lombok.Data;

@Data
public class UrlInfo {
	//변환 요청된 url
	private String originUrl;
	//변환된 url
	private String shortUrl;
	//변환 key
	private int key;
	//요청 횟수
	private int callCnt;
	
}
