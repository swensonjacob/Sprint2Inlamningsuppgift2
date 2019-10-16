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

    public List<Visit> getVisits() {
        return visits;
    }

    /**
     * Lägger till Visit för ingeånde Customer i listan visits
     */
    void addToLog(Customer customer) {
        visits.add(new Visit(customer));
    }

    /**
     Skapar en logg för utskrift från listan visits genom StringBuilder
     */
    String getTodaysLog() {
        StringBuilder visitLog = new StringBuilder(this.date.toString() +
                "\n-------------------------------------");
        for (Visit visit : visits) {
            visitLog.append("\nkl: ").append(visit.getTimeToString()).append(" - ").append(visit.getCustomer().getName()).append(" ").append(visit.getCustomer().getPersonalNumber());
        }
        return visitLog.toString();
    }

    /**
     * Hämtar och skapar logfilen från fil genom StringBuilder och returnerar loggen.
     */
    String getLogFromFile(String fileName) throws IOException {
        StringBuilder visitLog = new StringBuilder();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                visitLog.append(scanner.nextLine()).append("\n");
            }
        }
        return visitLog.toString();
    }
}