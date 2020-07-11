package com.skillovilla.course.util;

import org.springframework.stereotype.Component;

@Component
public class StringUtil {

    public boolean isNotNull(String value){
        boolean isNotNull = false;
        if(value!=null && value.length()>0){
            isNotNull = true;
        }
        return isNotNull;
    }
}
