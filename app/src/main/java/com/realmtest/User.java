package com.realmtest;


import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Create by MasterMan
 * Description:
 * 　　①　创建一个Realm的模型类
 * Email: MatthewCaoYongren@gmail.com
 * Blog: http://blog.csdn.net/zhenxi2735768804/
 * Githup: https://github.com/caoyongren
 * Motto: 坚持自己的选择, 不动摇！
 * Date: 2017年１１月２７日
 */
public class User extends RealmObject {
    //注意: 主键必须添加注解
    //这里可以联系数据中的字段
    /**
    * 主键: @PrimaryKey进行注解
     * 其他字段: @Required
     * @Ignore:　可以忽略
    * */
    @PrimaryKey
    private int id;//主键id

    @Required    //注解设为Required代表必须项
    private String name;//姓名

    private int age;//年龄

    @Ignore   //表示忽视项,数据库不会存储该字段
    private boolean hasGrilFriend;//是否有女朋友

    public User() {
    }

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public User(String name, int id, int age, boolean hasGrilFriend) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.hasGrilFriend = hasGrilFriend;
    }

    public boolean isHasGrilFriend() {
        return hasGrilFriend;
    }

    public void setHasGrilFriend(boolean hasGrilFriend) {
        this.hasGrilFriend = hasGrilFriend;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", hasGrilFriend=" + hasGrilFriend +
                '}';
    }
}
