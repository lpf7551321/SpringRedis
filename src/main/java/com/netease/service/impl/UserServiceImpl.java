package com.netease.service.impl;

import com.netease.meta.bean.User;
import com.netease.meta.dao.UserDao;
import com.netease.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hz-lpf on 16-5-19.
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int deleteById(int id) {
        return userDao.deleteById(id);
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public List<User> batchFindById(int start, int end) {
        List<Integer> ids = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            ids.add(i);
        }
        return userDao.batchFindById(ids);
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
