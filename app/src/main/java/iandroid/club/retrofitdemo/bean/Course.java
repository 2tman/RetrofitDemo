/**
  * Copyright 2017 bejson.com 
  */
package iandroid.club.retrofitdemo.bean;
import java.util.List;

/**
 * 课程
 */
public class Course {

    private int courseId;
    private String title;
    private String imgPath;
    private int learningNum;
    private int duration;
    private int level;
    private String levelDesc;
    private String descr;
    private List<ChapterList> chapterList;
    public void setCourseId(int courseId) {
         this.courseId = courseId;
     }
     public int getCourseId() {
         return courseId;
     }

    public void setTitle(String title) {
         this.title = title;
     }
     public String getTitle() {
         return title;
     }

    public void setImgPath(String imgPath) {
         this.imgPath = imgPath;
     }
     public String getImgPath() {
         return imgPath;
     }

    public void setLearningNum(int learningNum) {
         this.learningNum = learningNum;
     }
     public int getLearningNum() {
         return learningNum;
     }

    public void setDuration(int duration) {
         this.duration = duration;
     }
     public int getDuration() {
         return duration;
     }

    public void setLevel(int level) {
         this.level = level;
     }
     public int getLevel() {
         return level;
     }

    public void setLevelDesc(String levelDesc) {
         this.levelDesc = levelDesc;
     }
     public String getLevelDesc() {
         return levelDesc;
     }

    public void setDescr(String descr) {
         this.descr = descr;
     }
     public String getDescr() {
         return descr;
     }

    public void setChapterList(List<ChapterList> chapterList) {
         this.chapterList = chapterList;
     }
     public List<ChapterList> getChapterList() {
         return chapterList;
     }

}