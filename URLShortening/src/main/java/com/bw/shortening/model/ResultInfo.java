package com.bw.shortening.model;

import lombok.Data;

// 결과 객체
@Data
public class ResultInfo {
	//url 호출, 변환, 호출횟수 데이터
	private UrlInfo urlInfo;
	//변환된 url호출 여부
	private boolean isOriginUrl;
	//유효성 체크 성공 여부
	private boolean isSuccess;
}
