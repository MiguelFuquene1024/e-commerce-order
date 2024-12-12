package com.plataform.orderapi.order_e_commerce.infrastructure.router;


import com.plataform.orderapi.order_e_commerce.infrastructure.handler.OrderHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


@Configuration
@Slf4j
public class OrderRouter {

    private static final String PATH = "order";

    @Bean
    public WebProperties.Resources resources(){
        return new WebProperties.Resources();
    }
    @Bean
    RouterFunction<ServerResponse> router(OrderHandler handler) {
        return RouterFunctions.route()
                .GET(PATH,handler::getOrders)
                .GET(PATH + "/{id}",handler::getOrder)
                .POST(PATH,handler::createOrder)
                .PUT(PATH + "/{id}",handler::updateOrder)
                .DELETE(PATH + "/{id}",handler::deteleOrder)
                .build();
    }

}
