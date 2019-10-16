package se.jacobswenson;

import java.io.*;

class Gym {

    private static String registerFileName = "temp.txt";
    private static String logFileName = "Visitlog.txt";

    private Register register;
    private VisitLog visitLog;

    /**
     * Konstruktor som skapar en instans av VisitLog samt Register med filnamnet för inläsning av fil som invärde.
     * Registers konstruktor throws IOexception som hanteras här.
     */
    Gym() {
        this.visitLog = new VisitLog();
        try {
            register = new Register(registerFileName);
        } catch (IOException e) {
            Output.errorReadFile(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * Returnerar Customer om användarens input stämmer överens med kundernas namn eller personummer inlästa från fil
     * till Register.
     */
    Customer customerExists(String input) {
        for (Customer customer : register.getCustomers()) {
            if (input.equalsIgnoreCase(customer.getName()) || input.equals(customer.getPersonalNumber())) {
                return customer;
            }
        }
        return null;
    }

    /**
     * inhämtar input från använaren genom Output.inputCustomer()
     * om användaren trycker avbryt eller stänger fönstret skrivs loggen ut och programmet avslutas
     * input stäms av om namnet eller personnumret tillhör en kund genom customerExists()
     * återfinns kunden skrivs det ut och blir tillagd i loggen annars felmeddelande
     */
    void getCustomerInfo() {
        while (true) {
            String input = Output.inputCustomer();
            if (input == null) {
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

    /**
     * Hämtar befintlig loggfil och skriver ut dagens logg till filen. getLogFromFile throws IOexception som hanteras här.
     * -try with resources
     */
    private void writeLogToFile() {
        String fileName = logFileName;
        try {
        String logFile = visitLog.getLogFromFile(fileName) + "\n" + visitLog.getTodaysLog();
        try (PrintWriter writer = new PrintWriter
                (new BufferedWriter
                        (new FileWriter(fileName)))) {

            writer.println(logFile);
        } catch(IOException e) {
            Output.errorWriteFile(fileName);
        }
        } catch (IOException e) {
            Output.errorReadFile(e.getMessage());
        }
}
}
