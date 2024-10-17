package com.example.calculator.Level3;

import java.awt.image.BaseMultiResolutionImage;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CalculatorApp {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ArithmeticCalculator<Number> arithmeticCalculator = new ArithmeticCalculator<>();
        boolean flag = false;
        System.out.println("[[[[[계산기에 오신걸 환영합니다*^^*]]]]]");
        while (true) {
            if (flag) break;
            System.out.println("원하시는 동작을 숫자로 입력하세요.");
            System.out.println("1. 계산하기 | 2. 이전 계산 결과 확인 | 3. 삭제하기 | 4. 입력한 값보다 큰 값 확인 | 5. 종료하기(exit 입력 가능)");
            String command = scanner.nextLine();
            switch (command) {
                case "1" -> {
                    System.out.println("**계산 시작**");

                    System.out.println("첫번째 숫자를 입력하세요");
                    String firstString = scanner.nextLine();
                    System.out.println("두번째 숫자를 입력하세요");
                    String secondString = scanner.nextLine();

                    Number result = 0;
                    Number firstNumber = 0;
                    Number secondNumber = 0;
                    boolean doubleFlag = false;
                    // Double 형식
                    if (firstString.contains(".") || secondString.contains(".")) {
                        try {
                            firstNumber = Double.parseDouble(firstString);
                            secondNumber = Double.parseDouble(secondString);
                            doubleFlag = true;
                        } catch (NumberFormatException e) {
                            System.out.println("올바른 숫자 형식이 아닙니다. 정수나 실수로 입력하세요.");
                            System.out.println("------------------------------------------------------");
                            break;
                        }
                    }
                    // Integer 형식
                    else {
                        try {
                            firstNumber = Integer.parseInt(firstString);
                            secondNumber = Integer.parseInt(secondString);
                        } catch (NumberFormatException e) {
                            System.out.println("올바른 숫자 형식이 아닙니다. 정수나 실수로 입력하세요.");
                            System.out.println("------------------------------------------------------");
                            break;
                        }
                    }
                    System.out.println("원하시는 사칙 연산을 입력하세요");
                    String operator = scanner.nextLine();

                    // 올바른 연산자(+, -, *, /) 형식인지 확인
                    ParseOperator parseOperator = (po) ->{
                        final String OPERATION_REQ = "[+\\-*/]";

                        boolean regex = Pattern.matches(OPERATION_REQ, operator);
                        if (!regex) {
                            throw new NumberFormatException("+, -, *, /");
                        }
                    };
                    try {
                        parseOperator.parse(operator);
                    } catch (NumberFormatException e) {
                        System.out.println("올바른 연산자 형식이 아닙니다. " + e.getMessage() + "로 입력하세요.");
                        System.out.println("------------------------------------------------------");
                        break;
                    }

                    // Double 형식이면 result에 Double 형식으로
                    // Integer 형식이면 result 에 Integer 형식으로 저장
                    try {
                        if(doubleFlag) result = (double) arithmeticCalculator.CalOperation(firstNumber, secondNumber, operator);
                        else result = (int)arithmeticCalculator.CalOperation(firstNumber, secondNumber, operator);
                        arithmeticCalculator.setResultList(result);
                    } catch (ArithmeticException e) {
                        System.out.println("나누기 값이 0입니다.");
                        System.out.println("------------------------------------------------------");
                        break;
                    }

                    System.out.println("계산 결과 : " + result);
                    System.out.println("------------------------------------------------------");
                }
                case "2" -> {
                    // 이전에 저장된 계산 결과들 확인
                    System.out.println("결과 확인 : " + arithmeticCalculator.getResultList());
                    System.out.println("------------------------------------------------------");
                }
                case "3" -> {
                    arithmeticCalculator.removeResult();
                    System.out.println("첫번째 계산 결과가 삭제되었습니다.");
                    System.out.println("결과 확인 : " + arithmeticCalculator.getResultList());
                    System.out.println("------------------------------------------------------");
                }
                case "4" -> {
                    // 입력한 값보다 큰 이전 결과 리스트 출력
                    System.out.println("값을 입력해주세요");
                    String compareStr = scanner.nextLine();
                    double temp = Double.parseDouble(compareStr);

                    ArrayList<Double> searchResult = new ArrayList<>();

                    arithmeticCalculator.getResultList().stream().filter(p -> p.doubleValue() > temp).forEach(f -> searchResult.add(f.doubleValue()));

                    System.out.println("결과 확인 : " + searchResult);
                    System.out.println("------------------------------------------------------");
                }
                case "5", "exit" ->{
                    flag = true;
                }
                default -> {
                    System.out.println("원하시는 동작이 존재하지 않습니다. 다시 입력해주세요.");
                    System.out.println("------------------------------------------------------");
                }
            }
        }
    }

    public static void parseOperandInteger(String strParse) throws Exception {
        final String NUMBER_REQ = "^[0-9]*$";

        boolean regex = Pattern.matches(NUMBER_REQ, strParse);
        if (!regex) {
            throw new NumberFormatException("정수");
        }
    }

    public static void parseOperator(String strParse) throws Exception {
        final String OPERATION_REQ = "[+\\-*/]";

        boolean regex = Pattern.matches(OPERATION_REQ, strParse);
        if (!regex) {
            throw new NumberFormatException("+, -, *, /");
        }
    }

    // 연산자 확인 함수형 인터페이스
    interface ParseOperator{
        void parse(String operator) throws NumberFormatException;
    }
}


