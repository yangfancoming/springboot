package com.goat.example03;

/**
 * Created by 64274 on 2018/9/13.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/9/13---19:27
 */

public class Course {
    private String course;
    private String score;
    private String level;

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Grade{" + "course='" + course + '\'' + ", score='" + score + '\'' + ", level='" + level + '\'' + '}';
    }
}