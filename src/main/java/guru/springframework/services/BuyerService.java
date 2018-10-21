package guru.springframework.services;


import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import guru.springframework.domain.GoodsSource;
import guru.springframework.domain.Order;
import guru.springframework.domain.ShipAddress;
import guru.springframework.domain.Buyer;
import guru.springframework.domain.CarrierVehicle;

public interface BuyerService {

	Buyer getById(Integer id);

	Buyer save(Buyer Order);

    void delete(Integer id);

    Page<Buyer> list(Pageable pageable);

	void saveShipAddress(ShipAddress shipAddress);
}
