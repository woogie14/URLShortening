package com.bw.shortening.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bw.shortening.model.ResultInfo;
import com.bw.shortening.model.UrlInfo;
import com.bw.shortening.service.ShorteningService;

@RestController
public class ConvertController {
	private ShorteningService shorteningService;

	@Autowired
	public ConvertController(ShorteningService shorteningService) {
		this.shorteningService = shorteningService;
	}

	@GetMapping(value = "/shortening", produces = { "application/json" })
	@ResponseBody
	public ResultInfo convert(@RequestParam(value="url", defaultValue="") String url) {
		//url ShortenigService 호출
		return shorteningService.getShorteningUrl(url.trim());
	}

}
