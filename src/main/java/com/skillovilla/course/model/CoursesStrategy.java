package com.skillovilla.course.model;

import javax.persistence.*;
import java.io.Serializable;

@NamedQueries({
        @NamedQuery(name = "GET_SINGLE_COURSE_STRATEGY_FOR_COURSE_ID",query = "SELECT COS FROM CoursesStrategy COS Where COS.course.courseID = :courseID")
})


@Entity
@Table(name = "CoursesStrategy")
public class CoursesStrategy implements Serializable {
    private static final long serialVersionUID = 7370703859516014013L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CoursesStrategyID")
    private int coursesStrategyID;

    @ManyToOne
    @JoinColumn(name = "CourseID")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "StrategyID")
    private Strategy strategy;

    public int getCoursesStrategyID() {
        return coursesStrategyID;
    }

    public void setCoursesStrategyID(int coursesStrategyID) {
        this.coursesStrategyID = coursesStrategyID;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
