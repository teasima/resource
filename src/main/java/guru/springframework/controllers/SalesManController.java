package guru.springframework.controllers;

import guru.springframework.domain.SalesMan;
import guru.springframework.domain.Product;
import guru.springframework.repositories.SalesManRepository;
import guru.springframework.services.SalesManService;
import guru.springframework.services.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/salesMan")
@Getter
@Setter
@Api(value = "salesMan", description = "Operations pertaining to sales men in QiLaile")
public class SalesManController {

	@Autowired
	private SalesManService SalesManService;

	@ApiOperation(value = "Search a  sales men with an ID", response = Product.class)
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = "application/json")
	public SalesMan showProduct(@PathVariable Integer id, Model model) {
		SalesMan product = SalesManService.getById(id);
		return product;
	}

	@ApiOperation(value = "Add a product")
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity saveProduct(@RequestBody SalesMan product) {
		try {
			SalesManService.save(product);
		} catch (DataIntegrityViolationException e) {
			return new ResponseEntity("value should be unique!", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity("sales men saved successfully", HttpStatus.OK);
	}

}
