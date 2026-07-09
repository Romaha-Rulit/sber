package com.sber.model;

import java.time.LocalDate;

public class Order {
    private final int id;
    private final double amount;
    private final LocalDate date;

    public Order(int id, double amount, LocalDate date) {
        this.id = id;
        this.amount = amount;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Order{id=" + id + ", amount=" + amount + ", date=" + date + "}";
    }
}
