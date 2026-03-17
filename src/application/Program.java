package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        try {
            IO.print("Número do quarto: ");
            int number = sc.nextInt();
            IO.print("Data de Entrada: ");
            LocalDate checkIn = LocalDate.parse(sc.next(), dtf);
            IO.print("Data de Saída: ");
            LocalDate checkOut = LocalDate.parse(sc.next(), dtf);

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            IO.println(reservation);

            IO.println();
            IO.println("Digite a data para atualizar a reserva: ");
            IO.print("Data de Entrada: ");
            checkIn = LocalDate.parse(sc.next(), dtf);
            IO.print("Data de Saída: ");
            checkOut = LocalDate.parse(sc.next(), dtf);

            reservation.updateDates(checkIn, checkOut);
            IO.println(reservation);
        } catch (DomainException e) {
            IO.println("Erro na reserva: " + e.getMessage());
        } catch (RuntimeException e) {
            IO.println("Erro inesperado!");
        }

        sc.close();
    }
}
