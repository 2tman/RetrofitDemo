package iandroid.club.retrofitdemo;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * @Description:
 * @Author: 加荣
 * @Time: 2017/11/1
 */
public class AppContext extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.addLogAdapter(new AndroidLogAdapter());
    }
}
