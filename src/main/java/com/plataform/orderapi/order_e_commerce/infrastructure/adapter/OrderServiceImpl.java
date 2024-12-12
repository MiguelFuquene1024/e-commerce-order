package com.plataform.orderapi.order_e_commerce.infrastructure.adapter;


import com.plataform.orderapi.order_e_commerce.application.exception.CustomException;
import com.plataform.orderapi.order_e_commerce.application.service.OrderService;
import com.plataform.orderapi.order_e_commerce.domain.OrderDto;
import com.plataform.orderapi.order_e_commerce.infrastructure.repository.OrderRepository;
import com.plataform.orderapi.order_e_commerce.infrastructure.repository.model.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final static String NOT_FOUND_MESSAGE = "Order not found";

    private final static String NOT_REPEATED_NAME = "Order name already in use";

    private final OrderRepository orderRepository;


    @Override
    public Mono<Order> getOrder(Integer OrderId) {
        return orderRepository.findById(OrderId)
                .switchIfEmpty(Mono.error(new CustomException(HttpStatus.NOT_FOUND,NOT_FOUND_MESSAGE)));
    }

    @Override
    public Flux<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Mono<Order> createOrder(OrderDto orderDto) {
        Order order = Order.builder()
                .name(orderDto.getName())
                .products(orderDto.getProducts())
                .cost(orderDto.getCost())
                .state(orderDto.getState())
                .date(orderDto.getDate())
                .build();
        return orderRepository.save(order);
    }

    @Override
    public Mono<Order> updateOrder(Integer id,OrderDto orderDto) {
        Mono<Boolean> orderId = orderRepository.findById(id).hasElement();
        Order order = Order.builder()
                .name(orderDto.getName())
                .products(orderDto.getProducts())
                .cost(orderDto.getCost())
                .state(orderDto.getState())
                .date(orderDto.getDate())
                .build();
        return orderId.flatMap(
                existsId -> existsId ? orderRepository.save(order) : Mono.error(
                                        new CustomException(HttpStatus.NOT_FOUND,NOT_FOUND_MESSAGE)));

    }

    @Override
    public Mono<Void> deleteOrder(Integer OrderId) {
        Mono<Boolean> existsId =  orderRepository.findById(OrderId).hasElement();
        return existsId.flatMap(exists -> exists ? orderRepository.deleteById(OrderId):
                Mono.error(new CustomException(HttpStatus.NOT_FOUND,NOT_FOUND_MESSAGE)));
    }
}
