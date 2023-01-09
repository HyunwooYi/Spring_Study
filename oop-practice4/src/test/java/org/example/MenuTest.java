package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;


public class MenuTest {     // 메뉴판

    @DisplayName("메뉴판에서 메뉴이름에 해당하는 메뉴를 반환한다.")
    @Test
    void chooseTest() {
        Menu menu = new Menu(List.of(new MenuItem("돈까스", 5000), new MenuItem("냉면", 7000)));
        //메뉴에는 여러개의 메뉴 항목들을 가진다는 표현

        MenuItem menuItem = menu.choose("돈까스");  // Menu menu (메뉴판에서) 메뉴에 대한 이름을 전달했을 때 메뉴항목이 리턴된다.

        assertThat(menuItem).isEqualTo(new MenuItem("돈까스", 5000));  // 돈까스가 제대로 나오는지 검증

    }
    @DisplayName("메뉴판에 없는 메뉴를 선택할 시 예외를 반환한다.")
    @Test
    void chooseTest2() {
        //메뉴 항목
        Menu menu = new Menu(List.of(new MenuItem("돈까스", 5000), new MenuItem("냉면", 7000)));

        assertThatCode(() -> menu.choose("통닭"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 메뉴 이름입니다.");
    }
}
