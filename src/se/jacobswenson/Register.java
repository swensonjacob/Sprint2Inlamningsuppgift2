package se.jacobswenson;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Register {

    private List<Customer> customers;

    /**
     * inläsning av fil från ingående filnamn där ny Customer skapas och läggs till i listan customers
     * -try with resources
     */
    Register(String fileName) throws IOException {
        this.customers = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                String personalNumber = scanner.next();
                String name = scanner.next() + " " + scanner.next();
                String payDate = scanner.next();
                customers.add(new Customer(name, personalNumber.replace(",", ""), payDate));
            }
        }
    }

    List<Customer> getCustomers() {
        return customers;
    }
}
