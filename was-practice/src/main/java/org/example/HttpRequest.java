package org.example;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpRequest {
    private final RequestLine requestLine;
//    private final HttpHeaders httpHeaders;
//    private final Body body;

    public HttpRequest(BufferedReader br) throws IOException {
        this.requestLine = new RequestLine(br.readLine());
        // 프로토콜의 첫번째 라인(request Line) 은 RequestLine 객체가 method, urlPath, queryString의 형태로 세팅이 되서 만들어진다.
    }
    public boolean isGetRequest() {
        return requestLine.isGetRequest();
    }

    public boolean matchPath(String requestPath) {
        return requestLine.matchPath(requestPath);
    }

    public QueryStrings getQueryString() {
        return requestLine.getQueryStrings();
    }
}
