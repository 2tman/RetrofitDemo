package iandroid.club.retrofitdemo;

import android.app.Activity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;

import java.io.File;
import java.io.IOException;
import java.util.List;

import iandroid.club.retrofitdemo.api.ICourseBiz;
import iandroid.club.retrofitdemo.bean.ChapterList;
import iandroid.club.retrofitdemo.bean.Course;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Multipart;

/**
 * @Description:
 * @Author: 加荣
 * @Time: 2017/11/1
 */
public class RetrofitTest {

    public static final String baseUrl = "http://192.168.0.107:8080/courses/";

    /**
     * 除了gson数据转换，还有如下：
     * <p>
     * Gson: com.squareup.retrofit2:converter-gson
     * Jackson: com.squareup.retrofit2:converter-jackson
     * Moshi: com.squareup.retrofit2:converter-moshi
     * Protobuf: com.squareup.retrofit2:converter-protobuf
     * Wire: com.squareup.retrofit2:converter-wire
     * Simple XML: com.squareup.retrofit2:converter-simplexml
     * Scalars (primitives, boxed, and String): com.squareup.retrofit2:converter-scalars
     */
    public static void getChapterList() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ICourseBiz courseBiz = retrofit.create(ICourseBiz.class);
        final Call<List<ChapterList>> call = courseBiz.getChapterList();
        //异步访问
        call.enqueue(new Callback<List<ChapterList>>() {
            @Override
            public void onResponse(Call<List<ChapterList>> call, Response<List<ChapterList>> response) {
                Logger.json(getGson(response.body()));
            }

            @Override
            public void onFailure(Call<List<ChapterList>> call, Throwable t) {
                Logger.e(t.getMessage());
            }
        });
        //同步访问

//        new Thread() {
//            @Override
//            public void run() {
//                super.run();
//                try {
//                    Response<List<ChapterList>> response = call.execute();
//                    Logger.json(response.body().toString());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }.start();

    }

    /**
     * 动态url请求
     */
    public static void getDynamicUrlData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ICourseBiz courseBiz = retrofit.create(ICourseBiz.class);

        Call<Course> courseCall = courseBiz.getCourse(1);
        courseCall.enqueue(new Callback<Course>() {
            @Override
            public void onResponse(Call<Course> call, Response<Course> response) {
                Logger.d("课程："+getGson(response.body()));
            }

            @Override
            public void onFailure(Call<Course> call, Throwable t) {

            }
        });
    }

    /**
     * 动态url请求
     */
    public static void getByUrlQuery(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ICourseBiz courseBiz = retrofit.create(ICourseBiz.class);

        Call<Course> courseCall = courseBiz.getCourseByQuery(1);
        courseCall.enqueue(new Callback<Course>() {
            @Override
            public void onResponse(Call<Course> call, Response<Course> response) {
                Logger.d("课程："+getGson(response.body()));
            }

            @Override
            public void onFailure(Call<Course> call, Throwable t) {

            }
        });
    }


    /**
     * post json数据提交
     */
    public static void postCourse(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ICourseBiz courseBiz = retrofit.create(ICourseBiz.class);

        Course course = new Course();
        course.setTitle("test");
        course.setDescr("desc");

        Call<Course> courseCall = courseBiz.postCourse(course);
        courseCall.enqueue(new Callback<Course>() {
            @Override
            public void onResponse(Call<Course> call, Response<Course> response) {
                Logger.d("课程："+getGson(response.body()));
            }

            @Override
            public void onFailure(Call<Course> call, Throwable t) {

            }
        });
    }


    /**
     * post 表单提交
     */
    public static void postCourseForm(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ICourseBiz courseBiz = retrofit.create(ICourseBiz.class);

        Call<Course> courseCall = courseBiz.postCourse2("hello,world");
        courseCall.enqueue(new Callback<Course>() {
            @Override
            public void onResponse(Call<Course> call, Response<Course> response) {
                Logger.d("课程："+getGson(response.body()));
            }

            @Override
            public void onFailure(Call<Course> call, Throwable t) {

            }
        });
    }

    /**
     * post 文件上传
     */
    public static void postFile(final Activity activity, File file, final ImageView imageView){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ICourseBiz courseBiz = retrofit.create(ICourseBiz.class);


        RequestBody photoRequestBody = RequestBody.create(MediaType.parse("image/jpg"), file);
        MultipartBody.Part photo = MultipartBody.Part.createFormData("file", System.currentTimeMillis()+".png", photoRequestBody);
        Call<Course> courseCall = courseBiz.doUpload(photo,
                RequestBody.create(null, "abcdeft"));
        courseCall.enqueue(new Callback<Course>() {
            @Override
            public void onResponse(Call<Course> call, Response<Course> response) {
                Course course = response.body();
                Logger.d("文件上传结果："+getGson(response.body()));
                Glide.with(activity).load(course.getImgPath()).into(imageView);
            }

            @Override
            public void onFailure(Call<Course> call, Throwable t) {
                Logger.e(t.getMessage());
            }
        });
    }

    private static String getGson(Object obj){
        return new Gson().toJson(obj);
    }
}
