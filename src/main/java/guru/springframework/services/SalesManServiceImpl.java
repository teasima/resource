package guru.springframework.services;

import guru.springframework.domain.SalesMan;
import guru.springframework.domain.Product;
import guru.springframework.repositories.SalesManRepository;
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
public class SalesManServiceImpl implements SalesManService {

	@Autowired
	private SalesManRepository SalesManRepository;

	@Override
	public SalesMan getById(Integer id) {
		// TODO Auto-generated method stub
		return SalesManRepository.findById(id).orElse(null);
	}

	@Override
	public SalesMan save(SalesMan SalesMan) {
		log.log(Level.INFO, "save");

		return SalesManRepository.save(SalesMan);
	}

	@Override
	public void delete(Integer id) {
		log.log(Level.INFO, "deleteSalesMan called");
		SalesManRepository.deleteById(id);
	}

}
