package se.jacobswenson;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class Visit {
    private Customer customer;
    private LocalDate date;
    private LocalTime time;

     Visit(Customer customer) {
        this.customer = customer;
        this.date = LocalDate.now();
         this.time = LocalTime.now();
    }

     Customer getCustomer() {
        return customer;
    }

    String getTimeToString() {
        return this.time.format(DateTimeFormatter.ofPattern("HH:mm"));
    }
}

