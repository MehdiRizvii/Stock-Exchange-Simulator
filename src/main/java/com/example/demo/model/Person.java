package com.example.demo.model;

import java.util.Objects;
import java.util.UUID;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {

    private final UUID id;

    private final String price;
    @NotBlank
    private final String name;

    public Person(
            @JsonProperty("id") UUID id,
            @JsonProperty("name") String name,
            @JsonProperty("price") String price)
    {
        this.id = id;
        this.name = name;
        this.price = price;


    }

    public UUID getId() { return id;}

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