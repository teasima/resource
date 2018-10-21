package guru.springframework.services;

import guru.springframework.domain.Buyer;
import guru.springframework.domain.Product;
import guru.springframework.domain.ShipAddress;
import guru.springframework.repositories.BuyerRepository;
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
public class BuyerServiceImpl implements BuyerService {

	@Autowired
	private BuyerRepository BuyerRepository;

	@Autowired
	private ShipAddressRepository ShipAddressRepository;

	@Override
	public Buyer getById(Integer id) {
		// TODO Auto-generated method stub
		return BuyerRepository.findById(id).orElse(null);
	}

	@Override
	public Buyer save(Buyer Buyer) throws DataIntegrityViolationException {
		log.log(Level.INFO, "save");
		if (Buyer.getId() != null && Buyer.getId() > 0) {

			Buyer.setDisabled(null);
			Buyer db = BuyerRepository.findById(Buyer.getId()).orElse(null);
			BeanUtils.copyPropertiesIgnoreNull(Buyer, db);
			return BuyerRepository.save(db);
		} else

			return BuyerRepository.save(Buyer);
	}

	@Override
	public void delete(Integer id) {
		log.log(Level.INFO, "deleteBuyer called");
		BuyerRepository.deleteById(id);
	}

	@Override
	public Page<Buyer> list(Pageable pageable) {
		// TODO Auto-generated method stub
		return BuyerRepository.findAll(pageable);
	}

	@Transactional
	@Override
	public void saveShipAddress(ShipAddress shipAddress) {
		shipAddress = ShipAddressRepository.save(shipAddress);
		Buyer buyer = BuyerRepository.findById(shipAddress.getBuyer().getId()).orElse(null);
		buyer.setShipAddress(shipAddress);
		BuyerRepository.save(buyer);

	}

}
