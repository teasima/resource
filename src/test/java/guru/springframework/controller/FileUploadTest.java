package guru.springframework.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.net.URI;
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
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import guru.springframework.SpringBootWebApplication;
import guru.springframework.controllers.BuyerController;
import guru.springframework.controllers.GoodsSourceController;
import guru.springframework.controllers.SalesManController;
import guru.springframework.controllers.UploadController;
import guru.springframework.domain.Buyer;
import guru.springframework.domain.GoodsSource;
import guru.springframework.domain.Price;
import guru.springframework.domain.SalesMan;
import guru.springframework.domain.Seller;
import guru.springframework.domain.ShipAddress;
import guru.springframework.util.JsonUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {   MockServletContext.class })
public class FileUploadTest {
	@Spy
	private UploadController controller;
	private MockMvc mockMvc;
 

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void upLoad() throws Exception {
		 File sf = new File("C://Users//hp//Pictures//a.jpg");
		 FileInputStream contentStream = new FileInputStream(sf);
		 int filelong = contentStream.available();
		 byte buffer[] = new byte[filelong];
		 contentStream.read(buffer);
		 contentStream.close();
		 mockMvc.perform( fileUpload("/file/upload").file( 
				 new MockMultipartFile("file2", "test.jpg", ",multipart/form-data",buffer)
	               )) .andDo(MockMvcResultHandlers.print());//执行文件上传

	}
	
	public static MockMultipartHttpServletRequestBuilder fileUpload(
			String urlTemplate, Object... urlVariables) {
		return MockMvcRequestBuilders.fileUpload(urlTemplate, urlVariables);
	}

	public static MockMultipartHttpServletRequestBuilder fileUpload(URI uri) {
		return MockMvcRequestBuilders.fileUpload(uri);
	}

}
