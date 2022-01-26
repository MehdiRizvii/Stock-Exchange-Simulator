package com.example.demo.model;

import java.util.Objects;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {


    private final String price;
    @NotBlank
    private final String name;

    public Person(@JsonProperty("price") String price, @JsonProperty("name") String name) {
        this.price = price;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        return Objects.equals(price, other.price);
    }


}