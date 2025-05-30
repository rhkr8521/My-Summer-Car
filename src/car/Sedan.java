package car;

public class Sedan extends Car implements AirCon, Music {

    public static final int SPEED = 200; // km/h
    public static final int FUEL_CONSUMPTION = 12 ; // km/L
    public static final int FUEL_CAPACITY = 45; // L
    public static final int SEAT_COUNT = 4; // 인
    public static final int TRUCK_SEAT_COUNT = 1; // 인

    private boolean isOption = false;


    public Sedan(String name) {
        super(SPEED, FUEL_CONSUMPTION, FUEL_CAPACITY, SEAT_COUNT, name);
    }

    @Override
    void setMode(boolean isOn) {
        isOption = isOn;
        if(isOption) {
            transformTrunk();
        }

        airConSpeak(isOption);
        musicSpeak(isOption);
    }

    void transformTrunk() {
        seatCount += TRUCK_SEAT_COUNT;
    }

    @Override
    public void airConSpeak(boolean isOn) {
        System.out.println(name + " : 에어컨 " + (isOn ? "ON" : "OFF"));
    }

    @Override
    public void musicSpeak(boolean isOn) {
        System.out.println(name + " : 오디오 " + (isOn ? "ON" : "OFF"));
    }

    public void showOption() {
        airConSpeak(isOption);
        musicSpeak(isOption);
    }

}