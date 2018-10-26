package service;

import mapper.UserMapper;
import org.springframework.stereotype.Service;
import pojo.User;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    public User getUserByUsername(String username) {
        return userMapper.login(new User(username));
    }
}
