package edu.school21.chat.repositories;

import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository {

    private final DataSource _dataSource;

    public UsersRepositoryJdbcImpl(DataSource dataSource) {
        _dataSource = dataSource;
    }

    @Override
    public Optional<User> findById (Long id) throws SQLException {

        Optional<User> user;
        Connection connection = _dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM users WHERE id = " + id);
        result.next();

        try {
            user = Optional.of(new User(result.getLong(1), result.getString("login"),
                    result.getString("password"), null, null));
        } catch (Exception e) {
            throw new NotSavedSubEntityException("Not saved subEntity exception");
        }
        return user;
    }
}
