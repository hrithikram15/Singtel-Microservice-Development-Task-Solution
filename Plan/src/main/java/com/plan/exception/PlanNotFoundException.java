package com.plan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND, reason ="Plan doesn't exist")

public class PlanNotFoundException extends Exception {

}
