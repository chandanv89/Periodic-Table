package com.github.chandanv89.api.periodictable.model;

import com.github.chandanv89.api.periodictable.util.Utils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {
  private String message;
  private String details;
  private String timestamp;
  private String path;

  @Override
  public String toString() {
    return Utils.toJson(this);
  }
}
