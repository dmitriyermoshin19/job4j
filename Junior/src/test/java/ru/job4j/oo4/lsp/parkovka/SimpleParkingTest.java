package ru.job4j.oo4.lsp.parkovka;

import org.junit.Test;
import java.util.Map;
import static org.junit.Assert.*;

public class SimpleParkingTest {

    @Test
    public void whenToPark() throws Exception {
        SimpleParking parking = new SimpleParking(5, 10);
        CarSmall carSmall = new CarSmall(100, 555);
        boolean carToPark = parking.toPark(carSmall);
        Map<Integer, Car> list = parking.getCarList();
        boolean carInList = list.containsKey(carSmall.getNumber());
        assertEquals(carToPark, carInList);
    }

    @Test
    public void whenToLeaveParking() throws Exception {
        SimpleParking parking = new SimpleParking(5, 10);
        CarSmall carSmall = new CarSmall(100, 555);
        CarSmall carSmall1 = new CarSmall(100, 111);
        parking.toPark(carSmall);
        parking.toPark(carSmall1);
        Car car = parking.toLeaveParking(carSmall.getNumber());
        Map<Integer, Car> list = parking.getCarList();
        boolean carInList = list.containsKey(car.getNumber());
        assertFalse(carInList);
    }

    @Test
    public void whenParking5Big10Small() throws Exception {
        CarSmall car1 = new CarSmall(100, 555);
        CarSmall car2 = new CarSmall(100, 111);
        CarSmall car3 = new CarSmall(100, 222);
        CarBig carBig1 = new CarBig(200, 333);
        CarBig carBig2 = new CarBig(200, 444);
        CarBig carBig3 = new CarBig(200, 777);
        SimpleParking parking = new SimpleParking(2, 5);
        parking.toPark(car1);
        parking.toPark(car2);
        parking.toPark(car3);
        parking.toPark(carBig1);
        parking.toPark(carBig2);
        boolean carToPark = parking.toPark(carBig3);
        Map<Integer, Car> list = parking.getCarList();
        boolean carInList = list.containsKey(carBig3.getNumber());
        assertEquals(carToPark, carInList);
    }
}
