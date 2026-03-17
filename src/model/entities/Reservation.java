package model.entities;

import model.exceptions.DomainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reservation {
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Integer roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Reservation() {
    }

    public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
        if (checkOut.isBefore(checkIn)) {
            throw new DomainException("a data de check-out deve ser posterior à data de check-in.");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public long duration() {
        return ChronoUnit.DAYS.between(checkIn, checkOut);
    }

    public void updateDates(LocalDate checkIn, LocalDate checkOut) {
        LocalDate now = LocalDate.now();

        if (checkIn.isBefore(now) ||  checkOut.isBefore(now)) {
            throw new DomainException("as datas da reserva para atualização devem ser datas futuras.");
        }

        if (checkOut.isBefore(checkIn)) {
            throw new DomainException("a data de check-out deve ser posterior à data de check-in.");
        }

        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Reserva: Quarto Nº "
                + roomNumber
                + ", data de entrada: "
                + checkIn.format(dtf)
                + ", data de saída: "
                + checkOut.format(dtf)
                + ", "
                + duration()
                + " noites.";
    }
}
