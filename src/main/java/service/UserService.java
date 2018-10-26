package service;

import pojo.User;

public interface UserService {
    User getUserByUsername(String username);
}
