package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CookingTest {  // 요리사(CookingTest)
    @DisplayName("메뉴에 해당하는 음식을 만든다.")
    @Test
    void makeCookTest() {
        Cooking cooking = new Cooking();    //요리사 객체 (cooking)를 만들고
        MenuItem menuItem = new MenuItem("돈까스", 5000);   //메뉴에 해당하는 음식을 만들기 때문에 MenuItem 클래스 이용 , 원하는 요리를
        Cook cook = cooking.makeCook(menuItem);  //요리사에게 요리를 만들라고 요청한다

        assertThat(cook).isEqualTo(new Cook("돈까스", 5000)); //해당 요리는 같나요?
        /*
            객체들끼리 비교할 때는 alt + insert 에서 "equals() and hashcode()" 가 있어야한다.
         */

    }
}
