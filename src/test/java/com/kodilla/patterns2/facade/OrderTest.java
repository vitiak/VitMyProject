package com.kodilla.patterns2.facade;

import org.junit.Test;

import java.math.BigDecimal;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;

public class OrderTest {

    @Test
    public void mapToBoardsTest() throws URISyntaxException {
        Long cos = new Long(123);
        Long cos2 = new Long(121);
        Order order = new Order(cos, cos2, new ProductService());
        assertEquals(cos, order.getOrderId());
        assertEquals(cos2, order.getUserId());
    }

    @Test
    public void calculatedValueTest() throws URISyntaxException {
        Long cos = new Long(1);
        Long cos2 = new Long(155);
        Order order = new Order(cos, cos2, new ProductService());

        BigDecimal cos3 = order.calculateValue();
        boolean submitted =  order.isSubmitted();
        boolean paid =  order.isPaid();
        boolean verified =  order.isVerified();

        assertEquals(cos, order.getOrderId());
        assertEquals(cos2, order.getUserId());
        assertEquals(BigDecimal.ZERO, cos3);
        assertEquals(false, order.isSubmitted());
        assertEquals(false, order.isPaid());
        assertEquals(false, order.isVerified());

    }


}
