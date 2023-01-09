package org.example;

import org.example.calculate.PositiveNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * 요구사항
 * 간단한 사칙연산을 할 수 있다.
 * 양수로만 계산할 수 있다.
 * 나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.
 * MVC패턴(Model-View-Controller) 기반으로 구현한다
 */
public class CalculatorTest {

    // 1 + 2 ----> Calculator         Calculator에게 작업을 위임하는데 필요한 인자는 2개의 피연산자와 하나의 연산자가 필요하다.
    //   3   <----                    이러한 형태로 구현해야한다. 이러한 형태의 public interface를 만들어보자

    // 사칙연산을 4개의 test코드로 하지 않고 한번에 하는 방법이 밑의 코드이다.
    @DisplayName("덧셈 연산을 수행한다.")
    @ParameterizedTest
    @MethodSource("formulaAndResult")
    void calculateTest(int operand1, String operand, int operand2, int result) {
        int calculateResult = Calculator.calculate(new PositiveNumber(operand1), operand, new PositiveNumber(operand2));

        assertThat(calculateResult).isEqualTo(result);

    }
    //아래 메소드를 static 없이 test 돌렸더니 "Cannot invoke non-static method" 이라는 예외로 인해 static을 앞에 써주었다.
    private static Stream<Arguments> formulaAndResult(){   //이 메소드를 소스로 가질것이다 ( @MethodSource() )
        return Stream.of(
                arguments(1, "+", 2, 3), // 피연산자 1,  연산자 하나, 피연산자 2를 넣으면 결과가 3이 되어야해
                arguments(1, "-", 2, -1),
                arguments(4, "*", 2, 8),
                arguments(4, "/", 2, 2)
        );
        // 이 내부에서만 사용할 것이기에 private으로 선언했다.
    }
    /*
    calculateTest의 인자에 위의 arguments()내부의 인자들이 들어가서
    test를 수행하고 다음것을 수행하면서 사칙연산을 한번에 test할 수 있다.
     */


//    @DisplayName("나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.")
//    @Test
//    void calculateExceptionTest() {
//      assertThatCode(() -> Calculator.calculate(new PositiveNumber(10), "/", new PositiveNumber(0)))
//                .isInstanceOf(IllegalArgumentException.class) // 예외가 IllegalArgumentException 인지
//                .hasMessage("0으로는 나눌 수 없습니다.");

    //위의 주석 처리의 이유는 PositiveNumber의 validate로 인해 0은 들어 올수 없으므로 필요가 없어졌다.




        /*
        예외가 IllegalArgumentException 이 발생하지 않는다.
        그러면 객체지향으로 프로그램을 잘 만들었기 때문에 DivisionOpertor로 가서
        operand2가 0일 경우만 설정해주면 된다.
         */

}

