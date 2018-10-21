package guru.springframework.services;


import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import guru.springframework.domain.CarrierVehicle;
import guru.springframework.domain.Order;

public interface CarrierVehicleService {

	CarrierVehicle getById(Integer id);

	CarrierVehicle save(CarrierVehicle Order) throws Exception;

    void delete(Integer id);
    
   Page<CarrierVehicle> list(Pageable pageable);


}
