package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.UUID;
public class Person {

    private final BigDecimal price;
    @NotBlank                   //name can't be blank
    private final String name;


    public Person(@JsonProperty("price") BigDecimal price,
                  @JsonProperty("name") String name) {

        this.price = price;
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
