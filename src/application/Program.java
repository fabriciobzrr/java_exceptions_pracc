package application;

import model.entities.Reservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        IO.print("Número do quarto: ");
        int number = sc.nextInt();
        IO.print("Data de Entrada: ");
        LocalDate checkIn = LocalDate.parse(sc.next(), dtf);
        IO.print("Data de Saída: ");
        LocalDate checkOut = LocalDate.parse(sc.next(), dtf);

        if (checkOut.isBefore(checkIn)) {
            IO.println("Erro na reserva: a data de check-out deve ser posterior à data de check-in.");
        } else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            IO.println(reservation);
            IO.println();
            IO.println("Digite a data para atualizar a reserva: ");
            IO.print("Data de Entrada: ");
            checkIn = LocalDate.parse(sc.next(), dtf);
            IO.print("Data de Saída: ");
            checkOut = LocalDate.parse(sc.next(), dtf);
            LocalDate now = LocalDate.now();
            if (checkIn.isBefore(now) ||  checkOut.isBefore(now)) {
                IO.print("Erro na reserva: as datas da reserva para atualização devem ser datas futuras.");
            } else if (checkOut.isBefore(checkIn)) {
                IO.println("Erro na reserva: a data de check-out deve ser posterior à data de check-in.");
            } else {
                reservation.updateDates(checkIn, checkOut);
                IO.println(reservation);
            }

        }


        sc.close();
    }
}
