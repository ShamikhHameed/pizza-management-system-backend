package com.nsss.pizzamanagementsystembackend.repository;

import com.nsss.pizzamanagementsystembackend.model.Crust;
import com.nsss.pizzamanagementsystembackend.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {
    List<Order> findAllByDeliveredIsFalse();
    List<Order> findAllByDeliveryRiderContainingAndDeliveredIsFalse(String riderName);
}
