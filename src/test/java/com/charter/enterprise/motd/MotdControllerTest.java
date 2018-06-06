package com.charter.enterprise.motd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MotdControllerTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private MessageService msgServiceMock;

	@Test
	public void getMotd() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/")).andExpect(status().isOk())
				.andExpect(content().string(equalTo(msgServiceMock.getDailyMessage())));
	}

	@Test
	public void updateMotd() throws Exception {
		String updateMsg = "some new text";
		mvc.perform(MockMvcRequestBuilders.put("/update").contentType("text/html").content(updateMsg))
				.andExpect(status().is2xxSuccessful())
				.andExpect(content().string(equalTo(HttpStatus.ACCEPTED.toString())));

		mvc.perform(MockMvcRequestBuilders.get("/")).andExpect(status().isOk())
				.andExpect(content().string(equalTo(updateMsg)));

	}

	@Test
	public void updateErrorMotd() throws Exception {
		mvc.perform(MockMvcRequestBuilders.put("/update").contentType("text/html").content(""))
				.andExpect(status().is4xxClientError())
				.andExpect(content().string(equalTo("")));

	}

}
