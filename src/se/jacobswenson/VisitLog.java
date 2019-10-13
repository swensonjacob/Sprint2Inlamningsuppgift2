package se.jacobswenson;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 class VisitLog {

    private LocalDate date;
    private List<Visit> visits;

     VisitLog() {
        this.date = LocalDate.now();
        visits = new ArrayList<>();
    }

     boolean addToLog(Customer customer) {
        return visits.add(new Visit(customer));
    }

     String getTodaysLog() {
        StringBuilder visitLog = new StringBuilder(this.date.toString() +
                "\n-------------------------------------");
        for (Visit visit : visits) {
            visitLog.append("\nkl: ").append(visit.getTime()).append(" - ").append(visit.getCustomer().getName()).append(" ").append(visit.getCustomer().getPersonalNumber());
        }
        return visitLog.toString();
    }

     String getLogFromFile(String fileName) {
        StringBuilder visitLog = new StringBuilder();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
            visitLog.append(scanner.nextLine()).append("\n");
            }
        } catch (IOException e) {
            Output.errorReadFile(fileName);
        }
        return visitLog.toString();
    }
}