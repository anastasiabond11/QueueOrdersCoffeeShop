package org.example;

import java.util.LinkedList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CoffeeOrderBoard {
    private static final Logger logger = LoggerFactory.getLogger(CoffeeOrderBoard.class);
    private List<Order> orders;
    private int nextOrderNumber;

    public CoffeeOrderBoard() {
        orders = new LinkedList<>();
        nextOrderNumber = 1;
    }

    public void add(String customerName) {
        Order newOrder = new Order(nextOrderNumber++, customerName);
        orders.add(newOrder);
        logger.info("New order added: {}", newOrder);
    }

    public Order deliver() {
        if (orders.isEmpty()) {
            logger.warn("No orders to deliver");
            return null;
        }
        Order nextOrder = orders.remove(0);
        logger.info("Delivered order: {}", nextOrder);
        return nextOrder;
    }

    public Order deliver(int orderNumber) {
        for (Order order : orders) {
            if (order.getOrderNumber() == orderNumber) {
                orders.remove(order);
                logger.info("Delivered specific order: {}", order);
                return order;
            }
        }
        logger.warn("Order with number {} not found", orderNumber);
        return null;
    }

    public void draw() {
        logger.info("Current queue:");
        System.out.println("Num | Name");
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}

