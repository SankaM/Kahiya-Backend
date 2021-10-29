package com.monda.epatient.kahiya.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "Invalid username or password")
public class LoginException extends Exception {
}