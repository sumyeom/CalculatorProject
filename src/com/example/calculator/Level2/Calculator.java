package com.example.calculator.Level2;

import java.util.ArrayList;

public class Calculator {
    ArrayList<Integer> resultList = new ArrayList<>();

    public ArrayList<Integer> getResultList(){
        return this.resultList;
    }

    public void setResultList(int result){
        this.resultList.add(result);
    }
    public int calOperation(int firstNumber, int secondNumber, String operator){
        int result = 0;
        switch(operator){
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if(secondNumber == 0){
                    throw new ArithmeticException("나누기 값이 0입니다.");
                }
                result = firstNumber / secondNumber;
                break;
            default:
        }
        return result;
    }

    public void removeResult(){
        this.resultList.remove(0);
    }
}
