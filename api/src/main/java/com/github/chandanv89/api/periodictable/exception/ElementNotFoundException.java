package com.github.chandanv89.api.periodictable.exception;

import lombok.Getter;

/**
 * Exception thrown when an element is not found in the database.
 */
@Getter
public class ElementNotFoundException extends RuntimeException {

  private final String elementName;
  private final String message;

  public ElementNotFoundException(String elementName, String message, Throwable cause) {
    super(message, cause);
    this.elementName = elementName;
    this.message = message;
  }
}
