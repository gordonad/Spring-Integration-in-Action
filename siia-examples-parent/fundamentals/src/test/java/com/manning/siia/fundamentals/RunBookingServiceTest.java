package com.manning.siia.fundamentals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/manning/siia/fundamentals/context.xml")
public class RunBookingServiceTest {

    @Autowired
    @Qualifier("mealPreferenceUpdatesChannel")
    MessageChannel channel;


    @Test
    public void updateMealPreferences() {
        channel.send(
                MessageBuilder.withPayload(new MealPreference()).build());
    }
}
