package com.bw.shortening;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bw.shortening.model.ResultInfo;
import com.bw.shortening.service.ShorteningService;
import com.bw.shortening.service.UrlEncodeService;

@SpringBootTest
class UrlShorteningApplicationTests {
	
	@Autowired
	ShorteningService shorteningService;
	
	@Autowired
	UrlEncodeService urlencodeService;
	
	ResultInfo resultInfo;
	

	// shortening 테스트
	@Test
	void convertUrlTest() {
		String orginUrl = "https://store.musinsa.com/app/";
		
		resultInfo = shorteningService.getShorteningUrl(orginUrl);
		assertThat(!resultInfo.getUrlInfo().getShortUrl().isEmpty());
		
		resultInfo = shorteningService.getShorteningUrl(resultInfo.getUrlInfo().getShortUrl());
		assertThat(resultInfo.getUrlInfo().getOriginUrl().equals(resultInfo.getUrlInfo().getOriginUrl()));
	}
}
