package com.kodilla.patterns2.decorator.pizza;

import com.kodilla.patterns2.decorator.taxiportal.*;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class OrderTestPizza {

    @Test
    public void testBasicPizzaGetCost() {
        Order theOrder = new BasicPizzaOrder();
        BigDecimal calculatedCost = theOrder.getCost();

        assertEquals(new BigDecimal(15), calculatedCost);
    }

    @Test
    public void testBasicPizzaGetDescription() {
        Order theOrder = new BasicPizzaOrder();
        String description = theOrder.getDescription();

        assertEquals("standard pizza margheritta", description);
    }

    @Test
    public void testPizzaWithPepperHamGetCost() {
        Order theOrder = new BasicPizzaOrder();
        theOrder = new PepperDecorator(theOrder);
        theOrder = new HamDecorator(theOrder);
        BigDecimal theCost = theOrder.getCost();

        assertEquals(new BigDecimal(19), theCost);
    }

    @Test
    public void testPizzaWithPepperHamGetDescription() {
        Order theOrder = new BasicPizzaOrder();
        theOrder = new PepperDecorator(theOrder);
        theOrder = new HamDecorator(theOrder);

        String description = theOrder.getDescription();

        assertEquals("standard pizza margheritta + pepper + ham", description);
    }

}
