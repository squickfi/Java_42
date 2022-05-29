package edu.school21.chat.models;

import java.time.LocalDateTime;

public class Message {

    private long _id;
    private User _author;
    private Chatroom _chatroom;
    private String _text;
    private LocalDateTime _time;

    public Message(long id, User author, Chatroom chatroom, String text, LocalDateTime time) {
        _id = id;
        _author = author;
        _chatroom = chatroom;
        _text = text;
        _time = time;
    }

    @Override
    public boolean equals(Object other) {
        return this == other;
    }

    @Override
    public int hashCode() {
        return (int)_id;
    }

    @Override
    public String toString() {
        return "id: " + _id +
                "\nauthor: " + _author +
                "\nchatroom: " + _chatroom +
                "\ntime: " + _time +
                "\nmessage: " + _text;
    }

    public long getId() {
        return _id;
    }

    public User getAuthor() {
        return _author;
    }

    public Chatroom getChatroom() {
        return _chatroom;
    }

    public String getText() {
        return _text;
    }

    public LocalDateTime getTime() {
        return _time;
    }

    public void setId(long _id) {
        this._id = _id;
    }

    public void setAuthor(User _author) {
        this._author = _author;
    }

    public void setChatroom(Chatroom _chatroom) {
        this._chatroom = _chatroom;
    }

    public void setText(String _text) {
        this._text = _text;
    }

    public void setTime(LocalDateTime _time) {
        this._time = _time;
    }
}
