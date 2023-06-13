// 0~ 9사이의 서로 다른 숫자 무작위
// 사용자가 세자리 입력
// 스트라이크 : 숫자의 값과 위치가 모두 일치
// 볼 : 숫자만 일치
// 기회 무제한, 시도 횟수
// 숫자 세개 맞추면 종료

import java.util.Scanner;

public class Game {
    private static final int RANDOM_NUMBER_LENGTH = 3;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String randomNumber = createRandomNumber();
        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");
        int count = 1;

        while (true) {

            System.out.print(count + "번째 시도 : ");
            String inputNumber = input.nextLine();

            int[] result = getResult(inputNumber, randomNumber);
            String resultStr = createStringStr(result);

            if (result[0] == 3) {
                System.out.println(resultStr);
                System.out.println(count +"번만에 맞히셨습니다.");
                System.out.println("게임을 종료합니다");
                break;
            }
            System.out.println(resultStr);
            count++;
        }
    }

    private static String createStringStr(int[] result){
        String resultStr = null;
        if (result[0] == 0 && result[1]> 0 ){
            resultStr = result[1] + "B";
        } else if (result[0] > 0 && result[1] == 0){
            resultStr = result[0] + "S";
        } else {
            resultStr = result[1] + "B"+result[0] + "S";
        }
        return resultStr;
    }

    private static String createRandomNumber () {

        StringBuilder randomNumber = new StringBuilder();

        for (int i = 0; i < RANDOM_NUMBER_LENGTH; i++) {
            int randomNum = (int)(Math.random() * 10);

            if(randomNumber.indexOf(String.valueOf(randomNum)) < 0 ){
                randomNumber.append(randomNum);
            } else {
                i--;
            }
        }
        return randomNumber.toString();
    }

    private static int[] getResult (String inputNumber, String randomNumber) {

        int[] result = new int[2];
        int strike = 0;
        int ball = 0;

       for (int i = 0; i < RANDOM_NUMBER_LENGTH; i++) {
           if (inputNumber.charAt(i) == randomNumber.charAt(i)) {
               strike++;
           } else {
               if (randomNumber.indexOf(inputNumber.charAt(i)) >= 0) {
                   ball++;
               }
           }
       }
       result[0] = strike;
       result[1] = ball;

       return result;
    }
}
