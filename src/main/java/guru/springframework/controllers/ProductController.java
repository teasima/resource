package guru.springframework.controllers;

import guru.springframework.domain.Product;
import guru.springframework.services.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/statistics")
@Api(value = "statistics", description = "Operations pertaining to products in Online Store")
public class ProductController {

	private ProductService productService;

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@SuppressWarnings("rawtypes")
	@ApiOperation(value = "View a list of available products", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(value = "/profit", method = RequestMethod.GET, produces = "application/json")
	public Map list(@RequestParam(value= "start" ,required=false) String start, @RequestParam(value= "end" ,required=false ) String end,
			@RequestParam( value= "citys[]" ,required=true ) List<String> citys, @RequestParam( value= "regions[]" ,required=false) List<String> regions,
			@RequestParam( value= "houses[]" ,required=false) List<String> houses) {
		List<Product>  list = productService.profit(houses, regions, citys, start, end);
		Map result = new HashMap();
		Map survey  = new HashMap();
		survey.put("actualTotalRevenue", 2323);
		result.put("survey", survey);
		return result ;
	}

	@ApiOperation(value = "Search a product with an ID", response = Product.class)
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = "application/json")
	public Product showProduct(@PathVariable Integer id, Model model) {
		Product product = productService.getProductById(id);
		return product;
	}

	@ApiOperation(value = "Add a product")
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity saveProduct(@RequestBody Product product) {
		productService.saveProduct(product);
		return new ResponseEntity("Product saved successfully", HttpStatus.OK);
	}

	@ApiOperation(value = "Update a product")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity updateProduct(@PathVariable Integer id, @RequestBody Product product) {
		Product storedProduct = productService.getProductById(id);
		return new ResponseEntity("Product updated successfully", HttpStatus.OK);
	}

	@ApiOperation(value = "Delete a product")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity delete(@PathVariable Integer id) {
		productService.deleteProduct(id);
		return new ResponseEntity("Product deleted successfully", HttpStatus.OK);

	}

}
