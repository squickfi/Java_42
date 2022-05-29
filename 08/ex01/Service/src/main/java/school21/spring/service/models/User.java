package school21.spring.service.models;

import java.util.Objects;

public class User {

    private long _id;
    private String _email;

    public User(long id, String email) {
        _id = id;
        _email = email;
    }

    public long getId() {
        return _id;
    }

    public String getEmail() {
        return _email;
    }

    public void setId(long id) {
        _id = id;
    }

    public void setEmail(String email) {
        _email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + _id +
                ", email='" + _email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return _id == user._id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, _email);
    }
}
