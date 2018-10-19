package guru.springframework.services;


import java.util.Date;
import java.util.List;
import java.util.Map;

import guru.springframework.domain.Product;

public interface ProductService {

    Product getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(Integer id);

    public List<Product> profit( List<String> houses, List<String> regions,List<String> citys,String st , String et);
}
