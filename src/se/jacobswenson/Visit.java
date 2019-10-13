package se.jacobswenson;

import java.time.LocalDate;
import java.time.LocalDateTime;

 class Visit {
    private Customer customer;
    private LocalDate date;
    private String time;

     Visit(Customer customer) {
        this.customer = customer;
        this.date = LocalDate.now();
        this.time = LocalDateTime.now().toString().substring(11, 16);
    }

     Customer getCustomer() {
        return customer;
    }

     String getTime() {
        return time;
    }
}

