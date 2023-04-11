package com.example.visitcounter.model;

import lombok.Data;


@Data
public class Counter {
    private int count;

    public int increment() {
        return count++;
    }
}
