package com.manning.siia.business;

/**
 * @author Marius Bogoevici
 */
public interface FlightScheduler {
    Flight nextFlightForNumber(String split);
}
