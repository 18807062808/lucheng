package net.lucheng.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import net.lucheng.bean.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao {
    public boolean checkUser(String name){
        try {
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            QueryRunner queryRunner = new QueryRunner(dataSource);
            String sql = "select name from user where user = ?";
            User sa = queryRunner.query(sql, new BeanHandler<User>(User.class), name);
            if (sa == null)
            {
                return  true;
            } else {
                return  false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean register(User sa) {
        try {
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            QueryRunner queryRunner = new QueryRunner(dataSource);
            String sql = "insert into user values (null,?,?,?,?)";
            int row = queryRunner.update(sql, sa.getUser(), sa.getPassword(), sa.getName(), sa.getPhone());
            if (row > 0){
                return true;
            } else
            {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public User login(User sa) throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);
        String sql = "select * from user where user= ? and password = ?";
        User user = queryRunner.query(sql, new BeanHandler<User>(User.class), sa.getUser(), sa.getPassword());
        return user;
    }
}
