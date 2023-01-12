package org.example;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class QueryStringTest {
    // List<QueryString>
    @Test
    void creatTest() {
        QueryString queryString = new QueryString("operand1","11");
        //QueryString은 key, value 값이 하나인 객체이다.

        assertThat(queryString).isNotNull();


    }
}
