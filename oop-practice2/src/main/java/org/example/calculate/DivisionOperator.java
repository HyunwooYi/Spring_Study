package org.example.calculate;

public class DivisionOperator implements NewArithmeticOperator {
    @Override
    public boolean supports(String operator) {
        return "/".equals(operator);
    }

    @Override
    public int calculate(PositiveNumber operand1, PositiveNumber operand2) {
//        if (operand2.toInt() == 0) {
//            throw new IllegalArgumentException("0으로는 나눌 수 없습니다.");
//        }
    /*
    위의 주석처리 이유는 PositiveNumber 클래스를 통해서 이미 PositiveNubmer operand1,2 에서는 0일 수가 없기 때문에
    0인지 체크할 필요가 없어졌다. PositiveNumber은 0이 될 수 없는 객체이기 때문이다.
    */
        return operand1.toInt() / operand2.toInt();
    }
}
