package guru.springframework.services;


import java.util.Date;
import java.util.List;
import java.util.Map;

import guru.springframework.domain.GoodsSource;
import guru.springframework.domain.Order;
import guru.springframework.domain.SalesMan;

public interface SalesManService {

	SalesMan getById(Integer id);

	SalesMan save(SalesMan Order);

    void delete(Integer id);

}
