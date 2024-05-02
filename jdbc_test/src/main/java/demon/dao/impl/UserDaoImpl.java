package demon.dao.impl;

import demon.dao.UserDao;
import demon.pojo.User;
import jakarta.annotation.Resource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public User selectById(int id) {
        String sql = "select * from User where id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
    }

    @Override
    public int updateBalance(int id, double money) {
        String sql = "update User set balance = ? where id = ?";
        return jdbcTemplate.update(sql, money, id);
    }
}
