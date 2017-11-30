package com.kodilla.patterns2.decorator.pizza;

import com.kodilla.patterns2.decorator.taxiportal.AbstractOrderDecorator;
import com.kodilla.patterns2.decorator.taxiportal.Order;

import java.math.BigDecimal;

public class PepperDecorator extends AbstractOrderDecorator {
    public PepperDecorator(Order order) {
        super(order);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(1));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + pepper";
    }
}
