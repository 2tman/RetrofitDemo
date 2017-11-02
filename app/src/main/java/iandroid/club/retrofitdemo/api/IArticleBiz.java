package iandroid.club.retrofitdemo.api;

import iandroid.club.retrofitdemo.bean.Course;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @Description: 文章处理
 * @Author: 加荣
 * @Time: 2017/11/2
 */
public interface IArticleBiz {

    /**
     * 动态url访问
     * @return
     */
    @GET("{blogid}")
    Call<String> getArticles(@Path("blogid") String id);


}
