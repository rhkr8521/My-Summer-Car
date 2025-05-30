package car;

import static java.lang.Math.ceil;

public abstract class Car {

    int speed;
    int fuelEfficiency;
    int fuelCapacity;
    int seatCount;
    String name;

    public Car(int speed, int fuelEfficiency, int fuelCapacity, int seatCount, String name) {
        this.speed = speed;
        this.fuelEfficiency = fuelEfficiency;
        this.fuelCapacity = fuelCapacity;
        this.seatCount = seatCount;
        this.name = name;
    }

    // 총 이동 횟수
    public int moveCount(int passengerCount) {
        return (int) Math.ceil((double) passengerCount / seatCount);
    }

    // 총 연료 소모량
    private double totalFuelConsumption(int distance, int passengerCount){
        int totalDistance = distance * moveCount(passengerCount);
        return (double) totalDistance / fuelEfficiency;
    }

    // 총 주유 횟수
    public int fuelCount(int distance, int passengerCount){
        return (int) ceil(totalFuelConsumption(distance, passengerCount) / fuelCapacity);
    }

    // 총 비용
    public int totalCost(int distance, int passengerCount){
        return (int) totalFuelConsumption(distance, passengerCount) * 2000;
    }

    // 총 이동 시간 (초로 반환)
    public int totalMoveTime(int distance, int passengerCount, int weatherType){

        double weatherSpeed = 0.0;

        switch(weatherType){
            case 1: weatherSpeed = 1.0; break;
            case 2: weatherSpeed = 1.2; break;
            case 3: weatherSpeed = 1.4; break;
            default : break;
        }

        return (int) ((double) distance / speed * moveCount(passengerCount) * weatherSpeed) * 3600;
    }

    abstract void setMode(boolean isOn);

}
