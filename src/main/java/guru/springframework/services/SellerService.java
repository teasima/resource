package guru.springframework.services;


import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import guru.springframework.domain.GoodsSource;
import guru.springframework.domain.Order;
import guru.springframework.domain.ShipAddress;
import guru.springframework.domain.Seller;
import guru.springframework.domain.CarrierVehicle;

public interface SellerService {

	Seller getById(Integer id);

	Seller save(Seller Order);

    void delete(Integer id);

    Page<Seller> list(Pageable pageable);

}
