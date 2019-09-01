package com.lxgzhw.dao;

import com.lxgzhw.login.domain.User;
import com.lxgzhw.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/*
操作数据库中的users表
 */
public class UserDao {
    //1.声明JDBCTemplate对象共用
    private JdbcTemplate template =
            new JdbcTemplate(JDBCUtils.getDataSource());

    //2.登录方法
    /**
     * 用户登录
     *
     * @param loginUser 登录的用户对象
     * @return 登录的用户对象数据库信息包装
     */
    public User login(User loginUser) {
        try {
            //1.编写sql
            String sql = "select id,username,password from users where username=? and password=?";
            //2.调用query方法
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(),
                    loginUser.getPassword());
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
