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
import guru.springframework.controllers.GoodsSourceController;
import guru.springframework.controllers.SalesManController;
import guru.springframework.domain.Buyer;
import guru.springframework.domain.GoodsSource;
import guru.springframework.domain.Price;
import guru.springframework.domain.SalesMan;
import guru.springframework.domain.Seller;
import guru.springframework.domain.ShipAddress;
import guru.springframework.util.JsonUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { SpringBootWebApplication.class, MockServletContext.class })
public class GoodsSourceTest {
	@Autowired
	private GoodsSourceController controller;
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
		Seller s = new Seller();
		s.setName("广东大亚湾煤气站");
		SalesMan SalesMan = new SalesMan();
		SalesMan.setId(2);
		Price p = new Price();
		p.setCt(new Date());
		p.setTotalPrice(new BigDecimal("25"));
		p.setDiscount(0.8f);
		p.setUnit("吨");
		GoodsSource toInsert = new GoodsSource();
		p.setGoodssource(toInsert);
		toInsert.setSalesMan(SalesMan);
		toInsert.setSeller(s);
		toInsert.setPrice(p);
		mockMvc.perform(
				post("/goodsSource/add").contentType(MediaType.APPLICATION_JSON).content(JsonUtils.beanToJsonNonNULL(toInsert)))
				.andDo(MockMvcResultHandlers.print());
	}
	
//	@Test
	@Rollback(false)
	public void testInsertPrice() throws Exception {
		GoodsSource GoodsSource = new GoodsSource();
		GoodsSource.setId(3);
		Price p = new Price();
		p.setCt(new Date());
		p.setTotalPrice(new BigDecimal("566"));
		p.setDiscount(0.8f);
		p.setUnit("吨");
		p.setGoodssource(GoodsSource);
		mockMvc.perform(
				post("/goodsSource/price/add").contentType(MediaType.APPLICATION_JSON).content(JsonUtils.beanToJsonNonNULL(p)))
				.andDo(MockMvcResultHandlers.print());
	}


	@Test
	public void testFindById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/goodsSource/show/3")).andDo(MockMvcResultHandlers.print());
	}
//	 @Test
		public void testList() throws Exception {
			mockMvc.perform(MockMvcRequestBuilders.get("/goodsSource/list").param("page", "0").param("size", "20")).andDo(MockMvcResultHandlers.print());
		}
		
// @Test
		public void testPrices() throws Exception {
			mockMvc.perform(MockMvcRequestBuilders.get("/goodsSource/price/list").param("page", "0").param("goodsSourceId", "3")).andDo(MockMvcResultHandlers.print());
		}
		
//		@Test
		@Rollback(false)
		public void testupdate() throws Exception {
			GoodsSource GoodsSource = new GoodsSource();
			GoodsSource.setId(3);
//			GoodsSource.setArea("湖北省XX市武昌区");
//			GoodsSource.setAddress("珞咖山小区12栋205");
//			GoodsSource.setTel("1333333333");
			SalesMan SalesMan = new SalesMan();
			SalesMan.setId(2);
			GoodsSource.setSalesMan(SalesMan);
			mockMvc.perform(
					post("/goodsSource/update").contentType(MediaType.APPLICATION_JSON).content(JsonUtils.beanToJsonNonNULL(GoodsSource)))
			.andDo(MockMvcResultHandlers.print());
		}


}
