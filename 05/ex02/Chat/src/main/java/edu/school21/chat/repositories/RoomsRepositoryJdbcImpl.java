package edu.school21.chat.repositories;

import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class RoomsRepositoryJdbcImpl implements RoomsRepository {

    private final DataSource _dataSource;

    public RoomsRepositoryJdbcImpl(DataSource dataSource) {
        _dataSource = dataSource;
    }

    @Override
    public Optional<Chatroom> findById (Long id) throws SQLException {

        Optional<Chatroom> room;
        Connection connection = _dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM rooms WHERE id = " + id);
        result.next();

        User newUser = new User(1, "user", "user", null, null);
        try {
            room = Optional.of(new Chatroom(result.getLong(1), "room", newUser, null));
        } catch (Exception e) {
            throw new NotSavedSubEntityException("Not saved subEntity exception");
        }
        return room;
    }
}
