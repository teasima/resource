package guru.springframework.services;

import guru.springframework.domain.Product;
import guru.springframework.repositories.ProductDAO;
import guru.springframework.repositories.ProductRepository;
import guru.springframework.repositories.ProfitJpaSpecificationExecutor;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

@Service
public class ProductServiceImpl implements ProductService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private ProductRepository productRepository;
    
    private ProfitJpaSpecificationExecutor profitJpaSpecificationExecutor;
    
    private ProductDAO productDAO;
    
    @Autowired
	public void setProfitJpaSpecificationExecutor(ProfitJpaSpecificationExecutor profitJpaSpecificationExecutor) {
		this.profitJpaSpecificationExecutor = profitJpaSpecificationExecutor;
	}

	@Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
	
	@Autowired
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	@Override
    public List<Product> profit( List<String> houses, List<String> regions,List<String> citys,String st , String et) {
        logger.debug("profit called");
        return productDAO.profit(houses, regions, citys, st, et) ;
    }
    

    @Override
    public Product getProductById(Integer id) {
        logger.debug("getProductById called");
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product saveProduct(Product product) {
        logger.debug("saveProduct called");
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        logger.debug("deleteProduct called");
        productRepository.deleteById(id);
    }

}
