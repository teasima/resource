package guru.springframework.services;

import guru.springframework.domain.Buyer;
import guru.springframework.domain.GoodsSource;
import guru.springframework.domain.Order;
import guru.springframework.domain.OrderStatus;
import guru.springframework.domain.Product;
import guru.springframework.domain.SalesMan;
import guru.springframework.domain.Seller;
import guru.springframework.repositories.BuyerRepository;
import guru.springframework.repositories.GoodsSourceRepository;
import guru.springframework.repositories.OrderRepository;
import guru.springframework.repositories.ProductDAO;
import guru.springframework.repositories.ProductRepository;
import guru.springframework.repositories.ProfitJpaSpecificationExecutor;
import guru.springframework.util.BeanUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

@Log
@Service
@Getter
@Setter
public class OrderServiceImpl implements OrderService {
	private final String NON_EXISTS = "Buyer  is required!";

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private BuyerRepository buyerRepository;

	@Autowired
	private GoodsSourceRepository GoodsSourceRepository;
	@Autowired
	private guru.springframework.repositories.SalesManRepository SalesManRepository;

	@Override
	public Order getById(Integer id) {
		// TODO Auto-generated method stub
		return orderRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Order save(Order Order) throws Exception {
		log.log(Level.INFO, "saveOrder");

		if (Order.getId() != null && Order.getId() > 0) {

			Order db = orderRepository.findById(Order.getId()).orElse(null);
			if (db.getStatus().equals(OrderStatus.UNPAID)) {
				BeanUtils.copyPropertiesIgnoreNull(Order, db);
				return orderRepository.save(db);
			} else {
				throw new Exception("Paid Order cann't be updated!");
			}

		} else {
			if (Order.getBuyer() == null || Order.getBuyer().getId() == null) {
				throw new Exception(NON_EXISTS);
			} else if (Order.getAmount() == null || Order.getAmount().compareTo(new BigDecimal("0")) <= 0) {
				throw new Exception("Amount should be greater than 0!");
			} else if (Order.getGoodssource() == null || Order.getGoodssource().getId() == null) {
				throw new Exception("Goods Source   is required!");
			} else if (Order.getSalesMan() == null || Order.getSalesMan().getId() == null) {
				throw new Exception("Sales Man  is required!");
			}
			GoodsSource Goodssource = GoodsSourceRepository.findById(Order.getGoodssource().getId()).orElse(null);
			Buyer Buyer = buyerRepository.findById(Order.getBuyer().getId()).orElse(null);
			Order.setArea(Buyer.getShipAddress().getAera());
			Order.setAddress(Buyer.getShipAddress().getAddress());
			Order.setPrice(Goodssource.getPrice().getDiscount() != null
					? Goodssource.getPrice().getTotalPrice()
							.multiply(new BigDecimal(Goodssource.getPrice().getDiscount()))
					: Goodssource.getPrice().getTotalPrice());
			Order.setTotalPrice(Order.getPrice().multiply(Order.getAmount()));
			Order.setCode( "S" +String.valueOf(System.currentTimeMillis() ) .toString());
			Order.setCt(new Date());
			Order.setStatus(OrderStatus.UNPAID);
			return orderRepository.save(Order);
		}

	}

	@Override
	public void delete(Integer id) {
		log.log(Level.INFO, "deleteOrder called");
		orderRepository.deleteById(id);

	}

	@Override
	public Page<Order> list(Integer salesManId, OrderStatus OrderStatus, Pageable pageable) {
		SalesMan qSalesMan = new SalesMan();
		qSalesMan.setId(salesManId);
		return orderRepository.findBySalesManAndStatus(qSalesMan, OrderStatus, pageable);
	}
	

}
