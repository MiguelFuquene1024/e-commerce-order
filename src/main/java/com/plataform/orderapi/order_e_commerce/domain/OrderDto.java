package com.plataform.orderapi.order_e_commerce.domain;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDto {

    @NotBlank(message = "name is mandaroty")
    private String name;
    @NotBlank(message = "productos is mandaroty")
    private String products;
    @NotBlank(message = "cost is mandaroty")
    @Min(value = 1, message = "cost must be greater than zero")
    private float cost;
    @NotBlank(message = "state is mandaroty")
    private String state;
    @NotBlank(message = "date is mandaroty")
    private String date;
}
