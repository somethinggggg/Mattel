package com.keyes.mattel.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@AllArgsConstructor
@Getter
public class ExceptionResponse {

    private Instant timestamp;
    private String message;
    private String details;

}
