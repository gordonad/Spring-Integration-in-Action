package com.manning.siia.booking.integration.notifications;

import com.manning.siia.booking.domain.flight.Flight;
import com.manning.siia.booking.domain.notifications.FlightNotification;
import com.manning.siia.booking.domain.notifications.TripNotification;
import com.manning.siia.booking.domain.trip.Leg;
import com.manning.siia.booking.domain.trip.Trip;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItem;
import static org.mockito.Mockito.mock;

/**
 * @author Iwein Fuld
 */
public class FlightToTripNotificationsSplitterTest {

    private final FlightToTripNotificationsSplitter splitter = new FlightToTripNotificationsSplitter();

    @Test
    public void shouldReturnTripNotificationForEachAffectedTrip() {
        FlightNotification flightNotification = new FlightNotification("Flight is cancelled", mock(Flight.class));
        List<Trip> affectedTrips = new ArrayList<Trip>(5);
        affectedTrips.add(new Trip(Collections.singletonList(mock(Leg.class))));
        List<TripNotification> notifications = splitter.generateTripNotificationsFrom(flightNotification, affectedTrips);
        for (TripNotification notification : notifications) {
            assertThat(affectedTrips, hasItem(notification.getTrip()));
        }
    }

}
