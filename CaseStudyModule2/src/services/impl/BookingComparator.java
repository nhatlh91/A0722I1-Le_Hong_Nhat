package services.impl;

import models.Booking;

import java.util.Comparator;

public class BookingComparator implements Comparator<Booking> {

    @Override
    public int compare(Booking o1, Booking o2) {
        if (o1.getCheckin().isAfter(o2.getCheckin())) {
            return 1;
        } else if (o1.getCheckin().isBefore(o2.getCheckin())) {
            return -1;
        } else
            return (o1.getCheckout().isAfter(o2.getCheckout())) ? 1 : -1;
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
