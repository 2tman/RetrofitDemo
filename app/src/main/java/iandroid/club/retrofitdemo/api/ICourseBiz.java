package iandroid.club.retrofitdemo.api;

import java.util.List;

import iandroid.club.retrofitdemo.bean.ChapterList;
import iandroid.club.retrofitdemo.bean.Course;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @Description: 一般的get请求
 * @Author: 加荣
 * @Time: 2017/11/1
 */
public interface ICourseBiz {

    /**
     * 1.一般get请求
     * @return
     */
    @GET("list") //http://192.168.0.107:8080/courses/list
    Call<List<ChapterList>> getChapterList();

    /**
     * 2.动态url访问
     * @return
     */
    @GET("{id}") //http://192.168.0.107:8080/courses/1
    Call<Course> getCourse(@Path("id") int id);

    /**
     * 3.url传参查询
     * @param courseId
     * @return
     */
    @GET("view4")//http://192.168.0.107:8080/courses/view4?courseId=1
    Call<Course> getCourseByQuery(@Query("courseId") int courseId);

    /**
     *4. json数据保存
     * @param course
     * @return
     */
    @POST("saved")//http://192.168.0.107:8080/courses/view4?courseId=1
    Call<Course> postCourse(@Body Course course);

    /**
     *5. 表单数据保存
     * @param title
     * @return
     */
    @POST("saved2")//http://192.168.0.107:8080/courses/view4?courseId=1
    @FormUrlEncoded
    Call<Course> postCourse2(@Field("title") String title);


    /**
     * 单文件混合上传 多个@Part，每个Part对应一个RequestBody
     * @param photo
     * @param article
     * @return
     */
    @Multipart  //允许多个@Part，第一个未上传的文件，其余两个均为简单的键值对
    @POST("doUploadSingle")
    Call<Course> doUpload(@Part MultipartBody.Part photo, @Part("title") RequestBody article);
}
