package guru.springframework.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
import guru.springframework.controllers.BuyerController;
import guru.springframework.controllers.GoodsSourceController;
import guru.springframework.controllers.OrderController;
import guru.springframework.controllers.SalesManController;
import guru.springframework.domain.Buyer;
import guru.springframework.domain.GoodsSource;
import guru.springframework.domain.Order;
import guru.springframework.domain.Price;
import guru.springframework.domain.SalesMan;
import guru.springframework.domain.Seller;
import guru.springframework.domain.ShipAddress;
import guru.springframework.util.JsonUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { SpringBootWebApplication.class, MockServletContext.class })
public class OrderTest {
	@Autowired
	private OrderController controller;
	private MockMvc mockMvc;
	@Mock
	MockHttpServletRequest request;
	@Mock
	MockHttpSession session;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

//	@Test
	@Rollback(false)
	public void testInsert() throws Exception {
		Order toInsert = new Order();
		Buyer b = new Buyer();
		b.setId(1);
		SalesMan s = new SalesMan();
		s.setId(2);
		GoodsSource g = new GoodsSource();
		g.setId(3);
		toInsert.setBuyer(b);
		toInsert.setSalesMan(s);
		toInsert.setGoodssource(g);
		toInsert.setAmount(new BigDecimal("200"));
		mockMvc.perform(
				post("/order/add").contentType(MediaType.APPLICATION_JSON).content(JsonUtils.beanToJsonNonNULL(toInsert)))
				.andDo(MockMvcResultHandlers.print());
		
	}
	
	 @Test
		public void testList() throws Exception {
			mockMvc.perform(MockMvcRequestBuilders.get("/order/list").param("salesManId", "2").param("orderStatus", "UNPAID")).andDo(MockMvcResultHandlers.print());
		}
	

}
