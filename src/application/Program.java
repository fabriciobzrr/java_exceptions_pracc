package application;

import model.entities.Reservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Program {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data1 = LocalDate.parse("15/03/2026", dtf);
        LocalDate data2 = LocalDate.parse("30/03/2026", dtf);

        Reservation r = new Reservation(100, data1, data2);
        IO.println(r);
    }
}
