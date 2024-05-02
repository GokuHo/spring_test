package demon.service.impl;

import demon.dao.UserDao;
import demon.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

//    @Autowired
//    @Qualifier("userDaoImpl")
//    private UserDao userDao;

//    @Resource()
//    private UserDao userDaoImpl;

    @Resource(name = "userDaoImpl")
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("User service...");
        userDao.add();
    }
}
