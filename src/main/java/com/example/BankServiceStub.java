package com.example;

public class BankServiceStub implements BankService {

    private boolean paymentResult;

    public BankServiceStub(boolean paymentResult) {
        this.paymentResult = paymentResult;
    }

    @Override
    public boolean pay(String id, double amount) {
        return paymentResult;
    }
}
