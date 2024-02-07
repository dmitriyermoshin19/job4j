package ru.job4j.oo4.lsp.parkovka;

import java.util.HashMap;
import java.util.Map;

public class SimpleParking implements ParkingLots {
    private final Map<Integer, Car> carList = new HashMap<>();
    private int bigCount;
    private int smallCount;

    /**
     * Constructor
     * @param bigCount - count of places for trucks
     * @param smallCount - count of places for passenger cars
     */
    public SimpleParking(int bigCount, int smallCount) {
        this.bigCount = bigCount;
        this.smallCount = smallCount;
    }

    public Map<Integer, Car> getCarList() {
        return carList;
    }

    @Override
    public boolean toPark(Car car) throws Exception {
        boolean rst = false;
        if (car.getSize() <= 100 && smallCount > 0) {
            smallCount -= 1;
            rst = true;
        } else if (car.getSize() <= 100 && smallCount == 0) {
            throw new Exception("There are no places for passenger cars");
        }

        if (car.getSize() > 100 && bigCount > 0) {
            bigCount -= 1;
            rst = true;
        } else if (car.getSize() > 100 && bigCount == 0 && smallCount >= 2) {
            smallCount -= 2;
            rst = true;
        } else if (car.getSize() > 100 && bigCount == 0 && smallCount < 2) {
            throw new Exception("There are no places for trucks");
        }
        carList.put(car.getNumber(), car);
        return rst;
    }

    @Override
    public Car toLeaveParking(int carNumber) {
        Car car = carList.get(carNumber);
        carList.remove(carNumber);
        return car;
    }
}
