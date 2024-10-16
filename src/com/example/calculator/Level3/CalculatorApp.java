package com.example.calculator.Level3;

import java.awt.image.BaseMultiResolutionImage;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CalculatorApp {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ArithmeticCalculator<Number> arithmeticCalculator = new ArithmeticCalculator<>();
        boolean flag = false;
        while (true) {
            if (flag) break;
            System.out.println("원하시는 동작을 숫자로 입력하세요.");
            System.out.println("1. 계산하기 | 2. 이전 계산 결과 확인 | 3. 삭제하기 | 4. 종료하기");
            String command = scanner.nextLine();
            switch (command) {
                case "1" -> {
                    System.out.println("**계산 시작**");

                    boolean parseFlag = false;

                    System.out.println("첫번째 숫자를 입력하세요");
                    String firstString = scanner.nextLine();
                    System.out.println("두번째 숫자를 입력하세요");
                    String secondString = scanner.nextLine();

                    double result = 0;
                    Number firstNumber = 0;
                    Number secondNumber = 0;

                    // Double 형식
                    if (firstString.contains(".") || secondString.contains(".")) {
                        try {
                            firstNumber = Double.parseDouble(firstString);
                            secondNumber = Double.parseDouble(secondString);
                        } catch (NumberFormatException e) {
                            System.out.println("올바른 숫자 형식이 아닙니다. 정수나 실수로 입력하세요.");
                            System.out.println("------------------------------------------------------");
                            break;
                        }

                    } else {
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
                    try {
                        parseOperator(operator);
                    } catch (NumberFormatException e) {
                        System.out.println("올바른 연산자 형식이 아닙니다. " + e.getMessage() + "로 입력하세요.");
                        System.out.println("------------------------------------------------------");
                        break;
                    }

                    try {
                        result = arithmeticCalculator.calOperation(firstNumber, secondNumber, operator);
                        arithmeticCalculator.setResultList(result);
                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                        break;
                    }

                    System.out.println("계산 결과 : " + result);
                }
                case "2" -> {
                    System.out.println("결과 확인 : " + arithmeticCalculator.getResultList());
                }
                case "3" -> {
                    arithmeticCalculator.removeResult();
                    System.out.println("첫번째 계산 결과가 삭제되었습니다.");
                    System.out.println("결과 확인 : " + arithmeticCalculator.getResultList());
                }
                case "4" -> {
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
}


