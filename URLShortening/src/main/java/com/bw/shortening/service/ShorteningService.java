package com.bw.shortening.service;

import com.bw.shortening.model.ResultInfo;
import com.bw.shortening.model.UrlInfo;

public interface ShorteningService {
	ResultInfo getShorteningUrl(String url);
}
