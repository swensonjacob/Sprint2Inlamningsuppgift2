package se.jacobswenson;

import java.time.LocalDate;

 class Customer {

    private String name;
    private String personalNumber;
    private String payDate;

     Customer(String name, String personalNumber, String payDate) {
        this.name = name;
        this.personalNumber = personalNumber;
        this.payDate = payDate;
    }

     String getName() {
        return name;
    }

     String getPersonalNumber() {
        return personalNumber;
    }

     String getPayDate() {
        return payDate;
    }

    boolean membershipIsValid (Customer customer) {
        LocalDate localDate = LocalDate.now();
        LocalDate payDate = LocalDate.parse(customer.getPayDate());
        LocalDate oneYearAgo = LocalDate.now().minusYears(1);

        return payDate.isAfter(oneYearAgo) && payDate.isBefore(localDate);
    }
}
