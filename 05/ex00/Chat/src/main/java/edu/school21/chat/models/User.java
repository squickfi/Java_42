package edu.school21.chat.models;

import java.util.ArrayList;

public class User {

    private long _id;
    private String _login;
    private String _password;
    private ArrayList<Chatroom> _createdRooms;
    private ArrayList<Chatroom> _roomsInUse;

    public User(long id, String login, String password,
                ArrayList<Chatroom> createdRooms, ArrayList<Chatroom> roomsInUse) {
        _id = id;
        _login = login;
        _password = password;
        _createdRooms = createdRooms;
        _roomsInUse = roomsInUse;
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
        return "id = " + _id +
                " login = " + _login;
    }

    public long getId() {
        return _id;
    }

    public String getLogin() {
        return _login;
    }

    public String getPassword() {
        return _password;
    }

    public ArrayList<Chatroom> getCreatedRooms() {
        return _createdRooms;
    }

    public ArrayList<Chatroom> getRoomsInUse() {
        return _roomsInUse;
    }

    public void setId(long _id) {
        this._id = _id;
    }

    public void setLogin(String _login) {
        this._login = _login;
    }

    public void setPassword(String _password) {
        this._password = _password;
    }

    public void setCreatedRooms(ArrayList<Chatroom> _createdRooms) {
        this._createdRooms = _createdRooms;
    }

    public void setRoomsInUse(ArrayList<Chatroom> _roomsInUse) {
        this._roomsInUse = _roomsInUse;
    }
}
