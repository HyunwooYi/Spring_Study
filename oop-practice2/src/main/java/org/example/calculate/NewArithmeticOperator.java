package org.example.calculate;


//Calculator -> ArithmeticOperator -> 그 후 한번 더 리펙토링을 위해 NewArithmeticOperator 인터페이스를 생성했다.
public interface NewArithmeticOperator {
    boolean supports(String operator);
    int calculate(PositiveNumber operand1, PositiveNumber operand2);
}
