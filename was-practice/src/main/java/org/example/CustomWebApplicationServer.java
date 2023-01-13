package org.example;

import org.example.calculator.domain.Calculator;
import org.example.calculator.domain.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


// start()를 호출하면 웹 어플리케이션 서버가 동작하는 형태로 인터페이스를 잡자.
public class CustomWebApplicationServer {
    private final int port; // 웹 어플리케이션 서버이기 때문에 port 값을 갖도록 구현하자.

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

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

                executorService.execute(new ClientRequestHandler(clientSocket));
            }
        }
    }
}
