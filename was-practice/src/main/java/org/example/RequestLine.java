package org.example;

import java.util.Objects;
// GET /calculate?operand1=11&operator=*&operand2=55 HTTP/1.1
public class RequestLine {
    private final String method;    // GET
    private final String urlPath;   // /calculate

    private QueryStrings queryStrings;     // operand1=11&operator=*&operand2=55

    public RequestLine(String method, String urlPath, String queryStrings) {
        this.method = method;
        this.urlPath = urlPath;
        this.queryStrings = new QueryStrings(queryStrings);
    }

    public RequestLine(String requestLine) {
        // GET /calculate?operand1=11&operator=*&operand2=55 HTTP/1.1
        String[] tokens = requestLine.split(" "); // 스페이스 바로 split
        // GET      /calculate?operand1=11&operator=*&operand2=55       HTTP/1.1

        this.method = tokens[0];    // GET 이고  tokens[1]은 "/calculate?operand1=11&operator=*&operand2=55" 이고   tokens[2]= "HTTP/1.1"
        String[] urlPathTokens = tokens[1].split("\\?");
        this.urlPath = urlPathTokens[0];    // urlPathTokens[0] = "/calculate" 이고 urlPathTokens[1] = "operand1=11&operator=*&operand2=55"

        if (urlPathTokens.length == 2) { // urlPathTokens의 길이가 2라면 즉, spllit한게 2개라면
            this.queryStrings = new QueryStrings(urlPathTokens[1]);    // 2번쨰, 배열로는 [1]에는 queryString이 올 것이다.
        }
    }

    public boolean isGetRequest() {
        return "GET".equals(this.method);
    }

    public boolean matchPath(String requestPath) {
        return urlPath.equals(requestPath);
    }

    public QueryStrings getQueryStrings() {
        return this.queryStrings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestLine that = (RequestLine) o;
        return Objects.equals(method, that.method) && Objects.equals(urlPath, that.urlPath) && Objects.equals(queryStrings, that.queryStrings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, urlPath, queryStrings);
    }

}
