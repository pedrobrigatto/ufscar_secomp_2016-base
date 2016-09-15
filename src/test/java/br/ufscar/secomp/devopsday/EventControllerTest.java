package br.ufscar.secomp.devopsday;

import java.time.LocalDateTime;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.ufscar.secomp.devopsday.model.Event;

@RunWith (SpringRunner.class)
@SpringBootTest (webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
public class EventControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testSavingEvent() throws Exception {
		Event event = new Event();
		event.setName("SeComp-UFSCar-2016");
		event.setDescription("SeComp-UFSCar-2016");
		event.setFirstDay(LocalDateTime.now());
		event.setLastDay(LocalDateTime.now());
		
		mockMvc.perform(MockMvcRequestBuilders.post("/pedrobrigatto/event").
				contentType(MediaType.APPLICATION_JSON).
				content(convertEventObjectToBytes(event))).
		andExpect(MockMvcResultMatchers.status().isCreated());
	}
	
	@Test
	public void testLoadingAllEvents() throws Exception {
		Event event = new Event();
		event.setName("SeComp-UFSCar-2016-2");
		event.setDescription("SeComp-UFSCar-2016");
		event.setFirstDay(LocalDateTime.now());
		event.setLastDay(LocalDateTime.now());
		
		mockMvc.perform(MockMvcRequestBuilders.post("/pedrobrigatto/event").
				contentType(MediaType.APPLICATION_JSON).
				content(convertEventObjectToBytes(event)));
		
		mockMvc.perform(MockMvcRequestBuilders.get("/pedrobrigatto/event/{id}", 2L).
				accept(MediaType.APPLICATION_JSON)).
		andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("SeComp-UFSCar-2016-2")));
	}
	
	private static byte[] convertEventObjectToBytes(Event event) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL);
		return mapper.writeValueAsBytes(event);
	}
}
