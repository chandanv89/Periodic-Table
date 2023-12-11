package com.github.chandanv89.api.periodictable.exception;

import static java.lang.String.format;

import com.github.chandanv89.api.periodictable.controller.PeriodicTableController;
import com.github.chandanv89.api.periodictable.model.ApiError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@Slf4j
@ControllerAdvice(assignableTypes = {PeriodicTableController.class})
public class GlobalExceptionHandler {

  private static final String API_BASE_PATH = "/periodic-table/api/v1/elements";

  @ExceptionHandler(ImageUrlNotFoundException.class)
  public ResponseEntity<ApiError> handleImageUrlNotFoundException(ImageUrlNotFoundException ex) {
    var path = format("%s/%s/images", API_BASE_PATH, ex.getElementName());
    return buildApiError("Unable to construct the image URL for the element", path, ex, HttpStatus.NOT_FOUND);
  }


  @ExceptionHandler(ElementNotFoundException.class)
  public ResponseEntity<ApiError> handleElementNotFoundException(ElementNotFoundException ex) {
    var path = format("%s/%s", API_BASE_PATH, ex.getElementName());
    return buildApiError("Element not found", path, ex, HttpStatus.NOT_FOUND);
  }

  private ResponseEntity<ApiError> buildApiError(String message, String path, Exception ex, HttpStatus status) {
    var error = ApiError.builder()
                        .message(message)
                        .details(ex.getMessage())
                        .path(path)
                        .timestamp(Instant.now().toString())
                        .build();

    log.error("{}", error);

    return ResponseEntity.status(status).body(error);
  }

}
