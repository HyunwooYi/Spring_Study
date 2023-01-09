package org.example;

import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
public class WebApplicationServer {
        private static final Logger log = LoggerFactory.getLogger(WebApplicationServer.class);

        public static void main(String[] args) throws Exception {
            String webappDirLocation = "webapps/";
            Tomcat tomcat = new Tomcat();
            tomcat.setPort(8080);       //tomcat을 8080으로 설정을 한다

            tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
            //local host 8080으로 입력했을때 webappDirLocation(즉, webapps라는) 디렉토리를 바라보도록 한다 (루트 디렉토리로 보도록)
            log.info("configuring app with basedir: {}", new File("./" + webappDirLocation).getAbsolutePath());
            tomcat.start();
            tomcat.getServer().await();

    }
}
