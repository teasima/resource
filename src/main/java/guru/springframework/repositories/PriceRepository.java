package guru.springframework.repositories;

import guru.springframework.domain.Buyer;
import guru.springframework.domain.CarrierVehicle;
import guru.springframework.domain.GoodsSource;
import guru.springframework.domain.Order;
import guru.springframework.domain.Price;
import guru.springframework.domain.Product;
import guru.springframework.domain.SalesMan;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PriceRepository extends CrudRepository<Price, Integer>{
	Page<Price> findAll(Pageable pageable);
	Page<Price> findByGoodssource(Pageable pageable,GoodsSource GoodsSource);
}
