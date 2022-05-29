package school21.spring.service.repositories;

import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository {

    private DataSource _dataSource;

    public UsersRepositoryJdbcImpl(DataSource dataSource) {
        _dataSource = dataSource;
    }

    @Override
    public User findById(Long id) {
        User user = null;
        try (Connection connection = _dataSource.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE id = " + id);
            resultSet.next();
            user = new User(resultSet.getLong("id"), resultSet.getString("email"));
        }
        catch (Exception e) {
            System.err.println(e);
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<User>();
        try (Connection connection = _dataSource.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            while (resultSet.next()) {
                list.add(new User(resultSet.getLong("id"), resultSet.getString("email")));
            }
        }
        catch (Exception e) {
            System.err.println(e);
        }
        return list;
    }

    @Override
    public void save(User entity) {
        try (Connection connection = _dataSource.getConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate("INSERT INTO users(email) VALUES (" + entity.getEmail() + ")");
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }

    @Override
    public void update(User entity) {
        try (Connection connection = _dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            
            statement.executeUpdate("UPDATE users SET email = " + entity.getEmail() +
                    " WHERE id = " + entity.getId());
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }

    @Override
    public void delete(Long id) {
        try (Connection connection = _dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            
            statement.executeUpdate("DELETE FROM users WHERE id = " + id);
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
    
    @Override
    public Optional<User> findByEmail(String email) {
        Optional<User> user = Optional.of(null);
        try (Connection connection = _dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE email = '" + email + "'");
            if (resultSet.next()) {
                user = Optional.of(new User(resultSet.getLong("id"), resultSet.getString("email")));
            }
        }
        catch (Exception e) {
            System.err.println(e);
        }
        return user;
    }
}
