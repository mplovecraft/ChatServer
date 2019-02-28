package com.company.User;

import java.net.SocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserList {
    Map<String, User> userList = new ConcurrentHashMap<>();

    public UserList() {
    }

    public void tryAddUser(String clientName) {
        if (userList.size() != 0) {
            for (User userToCheck : userList.values()) {
                if (clientName.equals(userToCheck.getUserName())) {
                    break;
                } else {
                    createUser(clientName);
                }
            }
        } else {
            createUser(clientName);
        }
    }

    private void createUser(String clientName) {
        User user = new User(clientName);
        userList.put(user.getUserID(), user);
    }

    public User validateUser(String clientName, SocketAddress socketAddress) {
        for (User user : userList.values()) {
            if (clientName.equals(user.getUserName())) {
                return user;
            }
        }
        return null;
    }
}