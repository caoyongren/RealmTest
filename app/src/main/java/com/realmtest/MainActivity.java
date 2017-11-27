package com.realmtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.sql.SQLException;
/**
 * Create by MasterMan
 * Description:
 *   ⑤使用
 * Email: MatthewCaoYongren@gmail.com
 * Blog: http://blog.csdn.net/zhenxi2735768804/
 * Githup: https://github.com/caoyongren
 * Motto: 坚持自己的选择, 不动摇！
 * Date:
 */
public class MainActivity extends AppCompatActivity {
    private UserDao userDao;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.text);

        userDao = new UserDaoImpl(this);
        //异常
        try {
            userDao.deleteAll();//先删除所有，以免demo出现主键已经存在的异常
            User user = new User();
            user.setId(10);//id主键
            user.setName("master");//name 名字
            user.setAge(22);//年龄
            user.setHasGrilFriend(true);//性别
            userDao.insert(user);//插入

            Log.d("DEBUG","插入小刺猬----"+userDao.getAllUser().toString());
            mTextView.setText("insert: " + userDao.getAllUser().toString());

            for (int i = 0; i < 5; i++) {
                userDao.insert(new User(i,"master"+i,20+i));
            }

            Log.d("DEBUG","插入5个对象----"+userDao.getAllUser().toString());
            Log.d("DEBUG","查询1----"+userDao.findByNameOrAge("master",20));
            Log.d("DEBUG","查询2----"+userDao.findByNameOrAge("master",23));
            userDao.updateUser("master","master");//更新
            Log.d("DEBUG","更新1----"+userDao.findByNameOrAge("master",23));

            userDao.deleteUser(0);//删除0
            Log.d("DEBUG","删除后查看----"+userDao.getAllUser().toString());


            //统一关闭事务
            userDao.closeRealm();//如果忘记关闭容易造成内存给泄露
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
