package com.skillovilla.course.dao;

import com.skillovilla.course.model.*;
import com.skillovilla.course.util.StringUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;


@Component
public class CoursePricingDAO {

    @Autowired
    private StringUtil stringUtil;

    public Course getCourseDetailsByCourseID(int courseID, Session session)throws HibernateException {
        Course course = null;
        if(courseID>0 && session!=null){
            Query query = session.getNamedQuery("GET_SINGLE_COURSE_BY_COURSE_ID");
            query.setParameter("courseID",courseID);
            List<Course> courseList = query.list();
            if(courseList!=null && !courseList.isEmpty()){
                course = courseList.get(0);
            }
        }
        return course;
    }

    public List<CourseCharges> getListOfCourseChargesForCourseID(int courseID,Session session) throws HibernateException{
        List<CourseCharges> courseChargesList = null;
        if(session!=null && courseID>0){
            Query query = session.getNamedQuery("GET_COURSE_CHARGES_FOR_COURSE_ID");
            query.setParameter("courseID",courseID);
            courseChargesList = query.list();
        }
        return courseChargesList;
    }

    public CoursesStrategy getCourseStrategyForCourseID(int courseID, Session session) throws HibernateException{
        CoursesStrategy coursesStrategy = null;
        if(session!=null && courseID>0){
            Query query = session.getNamedQuery("GET_SINGLE_COURSE_STRATEGY_FOR_COURSE_ID");
            query.setParameter("courseID",courseID);
            List<CoursesStrategy> coursesStrategyList = query.list();
            if(coursesStrategyList!=null && !coursesStrategyList.isEmpty()){
                coursesStrategy = coursesStrategyList.get(0);
            }
        }
        return coursesStrategy;
    }

    public List<Charge> getListOfChargeDetailsForListOfChargeIDs(Set<Integer> chargeIDs,Session session) throws HibernateException{
        List<Charge> chargeList =null;
        if(session!=null && chargeIDs!=null && !chargeIDs.isEmpty()){
            Query query = session.getNamedQuery("GET_LIST_OF_CHARGE_FOR_LIST_OF_CHARGE_ID");
            query.setParameterList("chargeIDs",chargeIDs);
            chargeList = query.list();
        }
        return chargeList;
    }

    public Strategy getStrategyDetailsForStrategyID(int strategyID, Session session) throws HibernateException{
        Strategy strategy =null;
        if(session!=null && strategyID>0){
            Query query = session.getNamedQuery("GET_STRATEGY_BY_STRATEGY_ID");
            query.setParameter("strategyID",strategyID);
            List<Strategy> strategyList = query.list();
            if(strategyList!=null && !strategyList.isEmpty()){
                strategy = strategyList.get(0);
            }
        }
        return strategy;
    }

    public List<Charge> getListOfDefaultCharges(Session session) throws HibernateException{
        List<Charge> chargeList = null;
        if(session!=null ){
            Query query = session.getNamedQuery("GET_LIST_CHARGE_WHICH_IS_DEFAULT_WITHOUT_COUNTRY");
            chargeList = query.list();
        }
        return chargeList;
    }

    public List<Charge> getListOfDefaultChargesForCountry(Session session) throws HibernateException{
        List<Charge> chargeList = null;
        if(session!=null ){
            Query query = session.getNamedQuery("GET_LIST_CHARGE_WHICH_IS_DEFAULT_FOR_COUNTRY");
            chargeList = query.list();
        }
        return chargeList;
    }

    public Strategy getDefaultStrategy(Session session) throws HibernateException{
        Strategy strategy = null;
        if(session!=null){
            Query query = session.getNamedQuery("GET_DEFAULT_STRATEGY");
            List<Strategy> strategyList = query.list();
            if(strategyList!=null && !strategyList.isEmpty()){
                strategy = strategyList.get(0);
            }
        }
        return strategy;
    }

    public Country getCountryByCountryCode(String countryCode,Session session) throws HibernateException{
        Country country = null;
        if(stringUtil.isNotNull(countryCode) && session!=null){
            Query query = session.getNamedQuery("GET_COUNTRY_BY_COUNTRY_CODE");
            query.setParameter("countryCode",countryCode);
            List<Country> countryList = query.list();
            if(countryList!=null && !countryList.isEmpty()){
                country = countryList.get(0);
            }
        }
        return country;
    }

    public List<CountryCharges> getListOfCountryChargesForCountryID(int countryID,Session session) throws HibernateException{
        List<CountryCharges> countryChargesList = null;
        if(session!=null && countryID>0){
            Query query = session.getNamedQuery("GET_LIST_OF_COUNTRY_CHARGES_FOR_COUNTRY_ID");
            query.setParameter("countryID",countryID);
            countryChargesList = query.list();
        }
        return countryChargesList;
    }

}
