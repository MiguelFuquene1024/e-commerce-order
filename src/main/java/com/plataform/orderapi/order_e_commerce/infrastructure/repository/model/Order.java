package com.plataform.orderapi.order_e_commerce.infrastructure.repository.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="pedido")
public class Order {

    @Id
    private Integer id;
    @Column
    private String name;
    @Column
    private String products;
    @Column
    private float cost;
    @Column
    private String state;
    @Column
    private String date;

}
