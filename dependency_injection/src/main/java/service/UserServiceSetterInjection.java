package service;

import dao.impl.User2Impl;
import dao.impl.UserImpl;

public class UserServiceSetterInjection {

    private UserImpl userImpl;
    private User2Impl user2Impl;

    public void setUserImpl(UserImpl userImpl) {
        this.userImpl = userImpl;
    }

    public void setUser2Impl(User2Impl user2Impl) {
        this.user2Impl = user2Impl;
    }

    public void saveUser() {
        userImpl.insert();
        user2Impl.insert();
    }

}
