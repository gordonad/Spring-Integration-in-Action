package com.manning.siia.booking.domain.payment;

public class PaymentManager {

    public void processPayment(Invoice invoice) {
        // process payment for Invoice
    }

    public void processPayment(CreditCardPayment creditCardPayment) {
        // process payment for CreditCardPayment
    }

    public void processPayment(PaypalPayment payment) {
        // process payment for PaypalPayment
    }
}
