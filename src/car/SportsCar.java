package car;

public class SportsCar extends Car implements Music, AutoDrive{

    private final int baseSpeed;

    public SportsCar(String name) {
        super(
                250, // 속도: 250km/h
                8, // 연비: 8km/L
                30, // 연료탱크: 30L
                2, // 좌석: 2
                name // name: 생성자 입력
        );
        
        this.baseSpeed = 250;
    }

    @Override
    public void setMode(boolean isOn) {
        if (isOn) {
            this.speed = (int) (baseSpeed * 1.2);
        }else{
            this.speed = baseSpeed;
        }

        musicSpeak(isOn);
        autoDriveSpeak(isOn);
    }

    @Override
    public void musicSpeak(boolean isOn) {
        String status = isOn ? "ON" : "OFF";
        System.out.println(name + ": 오디오 " + status);
    }

    @Override
    public void autoDriveSpeak(boolean isOn) {
        String status = isOn ? "ON" : "OFF";
        System.out.println(name + ": 자율주행 " + status);
    }

}
