package com.manning.siia.soap;

import com.manning.siia.booking.domain.Location;
import com.manning.siia.booking.domain.trip.Leg;
import com.manning.siia.booking.domain.trip.LegQuoteCommand;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ws.client.core.WebServiceOperations;

public class
        SoapTripTestClient {
    private static final Logger logger = LoggerFactory.getLogger(SoapTripTestClient.class);
    private static final CommandBuilder builder = new CommandBuilder();


    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("soap-client-applicationContext.xml", SoapTripTestClient.class);
        WebServiceOperations webServiceOperations = (WebServiceOperations) ctx.getBean(WebServiceOperations.class);


        LegQuoteCommand command = new LegQuoteCommand(builder.buildTestLeg());
        Object result = webServiceOperations.marshalSendAndReceive(command);
        logger.debug(result.toString());
    }


    private static class CommandBuilder {

        public Leg buildTestLeg() {
            DateTime now = new DateTime();
            DateTime startOfLeg = now.plusDays(7);
            DateTime endOfLeg = now.plusDays(14);
            Location startLocation = new Location("EN", "London");
            Location endLocation = new Location("US", "New York");
            return new Leg(startOfLeg, endOfLeg, startLocation, endLocation);
        }


    }

}
