package com.skillovilla.course.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@NamedQueries({
        @NamedQuery(name = "GET_COURSE_CHARGES_FOR_COURSE_ID",query = "SELECT COC FROM CourseCharges COC Where COC.course.courseID = :courseID")
})

@Entity
@Table(name = "CourseCharges")
public class CourseCharges implements Serializable {
    private static final long serialVersionUID = -2699625004466081158L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CourseChargesID")
    private int courseChargesID;

    @ManyToOne
    @JoinColumn(name = "CourseID")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "ChargeID")
    private Charge charge;

    @Column(name = "Price",nullable = true)
    private BigDecimal price;

    public int getCourseChargesID() {
        return courseChargesID;
    }

    public void setCourseChargesID(int courseChargesID) {
        this.courseChargesID = courseChargesID;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Charge getCharge() {
        return charge;
    }

    public void setCharge(Charge charge) {
        this.charge = charge;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
