package com.skillovilla.course.controller;

import com.skillovilla.course.constant.APIStatus;
import com.skillovilla.course.constant.URLConstant;
import com.skillovilla.course.service.CoursePricingService;
import com.skillovilla.course.viewModel.GenericGenericResponse;
import com.skillovilla.course.viewModel.GenricExceptionResponse;
import com.skillovilla.course.viewModel.coursePricing.CoursePricingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CoursePricingController implements URLConstant {

    @Autowired
    private CoursePricingService coursePricingService;

    @RequestMapping(name = GET_PRICING_DETAILS_FOR_COURSE_URL,value = GET_PRICING_DETAILS_FOR_COURSE_URL,produces = {MediaType.APPLICATION_JSON_VALUE},method = RequestMethod.GET)
    public @ResponseBody  GenericGenericResponse coursePriceDetails(@RequestParam(name = "courseID") int courseID, @RequestParam(name = "countryCode") String countryCode){
        GenericGenericResponse<CoursePricingResponse> genericGenericResponse = new GenericGenericResponse<CoursePricingResponse>();
        try{
            CoursePricingResponse coursePricingResponse = coursePricingService.getCoursePricingAndStrategyDetails(courseID,countryCode);
            if(coursePricingResponse!=null){
                genericGenericResponse.setStatus(APIStatus.SUCCESS);
                genericGenericResponse.setPayload(coursePricingResponse);
            }
            else{
                GenricExceptionResponse genricExceptionResponse = new GenricExceptionResponse();
                genricExceptionResponse.setMessage("There is no pricing for course provided");
                genericGenericResponse.setException(genricExceptionResponse);
                genericGenericResponse.setStatus(APIStatus.ERROR);
            }
        }
        catch (Exception e){
            GenricExceptionResponse genricExceptionResponse = new GenricExceptionResponse();
            genricExceptionResponse.setMessage(e.getMessage());
            genericGenericResponse.setException(genricExceptionResponse);
            genericGenericResponse.setStatus(APIStatus.ERROR);
        }
        return genericGenericResponse;
    }
}
