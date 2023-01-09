package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * 요구사항
 * 평균학점 계산 방법 = (학점수×교과목 평점)의 합계 / 수강신청 총학점 수
 * MVC패턴(Model-View-Controller) 기반으로 구현한다.
 * 일급 컬렉션 사용
 */
public class GradeCalculatorTest {
    //  학점계산기 도메인 : 이수한 과목(객체지향프로그래밍, 자료구조, 중국어회화), 학점 계산기
    //  객체지향프로그래밍, 자료구조, 중국어회화 --> 과목(코스) 클래스

    /**
     * 핵심 포인트
     */
    //  이수한 과목을 전달하여 평균학점 계산 요청 ----> 학점 계산기 ----> (학점수×교과목 평점)의 합계 ----> 과목(코스)
    //                                                       ---> 수강신청 총학점 수        ----> 과목(코스)


    @DisplayName("평균 학점을 계산한다.")
    @Test
    void calculateGradeTest() {
        List<Course> courses = List.of(new Course("OOP", 3, "A+"),   //  이수한 과목이 여러개 이니 List 형태로 받는다.
                new Course("자료구조", 3, "A+"));

        GradeCalculator gradeCalculator = new GradeCalculator(courses);  // 학점 계산기가 생성될 때 이수한 과목들을 전달 해주도록 한다.
        double gradeResult = gradeCalculator.calculateGrade();   // 이수한 과목들을 가지고 성적을 계산해주도록 한다.

        Assertions.assertThat(gradeResult).isEqualTo(4.5);  // 두 과목다 A+을 맞아서 4.5일 것이기 때문에
    }
}


//  코스에는 해당 자료구조가 3학점인지 2학점인지 정보를 가지고 있다.  + 점수도 갖고 있다.
//  이수한 과목들을 전달 받은 학점 계산기는 학점수, 교과목 평점을 알고 있는 과목(코스)에게 이 합계에 대한 요청을 해서
//  이들에 대한 학점을 받고 또한 이수한 과목들의 총학점 수도 이수한 과목들을 통해서 구할 수 있기 때문에
//  각각의 합계와 총학점 수를 구해서 나눠서 전달해주면된다.
