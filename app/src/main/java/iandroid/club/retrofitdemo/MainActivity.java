package iandroid.club.retrofitdemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import org.json.JSONObject;

import java.io.File;

import iandroid.club.rxjava10module.RxUtilActivity;

public class MainActivity extends AppCompatActivity {

    private Context mContext;
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        mImageView = (ImageView)findViewById(R.id.mImageView);
        initView();
    }

    private void initView(){
        /**
         * 一般get请求
         */
        findViewById(R.id.btn_get).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrofitTest.getChapterList();
            }
        });

        /**
         * 动态url请求
         */
        findViewById(R.id.btn_get_dynamic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrofitTest.getDynamicUrlData();
            }
        });

        /**
         * url传参查询
         */
        findViewById(R.id.btn_url_param).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrofitTest.getByUrlQuery();
            }
        });

        /**
         * post测试
         */
        findViewById(R.id.btn_post).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrofitTest.postCourse();
            }
        });

        /**
         * 表单post测试
         */
        findViewById(R.id.btn_post_form).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrofitTest.postCourseForm();
            }
        });

        /**
         * 单文件上传
         */
        findViewById(R.id.btn_post_file).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrofitTest.postFile(MainActivity.this, new File("/storage/emulated/0/Pictures/1508933060968.jpg"), mImageView);
            }
        });

        /**
         * 多文件上传
         */
        findViewById(R.id.btn_post_multifile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrofitTest.postMultiFile(MainActivity.this, new File("/storage/emulated/0/Pictures/1508933060968.jpg"), mImageView);
            }
        });

        /**
         * retrofit文件下载
         */
        findViewById(R.id.btn_down_load).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrofitTest.doDownloadTest();
            }
        });

        /**
         * okhttp文件下载
         */
        findViewById(R.id.btn_down_load_okhttp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        findViewById(R.id.btn_rxjava1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, RxUtilActivity.class));
            }
        });
    }
}
