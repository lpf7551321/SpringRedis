package com.netease.meta.dao;

import com.netease.meta.bean.User;

import java.util.List;

/**
 * Created by hz-lpf on 16-5-19.
 */
public interface UserDao extends BaseDao<User> {
    @Override
    int deleteById(int id);

    @Override
    User findById(int id);

    @Override
    int insert(User user);

    @Override
    int update(User user);

    List<User> batchFindById(List<Integer> ids);
}
