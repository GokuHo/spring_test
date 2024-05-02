package demon.dao;

import demon.pojo.User;

public interface UserDao {

    User selectById(int id);
    int updateBalance(int id, double money);
}
