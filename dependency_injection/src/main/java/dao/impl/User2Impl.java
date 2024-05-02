package dao.impl;

import dao.UserDao;

public class User2Impl implements UserDao {

    @Override
    public void insert() {
        System.out.println("user2 insert");
    }
}
