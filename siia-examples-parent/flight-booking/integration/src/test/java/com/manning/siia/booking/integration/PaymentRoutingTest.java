package com.manning.siia.booking.integration;

import com.manning.siia.booking.domain.payment.CreditCardPayment;
import com.manning.siia.booking.domain.payment.CreditCardType;
import com.manning.siia.booking.domain.payment.Invoice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Marius Bogoevici
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:payment-routing.xml")
public class PaymentRoutingTest {

    @Autowired
    @Qualifier("payments")
    MessageChannel payments;

    @Test
    public void testRouting() {

        payments.send(MessageBuilder.withPayload(new Invoice()).build());

    }


    @Test
    public void testCreditCardRouting() {
        CreditCardPayment payment = new CreditCardPayment();
        payment.setCreditCardType(CreditCardType.MASTERCARD);
        payments.send(MessageBuilder.withPayload(payment).build());
    }
}
