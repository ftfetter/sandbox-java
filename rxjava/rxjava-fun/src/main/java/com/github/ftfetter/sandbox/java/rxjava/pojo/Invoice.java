package com.github.ftfetter.sandbox.java.rxjava.pojo;

public class Invoice {
    private String clientName;
    private Double cartValue;

    public Invoice(String clientName, Double cartValue) {
        this.clientName = clientName;
        this.cartValue = cartValue;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Double getCartValue() {
        return cartValue;
    }

    public void setCartValue(Double cartValue) {
        this.cartValue = cartValue;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "clientName='" + clientName + '\'' +
                ", cartValue=" + cartValue +
                '}';
    }
}
