package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QueryStringsTest {
    @Test
    void createTest() {
        QueryStrings queryStrings = new QueryStrings("operand1=11&operator=*&operand2=55");
        //QueryStrings는 내부적으로 여러개의 List<QueryString>을 가지는 형태가 될 것이다.

        assertThat(queryStrings).isNotNull();
    }
}
