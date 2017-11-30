package com.kodilla.patterns2.decorator.pizza;

import com.kodilla.patterns2.decorator.taxiportal.AbstractOrderDecorator;
import com.kodilla.patterns2.decorator.taxiportal.Order;

import java.math.BigDecimal;

public class CheeseDecorator extends AbstractOrderDecorator {
    public CheeseDecorator(Order order) {
        super(order);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(2));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + cheese";
    }
}
