package edu.school21.chat.repositories;

import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {

    private final DataSource _dataSource;

    public MessagesRepositoryJdbcImpl(DataSource dataSource) {
        _dataSource = dataSource;
    }

    @Override
    public Optional<Message> findById (Long id) throws SQLException {

        Optional<Message> message;
        Connection connection = _dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM messages WHERE id = " + id);
        result.next();

        User newUser = new User(1, "user", "user", null, null);
        Chatroom newRoom = new Chatroom(1, "room", null, null);
        message = Optional.of(new Message(result.getLong(1), newUser,
                newRoom,
                result.getString("message"),
                LocalDateTime.of(2022, 04, 26, 17, 1)));
        return message;
    }

    @Override
    public void save(Message message) throws SQLException {

        UsersRepository userRep = new UsersRepositoryJdbcImpl(_dataSource);
        RoomsRepository roomRep = new RoomsRepositoryJdbcImpl(_dataSource);

        userRep.findById(message.getAuthor().getId());
        roomRep.findById(message.getChatroom().getId());

        Connection connection = _dataSource.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO messages " +
                "(message, time, message_author, message_room) VALUES ('" +
                message.getText() + "', '" + message.getTime() + "', '" +
                message.getAuthor().getId() + "', '" + message.getChatroom().getId() + "');");
        statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM messages ORDER BY id DESC LIMIT 1");
        result.next();
        message.setId(result.getLong("id"));
    }
}
