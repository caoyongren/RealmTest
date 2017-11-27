package com.realmtest;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;


/**
 * Create by MasterMan
 * Description:
 *   ②　实现一个工具类
 * Email: MatthewCaoYongren@gmail.com
 * Blog: http://blog.csdn.net/zhenxi2735768804/
 * Githup: https://github.com/caoyongren
 * Motto: 坚持自己的选择, 不动摇！
 * Date:  ２０１７年１１月
 */
public class RealmUtils {
    private Context context;
    private static RealmUtils mInstance;
    private String realName = "myRealm.realm";

    private RealmUtils(Context context){
        this.context = context;
    }

    public static RealmUtils getInstance(Context context){
        if (mInstance == null){
            synchronized (RealmUtils.class){
                if (mInstance == null){
                    mInstance = new RealmUtils(context);
                }
            }
        }
        return mInstance;
    }

    /**
     * 获得Realm对象
     * @return
     */
    public Realm getRealm(){
        //Realm.getInstance(new RealmConfiguration.Builder(context).name(realName).build());
        Realm.init(context);
       /* return Realm.getInstance(new RealmConfiguration.Builder(context)
                .name(realName)
                .build());*/
        // create your Realm configuration
        RealmConfiguration config = new RealmConfiguration.
                Builder().
                deleteRealmIfMigrationNeeded().
                build();
        //Realm.setDefaultConfiguration(config);
        return Realm.getInstance(config);

    }
}
