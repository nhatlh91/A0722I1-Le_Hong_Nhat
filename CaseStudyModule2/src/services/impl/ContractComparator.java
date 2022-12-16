package services.impl;

import models.Booking;

import java.util.Comparator;

public class ContractComparator implements Comparator<Booking> {
    @Override
    public int compare(Booking o1, Booking o2) {
        return o1.getBookingDay().isAfter(o2.getBookingDay()) ? 1 : -1;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
