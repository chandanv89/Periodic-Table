package com.github.chandanv89.api.periodictable.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ImageUrlNotFoundException extends RuntimeException {
  private final String elementName;
  private final String message;

  public ImageUrlNotFoundException(String elementName, String message, Throwable cause) {
    super(message, cause);
    this.elementName = elementName;
    this.message = message;
  }
}
