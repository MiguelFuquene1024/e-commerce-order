package com.plataform.orderapi.order_e_commerce.application.service;


import com.plataform.orderapi.order_e_commerce.domain.OrderDto;
import com.plataform.orderapi.order_e_commerce.infrastructure.repository.model.Order;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderService {

    Mono<Order> createOrder(OrderDto OrderDto);

    Mono<Order> getOrder(Integer OrderId);

    Flux<Order> getAllOrders();

    Mono<Order> updateOrder(Integer id, OrderDto OrderDto);

    Mono<Void> deleteOrder(Integer OrderId);
}
