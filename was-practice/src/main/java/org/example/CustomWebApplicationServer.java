package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;


// start()를 호출하면 웹 어플리케이션 서버가 동작하는 형태로 인터페이스를 잡자.
public class CustomWebApplicationServer {
    private final int port; // 웹 어플리케이션 서버이기 때문에 port 값을 갖도록 구현하자.

    private static final Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class);  // logger를 추가하기 위해

    public CustomWebApplicationServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {   // ServerSocket을 만들 것이고 해당하는 port로 서버를  띄울 것이다.
            logger.info("[CustomWebApplicationServer] started {} port.", port);    // info를 통해서 cCustomWebApplicationServer가 시작되었다, ___port로 라는 의미로 log를 남긴다.

            Socket clientSocket;
            logger.info("[CustomWebApplicationServer] waiting for client.");

            while ((clientSocket = serverSocket.accept()) != null) {
                logger.info("[CustomWebApplicationServer] client connected!");

                /**
                 *  Step1 - 사용자 요청을 메인 Thread가 처리하도록 한다.
                 */

                try(InputStream in = clientSocket.getInputStream(); OutputStream out = clientSocket.getOutputStream()){
                    BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
//                    라인 by 라인으로 읽고 싶어서 InputStream을 Reader로 바꾸기 위해서 InputStreamReader로 감싸주었고 new InputStreamReader(   )
//                    이를 BufferedReader로 감싸주었다. new BufferedReader(    )

                    DataOutputStream dos = new DataOutputStream(out);
//                  OutputStream도 DataOutputStream을 이용해서 한번 더 감싸주었다.

                    HttpRequest  httpRequest = new HttpRequest(br);

                    if(httpRequest.isGetRequest() && httpRequest.matchPath("/calculate")) {  //Get요청이면서 path가 /calculate 라면
                       QueryStrings queryStrings = httpRequest.getQueryString();        // 그때서야 queryString을 가지고 올 것이다.

                        int operand1 = Integer.parseInt(queryStrings.getValue("operand1"));
                        String operator = queryStrings.getValue("operator");
                        int operand2 = Integer.parseInt(queryStrings.getValue("operand2"));

                        int result = Calculator.calculate(new Positive(operand1), operator, new Positive(operand2));
                        byte[] body = String.valueOf(result).getBytes();
                        HttpResponse response = new HttpResponse(dos);
                        response.response200Header("application/json", body.length);
                        response.responseBody(body);
                    }
                }
            }
        }
    }
}
