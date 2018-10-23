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
import guru.springframework.controllers.CarrierVehicleController;
import guru.springframework.controllers.GoodsSourceController;
import guru.springframework.controllers.SalesManController;
import guru.springframework.domain.CarrierVehicle;
import guru.springframework.domain.GoodsSource;
import guru.springframework.domain.Price;
import guru.springframework.domain.SalesMan;
import guru.springframework.domain.Seller;
import guru.springframework.domain.ShipAddress;
import guru.springframework.util.JsonUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { SpringBootWebApplication.class, MockServletContext.class })
public class CarrierVehicleTest {
	@Autowired
	private CarrierVehicleController controller;
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
		CarrierVehicle toInsert = new CarrierVehicle();
		toInsert.setName("刘嘉沛");
		toInsert.setTel("0755110");
		toInsert.setPlate("粤BXXXXX");
		toInsert.setArea("广东省深圳市石岩镇");
		toInsert.setAddress("应人石");
		mockMvc.perform(
				post("/carrierVehicle/add").contentType(MediaType.APPLICATION_JSON).content(JsonUtils.beanToJsonNonNULL(toInsert)))
				.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
		@Rollback(false)
		public void testupdate() throws Exception {
			CarrierVehicle toInsert = new CarrierVehicle();
			toInsert.setId(1);
//			toInsert.setName("中国人民银行");
			toInsert.setTel("0766110");
			mockMvc.perform(
					post("/carrierVehicle/update").contentType(MediaType.APPLICATION_JSON).content(JsonUtils.beanToJsonNonNULL(toInsert)))
			.andDo(MockMvcResultHandlers.print());
	}
	
//	@Test
	@Rollback(false)
	public void testInsertAddress() throws Exception {
		CarrierVehicle CarrierVehicle = new CarrierVehicle();
		CarrierVehicle.setId(1);
		ShipAddress a = new ShipAddress();
		a.setAddress("深圳市灵芝地铁站");
		a.setTel("110");
		
		mockMvc.perform(
				post("/CarrierVehicle/address/add").contentType(MediaType.APPLICATION_JSON).content(JsonUtils.beanToJsonNonNULL(a)))
				.andDo(MockMvcResultHandlers.print());
	}

	// @Test
	public void testFindById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/goodsSource/show/2")).andDo(MockMvcResultHandlers.print());
	}
	 @Test
		public void testList() throws Exception {
			mockMvc.perform(MockMvcRequestBuilders.get("/carrierVehicle/list").param("page", "0").param("size", "20")).andDo(MockMvcResultHandlers.print());
		}


}
