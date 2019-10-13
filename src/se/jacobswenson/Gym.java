package se.jacobswenson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 class Gym {

    private List<Customer> customers;
    private VisitLog visitLog;

     Gym() {
        customers = new ArrayList<>();
        this.visitLog = new VisitLog();
        addCustomersFromFile();
    }

    private void addCustomersFromFile() {
        String fileName = "temp.txt";
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                String personalNumber = scanner.next();
                String name = scanner.next() + " " + scanner.next();
                String payDate = scanner.next();
                customers.add(new Customer(name, personalNumber.replace(",", ""), payDate));
            }
        } catch (IOException e) {
            Output.errorReadFile(fileName);
        }
    }

     Customer customerExists(String input) {
        for (Customer customer : customers) {
            if (input.equalsIgnoreCase(customer.getName()) || input.equals(customer.getPersonalNumber())) {
                return customer;
            }
        }
        return null;
    }

     void getCustomerInfo() {
        while (true) {
            String input = Output.inputCustomer();
            if (input==null) {
                writeLogToFile();
                break;
            }
            Customer customer = customerExists(input.trim());
            if (customer != null) {
                if (customer.membershipIsValid(customer)) {
                    Output.validCustomer(customer.getName(), customer.getPayDate());
                    visitLog.addToLog(customer);
                } else {
                    Output.inValidCustomer(customer.getName(), customer.getPayDate());
                }
            } else {
                Output.notCustomer(input);
            }
        }
    }
     private void writeLogToFile() {
        String fileName = "Visitlog.txt";
        String logFile = visitLog.getLogFromFile(fileName) + "\n" + visitLog.getTodaysLog();

        try (PrintWriter writer = new PrintWriter
                (new BufferedWriter
                        (new FileWriter(fileName)))) {

            writer.println(logFile);

        } catch(IOException e) {
            Output.errorWriteFile(fileName);
        }
    }
}
