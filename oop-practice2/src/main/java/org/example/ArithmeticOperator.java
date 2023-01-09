package org.example;

import java.util.Arrays;

public enum ArithmeticOperator {   //enum으로 한다.
    ADDITION("+"){          //alt + enter를 누르면 ADDITION의 추상 메소드에 대한 Override 메소드가 선언된다.
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 + operand2;
        }
    }, SUBTRACTION("-") {   //SUBTRACTION의 추상 메소드에 대한 Override 메소드가 선언된다.
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 - operand2;
        }
    }, MULTIPLICATION("*"){     //MULTIPLICATION의 추상 메소드에 대한 Override 메소드가 선언된다.
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 * operand2;
        }
    }, DIVISION("/"){           //DIVISION의 추상 메소드에 대한 Override 메소드가 선언된다.
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 / operand2;
        }

        // 이렇게 위와 같이 enum 마다 caculate를 선언했다.
    };

    //해당하는 부분인 괄호안에 문자열을 넣었기 때문에 이를 위해서 private을 넣고 final로 operator 선언
    private final String operator;  // 즉 위의 괄호 안에 들어오는 것을 operator라고 하겠다는 의미이다.

    ArithmeticOperator(String operator) {
        this.operator = operator;
    }


    public abstract int arithmeticCalculate(final int operand1, final int operand2);  // 각각의 연산을 수행하기 위해 추상메소드를 선언
    /*
    추상 메소드는 enum 각각에 대해서 Override를 한다. 그리고 아래의 public interface는 외부에 노출되는 public interface 이다.
    그래서 인자들을 전달해주면
     */

    public static int calculate(int operand1, String operator, int operand2) {
        ArithmeticOperator arithmeticOperator = Arrays.stream(values())     //values로 모든 enum 값들을 갖고 오고
                .filter(v -> v.operator.equals(operator))   // v의 enum 값의 operator 값이 연산자와 같다면
                .findFirst()                // 같은 것을 가져오고
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));// 같은 것이 없다면

        return arithmeticOperator.arithmeticCalculate(operand1, operand2);
    }
    /*
    최종적으로 ArithmeticOperator에서 연산자에 일치하는 enum 값을 가지고  arithmeticCalculate에서  그 enum 값에 해당하는
    메소드들중 하나를 실행해준다.
    그리고 결과값을 int로 return 해주는 구조이다.
    이렇게 리팩토링이 끝나면 test 코드를 실행해본다.
     */






}
