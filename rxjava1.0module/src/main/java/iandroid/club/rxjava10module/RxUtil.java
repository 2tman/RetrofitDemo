package iandroid.club.rxjava10module;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * @Description:
 * @Author: 2tman
 * @Time: 2018/3/6
 */
public class RxUtil {

    public static final String TAG = RxUtil.class.getSimpleName();

    /**
     * ============================步骤1.创建Observer 观察者
     */


    /**
     * rxjava的基本用法分为如下3个步骤
     */
    public void test1(){
        /*
        1.创建Observer（观察者）
         */
        Subscriber<String> subscriber = new Subscriber<String>() {

            /*
            在事件还未发送之前被调用，可以用于做一些准备工具，例如数据的清零或重置。
            这是一个可选方法。
             */
            @Override
            public void onStart() {
                super.onStart();
                Log.d(TAG, "onStart");
            }

            /*
                        事件队列完结。
                        当不会再有新的onNext发出时，触发onCompleted
                         */
            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted");
            }

            /*
            事件队列异常。

             */
            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError");
            }

            /*
            普通的事件，将要处理的事件添加到事件队列中。
             */
            @Override
            public void onNext(String str) {
                Log.d(TAG, "onNext:"+str);
            }
        };
        createObservable(subscriber);
    }

    /**
     * 如果要实现简单的功能，也可以用Observer来创建观察者。
     * Subscriber是在Observer的基础上进行了扩展。
     * 在Subscribe订阅过程中Observer也会先被转换未Subscriber来使用。
     */
    public void test2(){
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError");
            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "onNext");
            }
        };
    }

    /**
     * ============================步骤2.创建Observable (被观察者)
     * 它决定什么时候触发事件以及触发怎样的事件。。
     */
    public Observable createObser(){
        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {

                subscriber.onNext("baby");
                subscriber.onNext("杨幂");
                subscriber.onNext("李若彤");
                subscriber.onCompleted();
            }
        });
        return observable;
    }

    public void createObservable(Subscriber subscriber ){


        //3.Subscribe订阅
        createObser().subscribe(subscriber);
    }

    /**
     * 通过Action的方式
     * 从Action/Action0/Action1....到Action9、ActionN
     * 数值代表这个方法有几个参数
     */
    public void test3(){
        Action1<String> onNextAction = new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d(TAG, "onNextAction:"+s);
            }
        };

        Action1<Throwable> onErrorAction = new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Log.d(TAG, "onErrorAction:"+throwable);
            }
        };

        Action0 onComplectedAction = new Action0() {
            @Override
            public void call() {
                Log.d(TAG, "onComplectedAction");
            }
        };

        //方法一
        createObser().subscribe(onNextAction);
        //方法二
        createObser().subscribe(onNextAction, onErrorAction);
        //方法三
        createObser().subscribe(onNextAction, onErrorAction, onComplectedAction);
    }

    /**
     * Subject 既可以是一个Observer 也可以是一个Observable
     * 它是连接Observer 和 Observable的桥梁
     * Subject可以被理解为：Subject= Observable + Observer
     * 提供以下4种Subject
     */

    /*
    1.PublishSubject
     */

    /*
    2.BehaviorSubject
     */

    /*
    3.ReplaySubject
     */

    /*
    4.AsyncSubject
     */


    /**
     * RxJava操作符
     */

    /*
    1.interval
    每隔几秒调用call方法
     */
    public void intervalTest(){
        Observable.interval(3, TimeUnit.SECONDS)
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        Log.d(TAG, "interval:"+aLong.intValue());
                    }
                });
    }

    /*
    2.range
    从0 开始，打印5次递增数据
    0、1、2、3、4
     */
    public void rangeTest(){
        Observable.range(0, 5)
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        Log.d(TAG, "range:"+integer.intValue());
                    }
                });
    }

    /*
    3.repeat
    创建一个N次重复发射特定数据的Observable
     */
    public void repeatTest(){
        Observable.range(0, 3)
                .repeat(2)
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        Log.d(TAG, "repeat:"+integer.intValue());
                    }
                });
    }

    final String Host = "http://blog.csdn.net/";

    /**
     * 变换操作符
     * 作用是对Observable发射的数据按照一定规则做一些变换操作，
     * 然后将变换后的数据发射出去
     * 变换操作符有map、flatMap、concatMap、switchMap、flatMapIterable、buffer、
     * groupBy、cast、window、scan等
     */

    public void test4(){
        /*
        map 通过指定一个Func对象，将Observable转换为一个新的Observable对象并发射
        观察者将收到新的Observable处理。
         */

        Observable.just("itachi85").map(new Func1<String, String>() {
            @Override
            public String call(String s) {
                return Host+s;
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                //http://blog.csdn.net/itachi85
                Log.d(TAG, "map:"+s);
            }
        });


    }

    public void test5(){
         /*
        flatMap/cst
        flatMap将Observable发射的数据集合变换为Observable集合，然后将这些Observable发射的数据
        平坦化地放进一个单独的Observable。cast操作符的作用是强制将Observable发射的所有数据转换为
        指定类型。

        允许交叉发送事件，最终结果的顺序可能并不是原始的Observable发送时的顺序。
         */

        List<String> mlist = new ArrayList<>();
        mlist.add("video");
        mlist.add("photo");
        mlist.add("article");

        Observable.from(mlist).flatMap(new Func1<String, Observable<?>>() {
            @Override
            public Observable<?> call(String s) {
                return Observable.just(Host+s);
            }
        }).cast(String.class).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d(TAG, "flatMap:"+s);
            }
        });
    }

    public static void main(String[] args){
        new RxUtil().test5();
    }
}
