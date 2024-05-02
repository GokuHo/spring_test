package demon.service.impl;

import demon.dao.UserDao;
import demon.pojo.User;
import demon.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource(name = "userDao")
    private UserDao userDao;

    @Resource(name = "userService2")
    private UserService userService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED) // defalut
    public void transfer(int fromId, int toId, double money) {
        User fromUser = userDao.selectById(fromId);
        if(fromUser.getBalance() < money) throw new RuntimeException("from user have not enough money");

        User toUser = userDao.selectById(toId);
        int resultCount = userDao.updateBalance(fromUser.getId(), fromUser.getBalance() - money);
//        int a = 1/0;
        resultCount += userDao.updateBalance(toUser.getId(), toUser.getBalance() + money);

        if(resultCount != 2) throw new RuntimeException("transfer error");

        System.out.println("transfer successfully");
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void setBalance() {
        userDao.updateBalance(1, 2000);
        userService.setBalance();
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void isolationTest() {
        User user = userDao.selectById(2);
        System.out.println(user);
    }

    @Override
    @Transactional(timeout = 10)
    public void timeoutTest() {
        userDao.updateBalance(1, 10);
        try {
            Thread.sleep(1000 * 11);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public void readonlyTest() {
        userDao.selectById(1);
//        userDao.updateBalance(1, 20);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void rollbackforTest() throws IOException {
        userDao.updateBalance(1, 30);

        throw new RuntimeException();
//        throw new IOException();
    }

    @Override
    @Transactional(noRollbackFor = RuntimeException.class)
    public void noRollbackforTest() throws IOException {
        userDao.updateBalance(1, 40);

//        throw new RuntimeException();
        throw new IOException();
    }
}
