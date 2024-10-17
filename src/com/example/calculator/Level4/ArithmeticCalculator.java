package com.example.calculator.Level4;

import java.util.ArrayList;
import java.util.Stack;

public class ArithmeticCalculator<T extends Number>{
    private ArrayList<T> resultList = new ArrayList<>();

    /*Getter*/
    public ArrayList<T> getResultList(){
        return this.resultList;
    }
    /*Setter*/
    public void setResultList(T result){
        this.resultList.add(result);
    }
    /*Method*/
    public double CalOperation(T firstNumber, T secondNumber, String operator){
        // 전달받은 operator로 Enum 값 확인
        OperatorType operatorType = OperatorType.OperatorString(operator);
        switch(operatorType){
            case ADD:
                return firstNumber.doubleValue() + secondNumber.doubleValue();
            case SUB:
                return firstNumber.doubleValue() - secondNumber.doubleValue();
            case MUL:
                return firstNumber.doubleValue() * secondNumber.doubleValue();
            case DIV:
                if(secondNumber.doubleValue() == 0){
                    throw new ArithmeticException("나누기 값이 0입니다.");
                }
                return firstNumber.doubleValue() / secondNumber.doubleValue();
            default:
                throw new IllegalArgumentException("잘못된 연산자 입니다");
        }
    }
    public double ExpOperation(String[] expressionStack){
        Stack<Double> stackDouble = new Stack<Double>();
        for(String str : expressionStack){
            try{
                double num = Double.parseDouble(str);
                stackDouble.push(num);
            }catch(NumberFormatException e){
                double firstNumber = stackDouble.pop();
                double secondNumber = stackDouble.pop();

                OperatorType operatorType = OperatorType.OperatorString(str);
                switch(operatorType){
                    case ADD:
                        stackDouble.push(secondNumber + firstNumber);
                        break;
                    case SUB:
                        stackDouble.push(secondNumber - firstNumber);
                        break;
                    case MUL:
                        stackDouble.push(secondNumber * firstNumber);
                        break;
                    case DIV:
                        if(firstNumber == 0){
                            throw new ArithmeticException("나누기 값이 0입니다.");
                        }
                        stackDouble.push(secondNumber / firstNumber);
                        break;
                    default:
                        throw new IllegalArgumentException("잘못된 연산자 입니다");
                }
            }
        }
        return stackDouble.pop();
    }
    public void removeResult(){
        this.resultList.remove(0);
    }
}
