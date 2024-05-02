package demon.service.impl;

import demon.dao.UserDao;
import demon.pojo.User;
import demon.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("userService2")
public class UserServiceImpl2 implements UserService {

    @Resource(name = "userDao")
    private UserDao userDao;

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
        userDao.updateBalance(2, 2000);
//        int a = 1/0;
        try {
            Thread.sleep(1000 * 30);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void isolationTest() {

    }

    @Override
    public void timeoutTest() {

    }

    @Override
    public void readonlyTest() {

    }

    @Override
    public void rollbackforTest() {

    }

    @Override
    public void noRollbackforTest() {

    }

}
