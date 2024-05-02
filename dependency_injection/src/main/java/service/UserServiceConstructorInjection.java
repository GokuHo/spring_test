package service;

import dao.impl.User2Impl;
import dao.impl.UserImpl;

public class UserServiceConstructorInjection {

    private UserImpl userImpl;
    private User2Impl user2Impl;

    public UserServiceConstructorInjection(UserImpl userImpl, User2Impl user2Impl) {
        this.userImpl = userImpl;
        this.user2Impl = user2Impl;
    }

    public void saveUser() {
        userImpl.insert();
        user2Impl.insert();
    }
}
