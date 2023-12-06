package com.github.chandanv89.api.periodictable.exception;

import lombok.Getter;

@Getter
public class ImageUrlNotFoundException extends RuntimeException {
  private final String elementName;
  private final String message;

  public ImageUrlNotFoundException(String elementName, String message, Throwable cause) {
    super(message, cause);
    this.elementName = elementName;
    this.message = message;
  }
}
