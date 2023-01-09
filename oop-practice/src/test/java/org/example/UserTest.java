package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @DisplayName("패스워드를 초기화한다.")

    @Test
    void passwordTest() {
        // given    -이러한 유저 객체가 주어졌고
        User user = new User();

        // when     -이 메소드를 호출 했을 때

        user.initPassword(new CorrectFixedPasswordGenerator()); // 해당 Generator은 항상 8글자라서 패스워드는 세팅 될것이다.

        /*
        user.initPassword(new RandomPasswordGenerator());  을 하면 똑같이  성공할 수도 실패 할 수도 있는 결과 가 나온다.
        랜덤한 것을 주입 받으면 랜덤하게 생성되니까
         */

        // then     - 패스워드가 세팅이 되기를 기대한다.
        assertThat(user.getPassword()).isNotNull();
    }
    /*
    0~12자의 패스워드가 생성되므로 테스트 코드를 실행 할 때마다 성공할 수도 실패 할 수도 있다.
     */

    @DisplayName("패스워드가 요구사항에 부합되   지 않아 초기화가 되지 않는다.")

    @Test
    void passwordTest2() {
        // given    -이러한 유저 객체가 주어졌고
        User user = new User();

        // when     -이 메소드를 호출 했을 때

        user.initPassword(new WrongFixedPasswordGenerator()); // 해당 Generator은 항상 2글자라서

        /*
        void initPassword()에서
        generatePassword하면 2글자인 password가 리턴이 되고 항상 초기화가 되지 않을 것이다.
        그래서 아래 assertThat의 경우도 isNotNull이 아닌 isNull이 된다.
         */

        // then     - 패스워드가 세팅이 되기를 기대한다.
        assertThat(user.getPassword()).isNull();
    }

    /*
    실제 운영에서는 Correct, Wrong은 없고 항상 랜덤하게 들어갈 것이다.
    그렇지만 위와 같은 방식으로 test를 할 수 있다는 것을 알면 된다.
     */
}