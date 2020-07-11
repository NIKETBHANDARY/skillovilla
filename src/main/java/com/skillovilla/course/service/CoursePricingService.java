package com.skillovilla.course.service;

import com.skillovilla.course.dao.CoursePricingDAO;
import com.skillovilla.course.model.*;
import com.skillovilla.course.util.ResponseUtility;
import com.skillovilla.course.util.StringUtil;
import com.skillovilla.course.viewModel.coursePricing.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CoursePricingService {

    private static final Logger log = LoggerFactory.getLogger(CoursePricingService.class);

    @Autowired
    private CoursePricingDAO coursePricingDAO;

    @Autowired
    private ResponseUtility responseUtility;

    @Autowired
    private StringUtil stringUtil;

    @Autowired
    private EntityManager entityManager;

    public CoursePricingResponse getCoursePricingAndStrategyDetails(int courseID,String countryCode) throws Exception{
        CoursePricingResponse coursePricingResponse = null;
        Session session = null;
        try {
            if (courseID > 0 && stringUtil.isNotNull(countryCode)) {
                session = entityManager.unwrap(Session.class);
                Course course = coursePricingDAO.getCourseDetailsByCourseID(courseID,session);
                Country country = coursePricingDAO.getCountryByCountryCode(countryCode,session);
                if(country==null || (country!=null && country.getCountryID()<=0)){
                    Exception exception = new Exception("Country not supported");
                    throw exception;
                }
                if(course!=null && course.getCourseID()>0){
                    coursePricingResponse = new CoursePricingResponse();
                    CourseDetails courseDetails = new CourseDetails();
                    courseDetails.setCourseID(course.getCourseID());
                    courseDetails.setName(course.getCourseName());
                    courseDetails.setDescription(course.getCourseDescription());

                    coursePricingResponse.setCourseDetails(courseDetails);
                    //finding pricing for course
                    PricingDetails pricingDetails = new PricingDetails();

                    BigDecimal totalPrice = new BigDecimal(0);
                    if(course.getPrice()!=null){
                        pricingDetails.setPrice(course.getPrice().toString());
                        totalPrice = totalPrice.add(course.getPrice());
                    }

                    List<VariablePriceDetails> variablePriceDetailsList = new ArrayList<VariablePriceDetails>();

                    List<CourseCharges> courseChargesList = coursePricingDAO.getListOfCourseChargesForCourseID(course.getCourseID(),session);
                    if(courseChargesList!=null && !courseChargesList.isEmpty()){
                        List<Charge> chargeList = courseChargesList.stream().map(CourseCharges::getCharge).filter(Objects::nonNull).collect(Collectors.toList());
                        if(chargeList!=null && !chargeList.isEmpty()){
                            Set<Integer> chargeIDs = chargeList.stream().map(Charge::getChargeID).filter(Objects::nonNull).collect(Collectors.toSet());
                            if(chargeIDs!=null && !chargeIDs.isEmpty()) {
                                List<Charge> chargesAppliedList = coursePricingDAO.getListOfChargeDetailsForListOfChargeIDs(chargeIDs,session);
                                if(chargesAppliedList!=null && !chargesAppliedList.isEmpty()){
                                    Map<Integer,Charge> chargeMap = chargesAppliedList.stream().collect(Collectors.toMap(Charge::getChargeID, Function.identity()));
                                    if(chargeMap!=null && !chargeMap.isEmpty()){
                                        for(int i=0 ; i<courseChargesList.size();i++){
                                            CourseCharges courseCharges = courseChargesList.set(i,null);
                                            if(courseCharges!=null && courseCharges.getPrice()!=null && courseCharges.getCharge()!=null && courseCharges.getCharge().getChargeID()>0 && chargeMap.containsKey(courseCharges.getCharge().getChargeID())){
                                                Charge charge = chargeMap.get(courseCharges.getCharge().getChargeID()) ;
                                                if(charge!=null) {
                                                    VariablePriceDetails variablePriceDetails = new VariablePriceDetails();
                                                    variablePriceDetails.setName(charge.getName());
                                                    variablePriceDetails.setDesc(charge.getDescription());
                                                    variablePriceDetails.setPrice(courseCharges.getPrice().toString());
                                                    variablePriceDetailsList.add(variablePriceDetails);

                                                    totalPrice = totalPrice.add(courseCharges.getPrice());
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else{
                        List<Charge> chargesAppliedList = coursePricingDAO.getListOfDefaultCharges(session);
                        if(chargesAppliedList!=null && !chargesAppliedList.isEmpty()){
                            for(int i=0;i<chargesAppliedList.size();i++){
                                Charge charge = chargesAppliedList.set(i,null);
                                if(charge!=null && stringUtil.isNotNull(charge.getName()) && charge.getPrice()!=null){
                                    VariablePriceDetails variablePriceDetails = new VariablePriceDetails();
                                    variablePriceDetails.setName(charge.getName());
                                    variablePriceDetails.setDesc(charge.getDescription());
                                    variablePriceDetails.setPrice(charge.getPrice().toString());
                                    variablePriceDetailsList.add(variablePriceDetails);

                                    totalPrice = totalPrice.add(charge.getPrice());
                                }
                            }
                        }
                    }


                    if(!country.isDefault()){
                        List<CountryCharges> countryChargesList = coursePricingDAO.getListOfCountryChargesForCountryID(country.getCountryID(),session);
                        if(countryChargesList!=null && !countryChargesList.isEmpty()){
                            List<Charge> chargeList = countryChargesList.stream().map(CountryCharges::getCharge).filter(Objects::nonNull).collect(Collectors.toList());
                            if(chargeList!=null && !chargeList.isEmpty()) {
                                Set<Integer> chargeIDs = chargeList.stream().map(Charge::getChargeID).filter(Objects::nonNull).collect(Collectors.toSet());
                                if (chargeIDs != null && !chargeIDs.isEmpty()) {
                                    List<Charge> chargesAppliedList = coursePricingDAO.getListOfChargeDetailsForListOfChargeIDs(chargeIDs, session);
                                    if (chargesAppliedList != null && !chargesAppliedList.isEmpty()) {
                                        Map<Integer, Charge> chargeMap = chargesAppliedList.stream().collect(Collectors.toMap(Charge::getChargeID, Function.identity()));
                                        if (chargeMap != null && !chargeMap.isEmpty()) {
                                            for (int i = 0; i < countryChargesList.size(); i++) {
                                                CountryCharges courseCharges = countryChargesList.set(i, null);
                                                if (courseCharges != null && courseCharges.getPrice() != null && courseCharges.getCharge() != null && courseCharges.getCharge().getChargeID() > 0 && chargeMap.containsKey(courseCharges.getCharge().getChargeID())) {
                                                    Charge charge = chargeMap.get(courseCharges.getCharge().getChargeID());
                                                    if (charge != null) {
                                                        VariablePriceDetails variablePriceDetails = new VariablePriceDetails();
                                                        variablePriceDetails.setName(charge.getName());
                                                        variablePriceDetails.setDesc(charge.getDescription());
                                                        variablePriceDetails.setPrice(courseCharges.getPrice().toString());
                                                        variablePriceDetailsList.add(variablePriceDetails);

                                                        totalPrice = totalPrice.add(courseCharges.getPrice());
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        else{
                            List<Charge> chargesAppliedList = coursePricingDAO.getListOfDefaultChargesForCountry(session);
                            if(chargesAppliedList!=null && !chargesAppliedList.isEmpty()){
                                for(int i=0;i<chargesAppliedList.size();i++){
                                    Charge charge = chargesAppliedList.set(i,null);
                                    if(charge!=null && stringUtil.isNotNull(charge.getName()) && charge.getPrice()!=null){
                                        VariablePriceDetails variablePriceDetails = new VariablePriceDetails();
                                        variablePriceDetails.setName(charge.getName());
                                        variablePriceDetails.setDesc(charge.getDescription());
                                        variablePriceDetails.setPrice(charge.getPrice().toString());
                                        variablePriceDetailsList.add(variablePriceDetails);

                                        totalPrice = totalPrice.add(charge.getPrice());
                                    }
                                }
                            }
                        }
                    }

                    if(variablePriceDetailsList!=null && !variablePriceDetailsList.isEmpty()){
                        pricingDetails.setVariablePrices(variablePriceDetailsList);
                    }

                    pricingDetails.setTotalPrice(totalPrice.toString());

                    coursePricingResponse.setPricingDetails(pricingDetails);
                    //END of pricing

                    //finding strategy for course
                    StrategyDetails strategyDetails = null;

                    CoursesStrategy coursesStrategy = coursePricingDAO.getCourseStrategyForCourseID(course.getCourseID(),session);
                    if(coursesStrategy!=null && coursesStrategy.getStrategy()!=null  && coursesStrategy.getStrategy().getStrategyID()>0){
                        Strategy strategy = coursePricingDAO.getStrategyDetailsForStrategyID(coursesStrategy.getStrategy().getStrategyID(),session);
                        if(strategy!=null){
                            strategyDetails = new StrategyDetails();
                            strategyDetails.setName(strategy.getName());
                            strategyDetails.setDescription(strategy.getDescription());
                        }
                    }
                    else{
                        Strategy strategy = coursePricingDAO.getDefaultStrategy(session);
                        if(strategy!=null){
                            strategyDetails = new StrategyDetails();
                            strategyDetails.setName(strategy.getName());
                            strategyDetails.setDescription(strategy.getDescription());
                        }
                    }

                    if(strategyDetails!=null){
                        coursePricingResponse.setStrategyDetails(strategyDetails);
                    }

                }
                else{
                    Exception exception = new Exception("Course ID is invalid");
                    throw exception;
                }
            }
        }
        catch (HibernateException e){
            log.error("Exception while fetching pricing for course",e);
        }
        finally {
            if(session!=null){
                session.close();
            }
        }
        return coursePricingResponse;
    }

}
