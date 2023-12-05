package com.github.chandanv89.api.periodictable.exception;

import com.github.chandanv89.api.periodictable.controller.PeriodicTableController;
import com.github.chandanv89.api.periodictable.model.ApiError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@Slf4j
@ControllerAdvice(assignableTypes = {PeriodicTableController.class})
public class GlobalExceptionHandler {

  @ExceptionHandler(ImageUrlNotFoundException.class)
  public ResponseEntity<ApiError> handleImageUrlNotFoundException(ImageUrlNotFoundException ex) {
    var error = ApiError.builder()
                        .message("Unable to construct the image URL for the element")
                        .details(ex.getMessage())
                        .path("/periodic-table/api/v1/elements/" + ex.getElementName() + "/images")
                        .timestamp(Instant.now().toString())
                        .build();

    log.error("{}", error);

    return ResponseEntity.badRequest().body(error);
  }

}
