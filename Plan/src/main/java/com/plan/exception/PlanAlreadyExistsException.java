package com.plan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.CONFLICT, reason ="Plan already exists")
public class PlanAlreadyExistsException extends Exception {

}
