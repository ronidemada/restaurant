package com.example.restaurant.fake;

import lombok.Data;

@Data
public class FakeObject {

    private String name;

    public FakeObject(String name) {
        this.name = name;
    }
}
