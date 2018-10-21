package guru.springframework.controllers;

import guru.springframework.domain.Seller;
import guru.springframework.domain.Order;
import guru.springframework.domain.ShipAddress;
import guru.springframework.domain.Seller;
import guru.springframework.repositories.OrderRepository;
import guru.springframework.services.SellerService;
import guru.springframework.services.OrderService;
import guru.springframework.services.SellerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.TransientPropertyValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seller")
@Getter
@Setter
@Api(value = "seller", description = "Operations pertaining to Seller in QiLaile")
public class SellerController {

	@Autowired
	private SellerService SellerService;

	@ApiOperation(value = "Search a Seller with an ID", response = Seller.class)
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = "application/json")
	public Seller showSeller(@PathVariable Integer id, Model model) {
		Seller Seller = SellerService.getById(id);
		return Seller;
	}

	@ApiOperation(value = "Add a Seller")
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity saveSeller(@RequestBody Seller Seller) {
		try {
			SellerService.save(Seller);
		} catch (DataIntegrityViolationException e) {
			return new ResponseEntity("value should be unique!", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity("Seller saved successfully", HttpStatus.OK);
	}
	
	@ApiOperation(value = "Update a Seller")
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity updateSeller(@RequestBody Seller Seller) {
		try {
			SellerService.save(Seller);
		} catch (DataIntegrityViolationException e) {
			return new ResponseEntity("value should be unique!", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity("Seller updated successfully", HttpStatus.OK);
	}
	

	@ApiOperation(value = "List Sellers", response = Seller.class)
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public Page<Seller> showSeller(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "15") Integer size) {
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable =   PageRequest.of(page, size, sort);
		Page< Seller> Sellers = SellerService.list(pageable);
		return Sellers;
	}

}
