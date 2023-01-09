package org.example;

import org.example.calculate.PositiveNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

public class PositiveNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void createTest(int value) {
        assertThatCode(() -> new PositiveNumber(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("또는 음수를 전달할 수 없습니다.");
    }
    // 0 또는 -1 일때 정상적으로 exception이 발생한다.
    /*
    위의 정상적인 exception이라는 뜻은 위의 .hasMessage에 문자열에서 하나라도 지우게 되면
    에러가 발생하는 것을 볼 수 있다.
     */
}
