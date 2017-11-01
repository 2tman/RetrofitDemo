/**
  * Copyright 2017 bejson.com 
  */
package iandroid.club.retrofitdemo.bean;

/**
 * 课程列表
 */
public class ChapterList {

    private int id;
    private int courseId;
    private int order;
    private String title;
    private String descr;
    public void setId(int id) {
         this.id = id;
     }
     public int getId() {
         return id;
     }

    public void setCourseId(int courseId) {
         this.courseId = courseId;
     }
     public int getCourseId() {
         return courseId;
     }

    public void setOrder(int order) {
         this.order = order;
     }
     public int getOrder() {
         return order;
     }

    public void setTitle(String title) {
         this.title = title;
     }
     public String getTitle() {
         return title;
     }

    public void setDescr(String descr) {
         this.descr = descr;
     }
     public String getDescr() {
         return descr;
     }

}