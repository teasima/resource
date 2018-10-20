package guru.springframework.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import guru.springframework.SpringBootWebApplication;
import guru.springframework.controllers.SalesManController;
import guru.springframework.domain.SalesMan;
import guru.springframework.util.JsonUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { SpringBootWebApplication.class, MockServletContext.class })
public class SalesManTest {
	@Autowired
	private SalesManController salesManController;
	private MockMvc mockMvc;
	@Mock
	MockHttpServletRequest request;
	@Mock
	MockHttpSession session;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(salesManController).build();
	}

	// @Test
	@Rollback(false)
	public void testInsert() throws Exception {
		SalesMan toInsert = new SalesMan(null, "小李", "黄燕村", "13188883333", "litteli", "litteli", "litteli",
				new Byte("0"));
		when(request.getParameter("traineeTel")).thenReturn("15989027318");
		mockMvc.perform(
				post("/salesMan/add").contentType(MediaType.APPLICATION_JSON).content(JsonUtils.beanToJson(toInsert)))
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void testFindById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/salesMan/show/2")).andDo(MockMvcResultHandlers.print());
	}

}
