package com.skillovilla.course.util;

import com.skillovilla.course.model.Course;
import com.skillovilla.course.viewModel.coursePricing.CourseDetails;
import com.skillovilla.course.viewModel.coursePricing.CoursePricingResponse;
import org.springframework.stereotype.Component;

@Component
public class ResponseUtility {

    public CoursePricingResponse generateCourseResponse(Course course){
        CoursePricingResponse coursePricingResponse = null;
        if(course!=null){
            coursePricingResponse = new CoursePricingResponse();
            CourseDetails courseDetails = new CourseDetails();
            courseDetails.setCourseID(course.getCourseID());
            courseDetails.setName(course.getCourseName());
            courseDetails.setDescription(course.getCourseDescription());
            coursePricingResponse.setCourseDetails(courseDetails);
        }
        return coursePricingResponse;
    }

}
