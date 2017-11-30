package com.kodilla.patterns2.decorator.taxiportal;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class OrderTestSuite {

    @Test
    public void testBasicTaxiOrderGetCost() {
        Order theOrder = new BasicTaxiOrder();
        BigDecimal calculatedCost = theOrder.getCost();

        assertEquals(new BigDecimal(5), calculatedCost);
    }

    @Test
    public void testBasicTaxiOrderGetDescription() {
        Order theOrder = new BasicTaxiOrder();
        String description = theOrder.getDescription();

        assertEquals("drive a course", description);
    }

    @Test
    public void testTaxiNetworkGetCost() {
        Order theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);
        BigDecimal theCost = theOrder.getCost();

        assertEquals(new BigDecimal(40), theCost);
    }

    @Test
    public void testTaxiNetworkGetDescription() {
        Order theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);

        String description = theOrder.getDescription();

        assertEquals("drive a course by Taxi Network", description);
    }

    @Test
    public void testTaxiWithChildSeatGetCost() {
        Order theOrder = new BasicTaxiOrder();
        theOrder = new MyTaxiNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        BigDecimal theCost = theOrder.getCost();

        assertEquals(new BigDecimal(37), theCost);
    }

    @Test
    public void testTaxiWithChildSeatGetDescription() {
        Order theOrder = new BasicTaxiOrder();
        theOrder = new MyTaxiNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);

        String description = theOrder.getDescription();

        assertEquals("drive a course by MyTaxi Network + child seat", description);
    }

}
