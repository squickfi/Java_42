package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class Program {

    public static void main(String[] args) throws SQLException {

        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        dataSource.setUsername("postgres");
        dataSource.setPassword("1");

        MessagesRepository repository = new MessagesRepositoryJdbcImpl(dataSource);

        User newUser = new User(1, "user", "user", null, null);
        User wrongNewUser = new User(20, "user", "user", null, null);
        Chatroom newRoom = new Chatroom(1, "room", null, null);
        Chatroom wrongRoom = new Chatroom(1, "room", null, null);
        Message myMessage = new Message(0, newUser, newRoom, "Hello from java.", LocalDateTime.now());
        Message wrongMyMessage = new Message(0, wrongNewUser, wrongRoom, "Hello from java.", LocalDateTime.now());

        repository.save(myMessage);
        System.out.println("Added message:\n" + myMessage);
        try {
            repository.save(wrongMyMessage);
        } catch (Exception e) {
            System.out.println("\nUser ot of bounds:\n" + e);
        }
    }
}
