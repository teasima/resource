package guru.springframework.services;


import java.util.Date;
import java.util.List;
import java.util.Map;

import guru.springframework.domain.GoodsSource;
import guru.springframework.domain.Order;

public interface GoodsSourceService {

	GoodsSource getById(Integer id);

	GoodsSource save(GoodsSource Order);

    void delete(Integer id);

}
