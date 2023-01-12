package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueryStrings {
    private List<QueryString> querystrings = new ArrayList<>();
    // operand1=11    &    operator=*     &     operand2=55
    // queryStringLine이 들어오면  &연산자로 3개로 나누고
    //  그 3가지 객체를 다시 "=" value로 나누고 해당하는 List에 초기화 하는 로직이다.
    public QueryStrings(String queryStringLine) {
        String[] queryStringTokens = queryStringLine.split("&");
        Arrays.stream(queryStringTokens)
                .forEach(queryString -> {
                    String[] values = queryString.split("=");
                    if (values.length != 2) {    // 길이가 2가 아니면 key,value 형태가 아니다.
                        throw new IllegalArgumentException("잘못된 QueryString 포맷을 가진 문자열입니다.");
                    }
                    querystrings.add(new QueryString(values[0], values[1]));
                });

    }

    public String getValue(String key) {
        return this.querystrings.stream()
                .filter(queryString -> queryString.exists(key))
                .map(QueryString::getValue)
                .findFirst()
                .orElse(null);

    }
}
