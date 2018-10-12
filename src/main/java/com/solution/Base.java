package com.solution;

import java.util.ArrayList;
import java.util.List;

public class Base {

    public List<Order> getBase() {
        return base;
    }

    private List<Order> base;


    public void setBase(List<Order> base) {
        this.base = base;
    }

    Base() {
        this.base = new ArrayList<>();
    }
}
