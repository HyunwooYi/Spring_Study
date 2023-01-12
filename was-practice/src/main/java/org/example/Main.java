package org.example;

import java.io.IOException;

// GET /calculate?operand1=11&operator=*&operand2=55
/* GET에 calculate라는 요청이 들어오게 되면 계산기에 대한 결과를 수행해서 리턴해준다.
    GET 요청
    해당하는 pass는 calculate
    피연산자는 operand1 와 operand2   총 2개
    연산자는 operator=*  총 1개
    를 전달하는 이에 대한 결과 값을 리턴해주는 web application을 만들 것이다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        new CustomWebApplicationServer(8080).start();
    }
}
