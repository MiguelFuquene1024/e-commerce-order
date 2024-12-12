package com.plataform.orderapi.order_e_commerce.infrastructure.repository;

import com.plataform.orderapi.order_e_commerce.infrastructure.repository.model.Order;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface OrderRepository extends ReactiveCrudRepository<Order,Integer> {

    Mono<Order> findByName(String name);


}
