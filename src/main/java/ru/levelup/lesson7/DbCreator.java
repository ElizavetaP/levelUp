package ru.levelup.lesson7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Component
public class DbCreator {

    @Autowired
    DataSource ds;

    @PostConstruct
    void createDb() {
        try (Connection connection = ds.getConnection()) {
            List<String> strList = List.of("drop table if exists city;",
                    "create table city (id int not null, " +
                            "name_ru varchar(200) null, " +
                            "name_en varchar(200) null," +
                            "population varchar(200) null," +
                            "constraint city_pk primary key (id)); ");
            for (String str : strList) {
                Statement statementDelete = connection.createStatement();
                statementDelete.executeUpdate(str);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
