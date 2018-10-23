package guru.springframework.controllers;

import guru.springframework.domain.GoodsSource;
import guru.springframework.domain.Order;
import guru.springframework.domain.OrderStatus;
import guru.springframework.repositories.OrderRepository;
import guru.springframework.services.OrderService;
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
@RequestMapping("/order")
@Getter
@Setter
@Api(value = "order", description = "Operations pertaining to orders in QiLaile")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@ApiOperation(value = "Search an order with an ID", response = Order.class)
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = "application/json")
	public Order showorder(@PathVariable Integer id, Model model) {
		Order order = orderService.getById(id);
		return order;
	}

	@ApiOperation(value = "Add an order")
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity saveorder(@RequestBody Order order) {

		try {
			orderService.save(order);
		} catch (DataIntegrityViolationException e) {
			return new ResponseEntity("value should be unique!", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity("Order saved successfully", HttpStatus.OK);
	}

	@ApiOperation(value = "Update an order,can only be updaed before pay!")
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity updateorder(@RequestBody Order Order) {
		try {
			orderService.save(Order);
		} catch (DataIntegrityViolationException e) {
			return new ResponseEntity("value should be unique!", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity("Order updated successfully", HttpStatus.OK);
	}

	@ApiOperation(value = "List orders", response = GoodsSource.class)
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public Page<Order> showGoodsSource(@RequestParam(value = "salesManId") Integer salesManId,
			@RequestParam(value = "orderStatus") OrderStatus OrderStatus,@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "15") Integer size) {
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable = PageRequest.of(page, size, sort);
		Page<Order> Orders = orderService.list( salesManId, OrderStatus,pageable);
		return Orders;
	}
	
	@ApiOperation(value = "Delete an order")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity delete(@PathVariable Integer id) {
		orderService.delete(id);
		return new ResponseEntity("Order deleted successfully", HttpStatus.OK);

	}
}
