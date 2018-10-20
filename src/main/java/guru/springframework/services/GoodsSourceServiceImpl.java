package guru.springframework.services;

import guru.springframework.domain.GoodsSource;
import guru.springframework.domain.Product;
import guru.springframework.repositories.GoodsSourceRepository;
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
public class GoodsSourceServiceImpl implements GoodsSourceService {

	@Autowired
	private GoodsSourceRepository goodsSourceRepository;
	@Autowired
	private guru.springframework.repositories.SalesManRepository SalesManRepository;

	@Override
	public GoodsSource getById(Integer id) {
		// TODO Auto-generated method stub
		return goodsSourceRepository.findById(id).orElse(null);
	}

	@Override
	public GoodsSource save(GoodsSource GoodsSource) {
		log.log(Level.INFO, "save");

		return goodsSourceRepository.save(GoodsSource);
	}

	@Override
	public void delete(Integer id) {
		log.log(Level.INFO, "deleteGoodsSource called");
		goodsSourceRepository.deleteById(id);
	}

}
