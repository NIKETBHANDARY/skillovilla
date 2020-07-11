package com.skillovilla.course.viewModel.coursePricing;

import java.io.Serializable;

public class CourseDetails implements Serializable {
    private static final long serialVersionUID = -8323672122666356035L;

    private int courseID;
    private String name;
    private String description;

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
