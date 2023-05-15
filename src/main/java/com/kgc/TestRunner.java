package com.kgc;

import java.sql.Connection;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TestRunner implements ApplicationRunner{

    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        try(Connection connection = dataSource.getConnection()){
            
            System.out.println(dataSource.getClass());
            System.out.println(connection.getMetaData().getURL());
            System.out.println(connection.getMetaData().getUserName());

            Statement statement = connection.createStatement();

            String sql = "select 1 from dual"; 
            statement.executeQuery(sql);

            //String insertSql = "INSERT INTO KGC_CUST_MST(CUST_NO, CUST_NM, EMAIL, CUST_GB, INPUT_DT, INPUT_ID, UPDATE_DT, UPDATE_ID) VALUES ('1', '최민규', 'temp@sk.com', 'O', CURRENT_TIMESTAMP, 'ADMIN', CURRENT_TIMESTAMP, 'ADMIN')";

            //jdbcTemplate.execute(insertSql);

         }
    }
    
}
