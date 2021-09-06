package com.keyes.mattel.exception;

import com.keyes.mattel.model.Request;

import java.time.Instant;
import java.time.Period;
import java.util.List;

public class RequestNotFoundException extends RuntimeException {
    public RequestNotFoundException(String message) {
        super(message);
    }
}

