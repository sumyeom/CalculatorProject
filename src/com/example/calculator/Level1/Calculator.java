package com.example.calculator.Level1;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        /* Procedure*/
        Scanner scanner = new Scanner(System.in);
        double answer = 0;

        while(true) {
            // 첫번째 숫자 입력
            System.out.println("첫번째 숫자를 입력하세요");
            String firstString = scanner.nextLine();
            double firstNumber = Double.parseDouble(firstString);

            // 두번째 숫자 입력
            System.out.println("두번째 숫자를 입력하세요");
            String secondString = scanner.nextLine();
            double secondNumber = Double.parseDouble(secondString);

            // 연산자 입력
            System.out.println("원하시는 사칙 연산을 입력하세요");
            String operator = scanner.nextLine();
            char charOperator = operator.charAt(0);

            // 계산 수행
            answer = Operation(firstNumber, secondNumber,charOperator);
            System.out.println("결과 : " + answer);

            System.out.println("계산을 더 할까요?(아무거나 클릭 시 계속 수행 / exit 입력 시 종료)");
            String exitString = scanner.nextLine();
            if(exitString.equals("exit")){
                break;
            }
        }
    }

    public static double Operation(double firstNumber, double secondNumber, char operator){
        double operationAnswer = 0;
        switch (operator) {
            case '+' :
                operationAnswer = firstNumber + secondNumber;
                break;
            case '-' :
                operationAnswer = firstNumber - secondNumber;
                break;
            case '*' :
                operationAnswer = firstNumber * secondNumber;
                break;
            case '/' :
                if(secondNumber == 0){
                    System.out.println("나눗셈 분모가 0입니다.");
                }else {
                    operationAnswer = firstNumber / secondNumber;
                }
                break;
            default :
        }
        return operationAnswer;
    }
}
