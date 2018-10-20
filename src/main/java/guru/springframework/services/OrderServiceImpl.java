package guru.springframework.services;

import guru.springframework.domain.Order;
import guru.springframework.domain.Product;
import guru.springframework.repositories.OrderRepository;
import guru.springframework.repositories.ProductDAO;
import guru.springframework.repositories.ProductRepository;
import guru.springframework.repositories.ProfitJpaSpecificationExecutor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

@Log
@Service
@Getter
@Setter
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private guru.springframework.repositories.SalesManRepository SalesManRepository;

	@Override
	public Order getOrderById(Integer id) {
		// TODO Auto-generated method stub
		return orderRepository.findById(id).orElse(null);
	}

	@Override
	public Order saveOrder(Order Order) {
		log.log(Level.INFO, "saveOrder");
		if (Order.getSalesMan() != null && Order.getSalesMan().getId() != null && Order.getSalesMan().getId() > 0) {
			Order.setSalesMan(SalesManRepository.findById( Order.getSalesMan().getId()).orElse(null));
		}

		return orderRepository.save(Order);
	}

	@Override
	public void deleteOrder(Integer id) {
		log.log(Level.INFO, "deleteOrder called");
		orderRepository.deleteById(id);

	}

}
