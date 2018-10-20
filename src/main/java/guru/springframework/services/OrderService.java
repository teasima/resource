package guru.springframework.services;


import java.util.Date;
import java.util.List;
import java.util.Map;

import guru.springframework.domain.Order;

public interface OrderService {

    Order getOrderById(Integer id);

    Order saveOrder(Order Order);

    void deleteOrder(Integer id);

}
