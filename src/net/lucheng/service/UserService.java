package net.lucheng.service;

import net.lucheng.bean.User;
import net.lucheng.dao.UserDao;

import java.sql.SQLException;

public class UserService {
    public boolean register(User sa){
        boolean register = false;
        UserDao userDao= new UserDao();
        boolean checkUser = userDao.checkUser(sa.getName());
        if (checkUser) {
            register = userDao.register(sa);
        }
        return register;
    }

    public User login(User sa) throws SQLException {
        UserDao userDao = new UserDao();
        User user = userDao.login(sa);
        return  user;
    }
}
