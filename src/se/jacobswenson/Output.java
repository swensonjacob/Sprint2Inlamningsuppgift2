package se.jacobswenson;

import javax.swing.*;

 class Output {

     /**
      * Inhämtar namn eller personnummer från användaren
      */
     static String inputCustomer() {
         return JOptionPane.showInputDialog(null, "Ange namn eller personnummer","Best Gym Ever",JOptionPane.QUESTION_MESSAGE);
     }

     /**
      * Meddelande vid kund med giltigt medlemskap
      */
    static void validCustomer(String name, String date) {
        JOptionPane.showMessageDialog(null, name + " har ett giltigt medlemskap" +
                "\nSenaste inbetalningen gjordes: " + date);
    }

     /**
      * Meddelande vid kund som saknar giltigt medlemskap
      */
     static void inValidCustomer(String name, String date) {
        JOptionPane.showMessageDialog(null, name + " har inte ett giltigt medlemskap" +
                "\nSenaste inbetalningen gjordes: " + date);
    }

     /**
      * Meddelande vid person som ej är kund
      */
     static void notCustomer(String input) {
        JOptionPane.showMessageDialog(null, "\"" + input + "\"" + " är inte kund");
    }

     /**
      * Felmeddelande vid felaktig inläsning av fil
      */
     static void errorReadFile(String fileName) {
         JOptionPane.showMessageDialog(null, "Fel vid nedsparande av fil" +
                 "\nFelmeddelande: " + fileName, "Error", JOptionPane.ERROR_MESSAGE);
     }

     /**
      * Felmeddelande vid felaktig skrivning till fil
      */
     static void errorWriteFile(String fileName) {
         JOptionPane.showMessageDialog(null, "Fel vid nedsparande av fil: " + fileName,"Error",JOptionPane.ERROR_MESSAGE);
     }
}