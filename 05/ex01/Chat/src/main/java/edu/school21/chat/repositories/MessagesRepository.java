package edu.school21.chat.repositories;

import edu.school21.chat.models.Message;

import java.sql.SQLException;
import java.util.*;

public interface MessagesRepository {
    Optional<Message> findById(Long id) throws SQLException;
}
