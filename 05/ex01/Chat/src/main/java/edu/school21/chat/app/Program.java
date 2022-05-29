package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;
import java.sql.SQLException;

public class Program {

    public static void main(String[] args) throws SQLException {

        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        dataSource.setUsername("postgres");
        dataSource.setPassword("1");

        MessagesRepository repository = new MessagesRepositoryJdbcImpl(dataSource);
        for (int i = 1; i < 6; ++i) {
            System.out.println(repository.findById((long)i).get());
        }
    }
}
