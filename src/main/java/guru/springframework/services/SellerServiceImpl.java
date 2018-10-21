package guru.springframework.services;

import guru.springframework.domain.Seller;
import guru.springframework.domain.Product;
import guru.springframework.domain.ShipAddress;
import guru.springframework.repositories.SellerRepository;
import guru.springframework.repositories.ProductDAO;
import guru.springframework.repositories.ProductRepository;
import guru.springframework.repositories.ProfitJpaSpecificationExecutor;
import guru.springframework.repositories.ShipAddressRepository;
import guru.springframework.util.BeanUtils;
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
import org.springframework.dao.DataIntegrityViolationException;
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
public class SellerServiceImpl implements SellerService {

	@Autowired
	private SellerRepository SellerRepository;

	@Override
	public Seller getById(Integer id) {
		// TODO Auto-generated method stub
		return SellerRepository.findById(id).orElse(null);
	}

	@Override
	public Seller save(Seller Seller) throws DataIntegrityViolationException {
		log.log(Level.INFO, "save");
		if (Seller.getId() != null && Seller.getId() > 0) {

			Seller.setDisabled(null);
			Seller db = SellerRepository.findById(Seller.getId()).orElse(null);
			BeanUtils.copyPropertiesIgnoreNull(Seller, db);
			return SellerRepository.save(db);
		} else

			return SellerRepository.save(Seller);
	}

	@Override
	public void delete(Integer id) {
		log.log(Level.INFO, "deleteSeller called");
		SellerRepository.deleteById(id);
	}

	@Override
	public Page<Seller> list(Pageable pageable) {
		// TODO Auto-generated method stub
		return SellerRepository.findAll(pageable);
	}
 

}
