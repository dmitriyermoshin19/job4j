package ru.job4j.oo4.lsp.parkovka;

/**
 * Interface for different types of Parking lots
 */
public interface ParkingLots {
    boolean toPark(Car car) throws Exception;
    Car toLeaveParking(int carNumber);
}
