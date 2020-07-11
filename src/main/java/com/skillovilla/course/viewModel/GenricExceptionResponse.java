package com.skillovilla.course.viewModel;

import java.io.Serializable;

public class GenricExceptionResponse implements Serializable {
    private static final long serialVersionUID = 6081663278520393061L;

    private String code;

    private String moreInfo;

    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
