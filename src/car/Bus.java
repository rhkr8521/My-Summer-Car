package car;

public class Bus extends Car implements AirCon, AutoDrive {

    public Bus(String name) {
        super(150, 5, 100, 20, name); // speed, fuelEfficiency, fuelCapacity, seatCount, name
    }

    @Override
    public void setMode(boolean isOn) {
        if (isOn) {
            this.fuelCapacity += 30; // 보조 연료탱크 추가
        }

        airConSpeak(isOn);
        autoDriveSpeak(isOn);
    }

    @Override
    public void airConSpeak(boolean isOn) {
        System.out.println(name + ": 에어컨 " + (isOn ? "ON" : "OFF"));
    }

    @Override
    public void autoDriveSpeak(boolean isOn) {
        System.out.println(name + ": 자율주행 " + (isOn ? "ON" : "OFF"));
    }
}
