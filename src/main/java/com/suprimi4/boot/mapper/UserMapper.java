package com.suprimi4.boot.mapper;

import com.suprimi4.boot.model.User;
import starter.service.income_client_starter.FetchUser;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static List<User> map(List<FetchUser> fetchUsers) {
        List<User> users = new ArrayList<>();
        User user;
        for (FetchUser fetchUser : fetchUsers) {
            user = new User(fetchUser.getId(), fetchUser.getIncome());
            users.add(user);
        }

        return users;
    }
}
