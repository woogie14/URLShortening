package com.bw.shortening;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class RestControllerTest {
	
	  @Autowired
	    private MockMvc mockMvc;

	    @Test
	    public void rest_test() throws Exception {

	        String url = "https://store.musinsa.com/app/";

	        ResultActions actions = mockMvc.perform(get("/convert")
	                .param("url", url))
	                .andDo(print());

	        actions.andExpect(status().isOk())
	                .andExpect(jsonPath("$.urlInfo").isNotEmpty())
	                .andExpect(jsonPath("$.originUrl").isNotEmpty())
	                .andExpect(jsonPath("$.success").isNotEmpty())
	        ;
	    }

}
