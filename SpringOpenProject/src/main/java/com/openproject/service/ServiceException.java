package com.openproject.service;

import java.sql.SQLException;

public class ServiceException extends RuntimeException {
    public ServiceException(String s, Exception e) {
        super(s,e);
    }
}
