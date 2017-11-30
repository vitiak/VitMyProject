package com.kodilla.patterns2.decorator.taxiportal;

import java.math.BigDecimal;

public interface Order {
    BigDecimal getCost();
    String getDescription();
}
