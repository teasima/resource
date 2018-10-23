package guru.springframework.controllers;

import guru.springframework.domain.CarrierVehicle;
import guru.springframework.domain.GoodsSource;
import guru.springframework.domain.Order;
import guru.springframework.domain.CarrierVehicle;
import guru.springframework.repositories.OrderRepository;
import guru.springframework.services.CarrierVehicleService;
import guru.springframework.services.OrderService;
import guru.springframework.services.CarrierVehicleService;
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
@RequestMapping("/carrierVehicle")
@Getter
@Setter
@Api(value = "carrierVehicle", description = "Operations pertaining to CarrierVehicle in QiLaile")
public class CarrierVehicleController {

	@Autowired
	private CarrierVehicleService CarrierVehicleService;

	@ApiOperation(value = "Search a CarrierVehicle with an ID", response = CarrierVehicle.class)
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = "application/json")
	public CarrierVehicle showCarrierVehicle(@PathVariable Integer id, Model model) {
		CarrierVehicle CarrierVehicle = CarrierVehicleService.getById(id);
		return CarrierVehicle;
	}

	@ApiOperation(value = "Add a CarrierVehicle")
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity saveCarrierVehicle(@RequestBody CarrierVehicle CarrierVehicle) {
		try {
			CarrierVehicleService.save(CarrierVehicle);
		} catch (DataIntegrityViolationException e) {
			return new ResponseEntity("value should be unique!", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity("CarrierVehicle saved successfully", HttpStatus.OK);
	}
	
	@ApiOperation(value = "Update a Carrier Vehicle")
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity updateGoodsSource(@RequestBody CarrierVehicle CarrierVehicle) {
		try {
			CarrierVehicleService.save(CarrierVehicle);
		} catch (DataIntegrityViolationException e) {
			return new ResponseEntity("value should be unique!", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity("Goods Source updated successfully", HttpStatus.OK);
	}

	@ApiOperation(value = "List CarrierVehicles", response = CarrierVehicle.class)
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public Page<CarrierVehicle> showCarrierVehicle(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "15") Integer size) {
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable = PageRequest.of(page, size, sort);
		Page<CarrierVehicle> CarrierVehicles = CarrierVehicleService.list(pageable);
		return CarrierVehicles;
	}
	
	

}
