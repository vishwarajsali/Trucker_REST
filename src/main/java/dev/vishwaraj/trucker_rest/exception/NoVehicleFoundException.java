package dev.vishwaraj.trucker_rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No Vehicle Found")
public class NoVehicleFoundException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

}