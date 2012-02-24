package com.manning.siia.business;

/**
 * @author Marius Bogoevici
 */
public class Passenger {

    private String frequentFlyerNumber;

    private Profile profile;

    public String getFrequentFlyerNumber() {
        return frequentFlyerNumber;
    }

    public void addProfile(Profile profile) {
        this.profile = profile;
    }

    public Profile getProfile() {
        return profile;
    }
}
