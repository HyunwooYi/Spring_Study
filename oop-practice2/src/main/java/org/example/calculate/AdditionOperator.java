package org.example.calculate;

public class AdditionOperator implements NewArithmeticOperator {
    @Override
    public boolean supports(String operator) {      //AdditionOperator이기 때문에
        return "+".equals(operator);    //  opertor가 같는지에 대한 비교값을 boolean으로 전달해준다.
    }

    @Override
    public int calculate(PositiveNumber operand1, PositiveNumber operand2) {
        return operand1.toInt() + operand2.toInt();   //만약 위의 boolean 값이 갖다면 operand1 + operand2 값을 전달해준다.
    }
}
