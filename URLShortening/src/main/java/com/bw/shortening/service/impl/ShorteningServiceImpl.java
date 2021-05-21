package com.bw.shortening.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.bw.shortening.constants.Constants;
import com.bw.shortening.model.ResultInfo;
import com.bw.shortening.model.UrlInfo;
import com.bw.shortening.service.ShorteningService;
import com.bw.shortening.service.UrlEncodeService;

@Service
public class ShorteningServiceImpl implements ShorteningService {
	// url encode Service
	private UrlEncodeService urlEncodeService;
	// url 유효성 검사
	private UrlValidator urlValidator;

	private Random rd;

	@Autowired
	public ShorteningServiceImpl(UrlEncodeService urlEncodeService) {
		if (Constants.urlInfoList == null) {
			Constants.urlInfoList = new ArrayList<UrlInfo>();
		}
		urlValidator = new UrlValidator();
		rd = new Random();
		this.urlEncodeService = urlEncodeService;

	}

	// shortenging
	@Override
	public ResultInfo getShorteningUrl(String url) {
		ResultInfo resultInfo = new ResultInfo();
		UrlInfo urlInfo = new UrlInfo();
		boolean isSuccess = false;
		int encodeKey = 0;
		if (!url.isEmpty()) {
			for (UrlInfo info : Constants.urlInfoList) {
				if (info.getShortUrl().equals(url)) {
					resultInfo.setUrlInfo(info);
					resultInfo.setOriginUrl(false);
					isSuccess = true;
					resultInfo.setSuccess(isSuccess);
					break;
				} else if (info.getOriginUrl().equals(url)) {
					info.setCallCnt(info.getCallCnt() + 1);
					resultInfo.setUrlInfo(info);
					resultInfo.setOriginUrl(true);
					isSuccess = true;
					resultInfo.setSuccess(isSuccess);
					break;
				}
			}
			// count추가
			if (!isSuccess) {
				if (urlValidator.isValid(url)) {
					urlInfo.setOriginUrl(url);
					urlInfo.setCallCnt(1);
					while (encodeKey == 0) {
						encodeKey = validateKey(rd.nextInt());
					}
					urlInfo.setKey(encodeKey);
					urlInfo.setShortUrl(urlEncodeService.urlEncoding(encodeKey));
					Constants.urlInfoList.add(urlInfo);
					resultInfo.setUrlInfo(urlInfo);
					resultInfo.setOriginUrl(true);
					resultInfo.setSuccess(true);
				} else {
					resultInfo.setSuccess(false);
				}
			}
		} else {
			resultInfo.setSuccess(false);
		}
		return resultInfo;
	}

	public int validateKey(int key) {
		if (Constants.urlInfoList.stream().filter(f -> f.getKey() == key).count() == 0) {
			return key;
		}
		return 0;
	}

}
