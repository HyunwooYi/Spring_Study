package org.example;

import org.example.calculate.*;

import java.util.List;

public class Calculator {
    private static final List<NewArithmeticOperator> arithmeticOperators = List.of(new AdditionOperator(), new SubtractionOperator(), new MultitplicationOperator(), new DivisionOperator());

    // 각각의 구현체들을 상위 인터페이스인 NewArithmeticOperator 를 통해서 받는다. arithmeticOperators로 받음.
    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) { // public interface 하나 선언
            return arithmeticOperators.stream()
                    .filter(arithmeticOperator -> arithmeticOperator.supports(operator))
                    .map(arithmeticOperator -> arithmeticOperator.calculate(operand1, operand2))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));


                   /*
                   새로 리펙토링을 해서 인터페이스(NewArithmeticOperator)를 하나 두고 인터페이스를 구현한 4개의 구현체를
                   일단 인터페이스로 받는다. 그리고 들어온 operator에 맞는 구현체를 찾아서 그 구현체에게 calculate에
                   인자로 받은 (operand1, operand2) 전달한다.
                   그래서 해당하는 값이 int 이기 때문에  int로 받기위해 .map을 이요하였고 .findFirst 를 통해 첫번째 값을 받고

                   그러나 해당하는 supports(operator)에서 연산자에 해당한는 구현체가 없다면
                   "올바른 사칙연산이 아닙니다"라고 예외 발생한다.
                    */

        //

    }
}

    /*
        초반에 아래 주석과 같이 코드를 만들었지만
        ArithmeticOperator을 구현함으로써 Calculator 입장에서는 계산을 해달라는 요청이 들어왔을 때 이제 직접 자신이 계산을
        하지 않고 ArithmeticOperator에게 계산을 해달라고 다시한번 작업을 요청한다.
        이때 전달하는게 operand1, operator, operand2 이다.

     */

//#1
//        if ("+".equals(operator)) {
//            return operand1 + operand2;
//        } else if ("-".equals(operator)) {
//            return operand1 - operand2;
//        } else if ("*".equals(operator)) {
//            return operand1 * operand2;
//        } else if ("/".equals(operator)) {
//            return operand1 / operand2;
//        }
//        return 0;


//#2
//public static int calculate(int operand1, String operator, int operand2) { // public interface 하나 선언
//    return ArithmeticOperator.calculate(operand1, operator, operand2);

