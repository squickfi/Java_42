package edu.school21.chat.models;

import java.util.ArrayList;

public class Chatroom {

    private long _id;
    private String _chatroomName;
    private User _chatroomOwner;
    private ArrayList<Message> _massagesList;

    public Chatroom(long id, String chatroomName, User chatroomOwner, ArrayList<Message> massagesList) {
        _id = id;
        _chatroomName = chatroomName;
        _chatroomOwner = chatroomOwner;
        _massagesList = massagesList;
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
                " chatroomName = " + _chatroomName;
    }

    public long getId() {
        return _id;
    }

    public String getChatroomName() {
        return _chatroomName;
    }

    public User getChatroomOwner() {
        return _chatroomOwner;
    }

    public ArrayList<Message> getMassagesList() {
        return _massagesList;
    }

    public void setId(long _id) {
        this._id = _id;
    }

    public void setChatroomName(String _chatroomName) {
        this._chatroomName = _chatroomName;
    }

    public void setChatroomOwner(User _chatroomOwner) {
        this._chatroomOwner = _chatroomOwner;
    }

    public void setMassagesList(ArrayList<Message> _massagesList) {
        this._massagesList = _massagesList;
    }
}
