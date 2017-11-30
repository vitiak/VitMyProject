package com.kodilla.patterns2.decorator.taxiportal;

import java.math.BigDecimal;

public abstract class AbstractOrderDecorator implements Order {
    private final Order order;

    protected AbstractOrderDecorator(Order order) {
        this.order = order;
    }

    @Override
    public BigDecimal getCost() {
        return order.getCost();
    }

    @Override
    public String getDescription() {
        return order.getDescription();
    }
    }
