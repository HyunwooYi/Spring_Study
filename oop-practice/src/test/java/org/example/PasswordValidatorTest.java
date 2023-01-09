package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

/*
  요구사항
* 비밀번호는 최소 8자 이상 12자 이하여야 한다.
* 비밀번호가 8자 미만 또는 12자 초과인 경우 IllegalArgumentException 예외를 발생시킨다.
* 경계조건에 대해 테스트 코드를 작성해야 한다.
 */
public class PasswordValidatorTest {

    @DisplayName("비밀번호가 최소 8자 이상, 12자 이하면 예외가 발생하지 않는다.")    //해당 test 코드의 의도를 적는다.
    @Test
    void validatePasswordTest() {
        assertThatCode(() -> PasswordValidator.validate("serverwizard"))
                .doesNotThrowAnyException();

            /*
            assertThatCode안의 "() -> PasswordValidator.validate("serverwizard")"이 호출(실행)되었을 때
            예외가 발생않음을 확인하기 위해
            doesNotThrowAnyException();을 작성하면 예외가 발생하지 않으면 테스트가 통과할 것이다.
            */
    }
    @DisplayName("비밀번호가 8자 미만 또는 12자 초과하는 경우 IllegalArgumentException 예외가 발생한다.")   //해당 test 의도
    @ParameterizedTest
    @ValueSource(strings ={"aaabbbc","aaaabbbbccccd"})  //경계값인 7자와 13자의 길이 비밀번호
    void validatePasswordTest2(String password) {   //7자와 13자의 길이 비밀번호가 password로 들어오면 해당 password로 검사해주면된다.

        assertThatCode(() -> PasswordValidator.validate(password))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("비밀번호는 최소 8자 이상 12자 이하여야 한다.");
                    /*
                    해당 메서드가 호출되면 Exception이 발생하는데 이 타입(Instance)은 IllegalArugmentException이고
                       "비밀번호는 최소 8자 이상 12자 이하여야 한다."라는 메시지를 가지는가? 라는 test 코드
                     */
    }
}
