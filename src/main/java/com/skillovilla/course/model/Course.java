package com.skillovilla.course.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@NamedQueries({
        @NamedQuery(name = "GET_SINGLE_COURSE_BY_COURSE_ID",query = "SELECT COR From Course COR where COR.courseID = :courseID")
})

@Entity
@Table(name = "Course")
public class Course implements Serializable {
    private static final long serialVersionUID = -7016460323173003769L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CourseID")
    private int courseID;

    @Column(name = "CourseName")
    private String courseName;

    @Column(name = "CourseDescription",nullable = true)
    private String courseDescription;

    @Column(name = "Price",nullable = true)
    private BigDecimal price;


    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
