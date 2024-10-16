package com.example.calculator.Level3;

public enum OperatorType {
    ADD("+"),
    SUB("-"),
    MUL("*"),
    DIV("/");

    private final String type;

    OperatorType(String c) {
        this.type  = c;
    }

    public String getType() {
        return this.type;
    }

    public static OperatorType operatorString(String param) {
        for (OperatorType operator : OperatorType.values()){
            if(operator.getType().equals(param)){
                return operator;
            }
        }
        throw new IllegalArgumentException("연산자가 잘못되었습니다. -->" + param);
    }
}