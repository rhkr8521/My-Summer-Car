package car;

import java.util.Scanner;
import javax.swing.plaf.synth.SynthTextAreaUI;

public class Main {

    public static void main(String[] args) {

        int[] distances = {0, 400, 150, 200, 300};

        Scanner scanner = new Scanner(System.in);
        System.out.print("이동 지역 선택 [1]부산 [2]대전 [3]강릉 [4]광주 : ");
        int localType = scanner.nextInt();
        if (localType < 1 || localType > 4) {
            System.out.println("잘못된 지역 번호 입력");
            return;
        }

        System.out.print("이동할 승객 수 입력 : ");
        int passengerCount = scanner.nextInt();
        if (passengerCount <= 0) {
            System.out.println("잘못된 승객 수 입력");
            return;
        }

        System.out.print("이동할 차량 선택 [1]스포츠카 [2]승용차 [3]버스 : ");
        int carType = scanner.nextInt();
        if (carType < 1 || carType > 3) {
            System.out.println("잘못된 차량 선택");
            return;
        }

        System.out.print("부가 기능 [1]ON [2]OFF : ");
        int isOption = scanner.nextInt();
        if (isOption < 1 || isOption > 2) {
            System.out.println("잘못된 차량 선택");
            return;
        }

        System.out.print("날씨 [1]맑음 [2]비 [3]눈 : ");
        int weatherType = scanner.nextInt();
        if (weatherType < 1 || weatherType > 3) {
            System.out.println("잘못된 날씨 선택");
            return;
        }

        System.out.print("\n");

        Car car = null;

        switch (carType) {
            case 1:
                car = new SportsCar("포르쉐 711");
                break;
            case 2:
                car = new Sedan("BMW 7");
                break;
            case 3:
                car = new Bus("대형버스");
                break;
        }

        car.setMode(isOption == 1);

        int distance = distances[localType];
        int totalSeconds = car.totalMoveTime(distance, passengerCount, weatherType);
        int hours   = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;

        System.out.println("=".repeat(7) + car.name + "=".repeat(7));
        System.out.printf("총 비용 : %,d원%n", car.totalCost(distance, passengerCount));
        System.out.printf("총 주유 횟수 : %d회%n", car.fuelCount(distance, passengerCount));
        System.out.printf("총 이동 시간 : %d시간 %d분%n", hours, minutes);

    }

}