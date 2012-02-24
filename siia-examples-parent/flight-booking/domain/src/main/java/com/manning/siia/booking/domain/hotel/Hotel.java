package com.manning.siia.booking.domain.hotel;

import com.manning.siia.booking.domain.Location;


public class Hotel {

    private long hotelId;

    private String hotelDescription;

    private String hotelName;

    private Location location;

    public Hotel(long hotelId, String hotelDescription, String hotelName, Location location) {
        this.hotelId = hotelId;
        this.hotelDescription = hotelDescription;
        this.hotelName = hotelName;
        this.location = location;
    }
}
