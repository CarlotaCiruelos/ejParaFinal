package com.icai.exFinal;


import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class Database {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(Database.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertData() {
        LOGGER.info("> Inserting data...");

       jdbcTemplate.execute("INSERT INTO USERS VALUES (101, 'u', 'comment1')");
        jdbcTemplate.execute("INSERT INTO USERS VALUES (102, 'user2', 'comment2')");
        jdbcTemplate.execute("INSERT INTO USERS VALUES (103, 'user3', 'comment3')");
        jdbcTemplate.execute("INSERT INTO USERS VALUES (104, 'user4', 'comment4')");
        jdbcTemplate.execute("INSERT INTO USERS VALUES (105, 'user5', 'comment5')");

        jdbcTemplate.execute("INSERT INTO DOCUMENTS VALUES (1, 'doc1', 101)");
        jdbcTemplate.execute("INSERT INTO DOCUMENTS VALUES (2, 'doc2', 101)");
        jdbcTemplate.execute("INSERT INTO DOCUMENTS VALUES (3, 'doc3', 101)");
        jdbcTemplate.execute("INSERT INTO DOCUMENTS VALUES (4, 'doc4', 101)");
        jdbcTemplate.execute("INSERT INTO DOCUMENTS VALUES (5, 'doc5', 102)");
        jdbcTemplate.execute("INSERT INTO DOCUMENTS VALUES (6, 'doc6', 102)");

    }

}

