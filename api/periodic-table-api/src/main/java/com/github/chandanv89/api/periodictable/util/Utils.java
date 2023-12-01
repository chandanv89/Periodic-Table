package com.github.chandanv89.api.periodictable.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utils {
  private Utils() {super();}

  public static String toJson(Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      return obj == null ? "null" : obj.toString();
    }
  }
}
