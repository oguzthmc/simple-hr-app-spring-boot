package com.kodgemisi.staj2020.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Böyle bi' job yok!")
public class JobListingNotFoundException extends RuntimeException {

}
