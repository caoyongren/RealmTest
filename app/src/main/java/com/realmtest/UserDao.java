package com.realmtest;

import java.sql.SQLException;
import java.util.List;

/**
 * Create by MasterMan
 * Description:
 *   ③使用Dao模式
 * Email: MatthewCaoYongren@gmail.com
 * Blog: http://blog.csdn.net/zhenxi2735768804/
 * Githup: https://github.com/caoyongren
 * Motto: 坚持自己的选择, 不动摇！
 * Date: ２０１７年１１月２７日
 */
public interface UserDao {

    /**
     * 插入一个用户
     * @param user    需要插入的用户对象
     * @throws SQLException
     */
    void insert(User user) throws SQLException;

    /**
     * 获得所有的用户列表
     * @return 用户列表
     * @throws SQLException
     */
    List<User> getAllUser() throws SQLException;

    /**
     * 更新一个用户
     * @param user 需要更新的用户类
     * @return      更新后的对象
     * @throws SQLException
     */
    User updateUser(User user) throws SQLException;

    /**
     * 根据姓名修改新姓名
     * @param name1 老名字
     * @param name2 新名字
     * @throws SQLException
     */
    void updateUser(String name1, String name2) throws SQLException;

    /**
     * 根据id删除用户
     * @param id 用户主键
     * @throws SQLException
     */
    void deleteUser(int id) throws SQLException;

    /**
     * 异步添加用户
     * @param user 需要添加的用户对象
     * @throws SQLException
     */
    void insertUserAsync(User user) throws SQLException;

    /**
     * 按名字或者年龄查找第一个User
     */
    User findByNameOrAge(String name1, int age1) throws SQLException;

    /**
     * 清楚所有
     * @throws SQLException
     */
    void deleteAll() throws SQLException;

    /**
     * 关闭事务
     */
    void closeRealm();
}
