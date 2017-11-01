package iandroid.club.retrofitdemo;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {


    /**
     * 该方法在每次测试方法调用前都会调用
     */
    @Before
    public void init(){

        System.out.println("------method init called------");
    }

    /**
     * 该方法在所有测试方法之前调用，只会被调用一次
     */
    @BeforeClass
    public static void prepareDataForTest(){
        System.out.println("------method prepareDataForTest called------\n");
    }

    /**
     * 说明了该方法需要测试
     */
    @Test
    public void test1(){
        System.out.println("------method test1 called------");
        RetrofitTest.getChapterList();
    }

    @Test
    public void test2() {
        System.out.println("------method test2 called------");
    }

    @Test
    public void test3() {
        System.out.println("------method test3 called------");
    }

    /**
     * 该方法在每次测试方法调用后都会调用
     */
    @After
    public void clearDataForTest(){
        System.out.println("------method clearDataForTest called------");
    }

    /**
     * 该方法在所有测试方法之后调用，只会被调用一次
     */
    @AfterClass
    public static void finish(){
        System.out.println("------method finish called------");
    }
}