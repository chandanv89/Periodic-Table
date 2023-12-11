package com.github.chandanv89.api.periodictable.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Utils {
  private Utils() {super();}

  /**
   * Converts the given object to JSON string. This uses Jackson's {@link ObjectMapper}.
   *
   * @param obj Object to be converted to JSON string
   * @return JSON string representation of the given object
   * @See <a href="https://www.baeldung.com/jackson-object-mapper-tutorial">Jackson Object Mapper Tutorial</a>
   */
  public static String toJson(Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      return obj == null ? "null" : obj.toString();
    }
  }
}
