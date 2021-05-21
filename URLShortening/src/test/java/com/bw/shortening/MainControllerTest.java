package com.bw.shortening;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.bw.shortening.controller.MainController;
import com.bw.shortening.service.ShorteningService;
import com.bw.shortening.service.UrlEncodeService;

@WebMvcTest(MainController.class)
class MainControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	// mainController 호출 테스트
	@Test
	void mainTest() {
		try {
			mvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(view().name("home"))
            .andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
