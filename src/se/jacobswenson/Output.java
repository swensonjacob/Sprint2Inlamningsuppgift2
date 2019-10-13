package se.jacobswenson;

import javax.swing.*;

 class Output {

    static String inputCustomer() {
        return JOptionPane.showInputDialog(null, "Ange namn eller personnummer","Best Gym Ever",JOptionPane.QUESTION_MESSAGE);
    }

    static void validCustomer(String name, String date) {
        JOptionPane.showMessageDialog(null, name + " har ett giltigt medlemskap" +
                "\nSenaste inbetalningen gjordes: " + date);
    }

     static void inValidCustomer(String name, String date) {
        JOptionPane.showMessageDialog(null, name + " har inte ett giltigt medlemskap" +
                "\nSenaste inbetalningen gjordes: " + date);
    }

     static void notCustomer(String input) {
        JOptionPane.showMessageDialog(null, "\"" + input + "\"" + " är inte kund");
    }
     static void errorReadFile(String fileName) {
        JOptionPane.showMessageDialog(null, "Fel vid inläsning av fil: " + fileName,"Error",JOptionPane.ERROR_MESSAGE);
    }
     static void errorWriteFile(String fileName) {
        JOptionPane.showMessageDialog(null, "Fel vid nedsparande av fil: " + fileName,"Error",JOptionPane.ERROR_MESSAGE);
    }
}