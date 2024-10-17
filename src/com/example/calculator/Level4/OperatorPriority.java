package com.example.calculator.Level4;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum OperatorPriority {
    PARAN(0, Arrays.asList("(")),
    ADD_SUB(1, Arrays.asList("+","-")),
    MUL_DIV(2, Arrays.asList("*", "/"));

    private int priority;
    private List<String> prioList;

    OperatorPriority(int priority, List<String> prioList){
        this.priority = priority;
        this.prioList = prioList;
    }

    public int getPriority(){
        return this.priority;
    }

    final static OperatorPriority findPriority(String operator) {
        // 해당 연산자가 포함된 우선순위를 찾음
        for (OperatorPriority priority : OperatorPriority.values()) {
            // 각 우선순위 그룹에 해당 연산자가 포함되어 있는지 확인
            for (String op : priority.prioList) {
                if (op.equals(operator)) {
                    // 연산자가 있으면 해당 우선순위를 반환
                    return priority;
                }
            }
        }
        return null;
    }
}
