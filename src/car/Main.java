package car;

import java.util.Scanner;
import javax.swing.plaf.synth.SynthTextAreaUI;

public class Main {

    public static void main(String[] args) {

        int[] distances = {0, 400, 150, 200, 300};

        Scanner scanner = new Scanner(System.in);
        System.out.print("이동 지역 선택 [1]부산 [2]대전 [3]강릉 [4]광주 : ");
        int localType = scanner.nextInt();
        System.out.print("이동할 승객 수 입력 : ");
        int passengerCount = scanner.nextInt();
        System.out.print("이동할 차량 선택 [1]스포츠카 [2]승용차 [3]버스 : ");
        int carType = scanner.nextInt();
        System.out.print("부가 기능 [1]ON [2]OFF : ");
        int isOption = scanner.nextInt();
        System.out.print("날씨 [1]맑음 [2]비 [3]눈 : ");
        int weatherType = scanner.nextInt();

//        TODO 오류 처리 필요

        Car car = null;

        switch (carType) {
            case 1:
//                car = new SportsCar();
                break;
            case 2:
                car = new Sedan();
                break;
            case 3:
//                car = new Bus();
                break;
        }

        car.setMode(isOption == 1);

        int distance = distances[localType];
        int totalMinute = car.totalMoveTime(distance, passengerCount, weatherType);

        System.out.println(
            "=".repeat(7) + car.name + "=".repeat(7) + '\n'
                + "총 비용 : " + car.totalCost(distance, passengerCount) + "원\n"
                + "총 주유 횟수 : " + car.fuelCount(distance, passengerCount) + "회\n"
                + "총 이동 시간 : " + totalMinute/60 + "시간 " + totalMinute%60 + "분"
        );


    }

}