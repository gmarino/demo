package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("local")
class DemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void apiPing() throws Exception{
		this.mockMvc.perform(get("/api/pingctrl/pingTst")).andDo(print()).andExpect(content().string("pingTst"));
	}

	@Test
	public void countryTes() throws Exception {
		
		String insertData="{\"countryName\":\"Italia\",\"population\":\"4000\"}";
			
		this.mockMvc.perform(post("/api/countryctrl/insert").content(insertData)).andDo(print());
		
		this.mockMvc.perform(get("/api/countryctrl/findById/Italia")).
		andDo(print());
		//.andExpect(jsonPath("$.countryName", is("Italia")));
	}
	
}
