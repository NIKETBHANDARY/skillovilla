package com.skillovilla.course.constant;

public enum APIStatus {
    SUCCESS("S"),
    FAILURE("F"),
    ERROR("E"),
    NO_DATA("N");


    private String status;

    private APIStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return this.status;
    }
}
