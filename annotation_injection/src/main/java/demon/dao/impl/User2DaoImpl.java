package demon.dao.impl;

import demon.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class User2DaoImpl implements UserDao {

    @Override
    public void add() {
        System.out.println("User2 dao...");
    }
}
