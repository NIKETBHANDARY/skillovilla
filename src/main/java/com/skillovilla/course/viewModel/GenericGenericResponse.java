package com.skillovilla.course.viewModel;




import com.skillovilla.course.constant.APIStatus;

import java.io.Serializable;

public class GenericGenericResponse<T> implements Serializable {
    private static final long serialVersionUID = 8281813696155510978L;


    private APIStatus status;

    private T payload;

    private GenricExceptionResponse exception;

    public APIStatus getStatus() {
        return status;
    }

    public void setStatus(APIStatus status) {
        this.status = status;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public GenricExceptionResponse getException() {
        return exception;
    }

    public void setException(GenricExceptionResponse exception) {
        this.exception = exception;
    }
}
