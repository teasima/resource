package guru.springframework.controllers;

import guru.springframework.domain.Buyer;
import guru.springframework.domain.Order;
import guru.springframework.domain.ShipAddress;
import guru.springframework.domain.Buyer;
import guru.springframework.repositories.OrderRepository;
import guru.springframework.services.BuyerService;
import guru.springframework.services.OrderService;
import guru.springframework.services.BuyerService;
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
@RequestMapping("/buyer")
@Getter
@Setter
@Api(value = "buyer", description = "Operations pertaining to Buyer in QiLaile")
public class BuyerController {

	@Autowired
	private BuyerService BuyerService;

	@ApiOperation(value = "Search a Buyer with an ID", response = Buyer.class)
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = "application/json")
	public Buyer showBuyer(@PathVariable Integer id, Model model) {
		Buyer Buyer = BuyerService.getById(id);
		return Buyer;
	}

	@ApiOperation(value = "Add a Buyer")
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity saveBuyer(@RequestBody Buyer Buyer) {
		try {
			BuyerService.save(Buyer);
		} catch (DataIntegrityViolationException e) {
			return new ResponseEntity("value should be unique!", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity("Buyer saved successfully", HttpStatus.OK);
	}
	
	@ApiOperation(value = "Update a Buyer")
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity updateBuyer(@RequestBody Buyer Buyer) {
		try {
			BuyerService.save(Buyer);
		} catch (DataIntegrityViolationException e) {
			return new ResponseEntity("value should be unique!", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity("Buyer updated successfully", HttpStatus.OK);
	}
	
	@ApiOperation(value = "Add a Address")
	@RequestMapping(value = "/address/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity saveAddress(@RequestBody ShipAddress ShipAddress) {
		try {
			BuyerService.saveShipAddress(ShipAddress);
		} catch (DataIntegrityViolationException e) {
			return new ResponseEntity("value should be unique!", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity("Buyer ship address saved successfully", HttpStatus.OK);
	}

	@ApiOperation(value = "List Buyers", response = Buyer.class)
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public Page<Buyer> showBuyer(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "15") Integer size) {
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable =   PageRequest.of(page, size, sort);
		Page< Buyer> Buyers = BuyerService.list(pageable);
		return Buyers;
	}

}
