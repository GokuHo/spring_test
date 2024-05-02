package dao.impl;

import dao.UserDao;

public class UserImpl implements UserDao {

    @Override
    public void insert() {
        System.out.println("user insert");
    }
}
