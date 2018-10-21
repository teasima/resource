package guru.springframework.services;

import guru.springframework.domain.Buyer;
import guru.springframework.domain.GoodsSource;
import guru.springframework.domain.Price;
import guru.springframework.domain.Product;
import guru.springframework.domain.Seller;
import guru.springframework.domain.ShipAddress;
import guru.springframework.repositories.BuyerRepository;
import guru.springframework.repositories.GoodsSourceRepository;
import guru.springframework.repositories.PriceRepository;
import guru.springframework.repositories.ProductDAO;
import guru.springframework.repositories.ProductRepository;
import guru.springframework.repositories.ProfitJpaSpecificationExecutor;
import guru.springframework.repositories.SellerRepository;
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
public class GoodsSourceServiceImpl implements GoodsSourceService {
	@Autowired
	private GoodsSourceRepository goodsSourceRepository;
	@Autowired
	private SellerRepository sellerRepository;
	@Autowired
	private PriceRepository PriceRepository;
	@Autowired
	private guru.springframework.repositories.SalesManRepository SalesManRepository;

	private final String NON_EXISTS = "Seller doesn't exists!";

	@Override
	public GoodsSource getById(Integer id) {
		// TODO Auto-generated method stub
		return goodsSourceRepository.findById(id).orElse(null);
	}

	@Override
	public GoodsSource save(GoodsSource GoodsSource) throws Exception {
		log.log(Level.INFO, "save");
		

		if (GoodsSource.getId() != null && GoodsSource.getId() > 0) {

			GoodsSource db = goodsSourceRepository.findById(GoodsSource.getId()).orElse(null);
			BeanUtils.copyPropertiesIgnoreNull(GoodsSource, db);
			return goodsSourceRepository.save(db);
		} else{
			if (  GoodsSource.getSeller() != null) {
				String SellerName = GoodsSource.getSeller().getName();
				Seller seller = sellerRepository.findByName(SellerName);
				if (seller != null) {
					GoodsSource.setSeller(seller);
				} else if (GoodsSource.getSeller().getId() == null) {
					throw new Exception(NON_EXISTS);
				} else {
					Seller Seller = sellerRepository.findById(GoodsSource.getSeller().getId()).orElse(null);
					if (Seller == null)
						throw new Exception(NON_EXISTS);
					else
						GoodsSource.setSeller(Seller);
				}
			} else {
				throw new Exception(NON_EXISTS);
			}
			return goodsSourceRepository.save(GoodsSource);
		}
	}

	@Override
	public void delete(Integer id) {
		log.log(Level.INFO, "deleteGoodsSource called");
		goodsSourceRepository.deleteById(id);
	}

	@Override
	public Page<GoodsSource> list(Pageable pageable) {
		// TODO Auto-generated method stub
		return goodsSourceRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public void savePrice(Price price) {
		price = PriceRepository.save(price);
		GoodsSource GoodsSource = goodsSourceRepository.findById(price.getGoodssource().getId()).orElse(null);
		GoodsSource.setPrice(price);
		goodsSourceRepository.save(GoodsSource);

	}

	@Override
	public Page<Price> listPrice(Pageable pageable, Integer GoodsSourceId) {
		GoodsSource GoodsSource = new GoodsSource();
		GoodsSource.setId(GoodsSourceId);
		Page<Price> result = PriceRepository.findByGoodssource(pageable, GoodsSource);
		List<Price> list = result.getContent();
		Price basePrice = null;
		for (int i = list.size(); i > 0; i--) {
			Price price = list.get(i - 1);
			if (null != basePrice) {

			}
		}
		return result;
	}
}
