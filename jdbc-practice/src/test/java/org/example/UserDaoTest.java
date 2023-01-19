package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

public class UserDaoTest {

    @BeforeEach     // test 코드를 실행하기전에 수행해야할 작업이 있다면 코드르 작성
    void setUp() {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("db_schema.sql"));    //db_schema.sql 이라는 파일을 path에서 읽어와서 스크립트에 추가
        DatabasePopulatorUtils.execute(populator, ConncectionManager.getDataSource());
    }

    @Test
    void createTest() throws SQLException {
        UserDao userDao = new UserDao();

        userDao.create(new User("wizard", "password", "name", "email"));    // userDao에게 데이터베이스에 해당 정보를 저장 요청을 하고

        User user = userDao.findByUserId("wizard");
        // userDao에게 해당 아이디에 해당하는 정보를 조회해온 다음에 해당 정보가 저장이 되었으면 정보가 조회가 될 것이다.
        assertThat(user).isEqualTo(new User("wizard", "password", "name", "email"));    // 그러면 위에서 저장한 내용과 같은지 확인한다.

    }
}
