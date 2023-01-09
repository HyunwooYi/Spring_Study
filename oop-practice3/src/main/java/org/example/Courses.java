package org.example;

import java.util.List;

public class Courses {
    //초기의 GradeCalculaor에  있던 정보가 모두 multiplyCreditAndCourseGrade 라는
    // Courses의 밑으로 이동한것을 알 수 있다.
    private final List<Course> courses; //  이수한 과목들을 인스턴스 변수로 선언

    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    public double multiplyCreditAndCourseGrade() {
        return courses.stream() // 이수한 과목들을 전체 돌면서
                .mapToDouble(Course::multiplyCreditAndCourseGrade)  //이수한 과목들의 credit * getGradeToNumber() 정보를
                .sum();     //모두 sum 하는 메소드
    }

    public int calculateTotalCompletedCredit() {
        return courses.stream() // 이수한 과목들을 돌면서
                .mapToInt(Course::getCredit)    //해당하는 학점수 들을
                .sum(); //총 sum 하는 메소드
    }
}

//        double multipliedCreditAndCourseGrade = 0;
//        for (Course course : courses) {    //이수한 과목들을 돌면서
//            multipliedCreditAndCourseGrade += course.multiplyCreditAndCourseGrade();
//        }
//        return multipliedCreditAndCourseGrade;

