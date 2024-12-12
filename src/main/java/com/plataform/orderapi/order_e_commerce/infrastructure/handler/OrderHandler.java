package com.plataform.orderapi.order_e_commerce.infrastructure.handler;


import com.plataform.orderapi.order_e_commerce.domain.OrderDto;
import com.plataform.orderapi.order_e_commerce.infrastructure.adapter.OrderServiceImpl;
import com.plataform.orderapi.order_e_commerce.infrastructure.repository.model.Order;
import com.plataform.orderapi.order_e_commerce.infrastructure.validation.ObjectValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderHandler {


    private final OrderServiceImpl orderService;

    private final ObjectValidator objectValidator;


    public Mono<ServerResponse> getOrders(ServerRequest request) {
        Flux<Order> orders = orderService.getAllOrders();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(orders, Order.class);
    }

    public Mono<ServerResponse> getOrder(ServerRequest request) {
        Integer id = Integer.parseInt(request.pathVariable("id"));
        Mono<Order> order = orderService.getOrder(id);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(order, Order.class);
    }

    public Mono<ServerResponse> createOrder(ServerRequest request) {
        Mono<OrderDto> orderDtoMono = request.bodyToMono(OrderDto.class).doOnNext(objectValidator::validate);
        return orderDtoMono.flatMap(orderDto -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(orderService.createOrder(orderDto), Order.class));
    }

    public Mono<ServerResponse> updateOrder(ServerRequest request) {
        Integer id = Integer.parseInt(request.pathVariable("id"));
        Mono<OrderDto> orderDtoMono = request.bodyToMono(OrderDto.class).doOnNext(objectValidator::validate);;
        return orderDtoMono.flatMap(orderDto -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(orderService.updateOrder(id,orderDto), Order.class));
    }

    public Mono<ServerResponse> deteleOrder(ServerRequest request) {
        Integer id = Integer.parseInt(request.pathVariable("id"));
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(orderService.deleteOrder(id), Order.class);
    }
}
