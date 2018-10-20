package guru.springframework.controllers;

import guru.springframework.domain.GoodsSource;
import guru.springframework.domain.Order;
import guru.springframework.domain.GoodsSource;
import guru.springframework.repositories.OrderRepository;
import guru.springframework.services.GoodsSourceService;
import guru.springframework.services.OrderService;
import guru.springframework.services.GoodsSourceService;
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
@RequestMapping("/goodsSource")
@Getter
@Setter
@Api(value = "goodsSource", description = "Operations pertaining to GoodsSources in Online Store")
public class GoodsSourceController {

	@Autowired
	private GoodsSourceService goodsSourceService;

	@ApiOperation(value = "Search a GoodsSource with an ID", response = GoodsSource.class)
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = "application/json")
	public GoodsSource showGoodsSource(@PathVariable Integer id, Model model) {
		GoodsSource GoodsSource = goodsSourceService.getById(id);
		return GoodsSource;
	}

	@ApiOperation(value = "Add a GoodsSource")
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	@ApiResponse(code = 424, message = "Seller doesn't exists")
	public ResponseEntity saveGoodsSource(@RequestBody GoodsSource GoodsSource) {
		try {

			goodsSourceService.save(GoodsSource);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
		}
		return new ResponseEntity("GoodsSource saved successfully", HttpStatus.OK);
	}

	@ApiOperation(value = "List GoodsSources", response = GoodsSource.class)
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public Page<GoodsSource> showGoodsSource(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "15") Integer size) {
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable =   PageRequest.of(page, size, sort);
		Page< GoodsSource> GoodsSources = goodsSourceService.list(pageable);
		return GoodsSources;
	}

}
