package com.skillovilla.course.viewModel.coursePricing;

import java.io.Serializable;

public class CoursePricingResponse implements Serializable {
    private static final long serialVersionUID = -1048333367944435428L;

    private CourseDetails courseDetails;

    private PricingDetails pricingDetails;

    private StrategyDetails strategyDetails;

    public CourseDetails getCourseDetails() {
        return courseDetails;
    }

    public void setCourseDetails(CourseDetails courseDetails) {
        this.courseDetails = courseDetails;
    }

    public PricingDetails getPricingDetails() {
        return pricingDetails;
    }

    public void setPricingDetails(PricingDetails pricingDetails) {
        this.pricingDetails = pricingDetails;
    }

    public StrategyDetails getStrategyDetails() {
        return strategyDetails;
    }

    public void setStrategyDetails(StrategyDetails strategyDetails) {
        this.strategyDetails = strategyDetails;
    }
}
