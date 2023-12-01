package com.github.chandanv89.api.periodictable.model.wiki;

import com.github.chandanv89.api.periodictable.util.Utils;
import lombok.Data;

@Data
public class ImageSource {
  private String source;

  @Override
  public String toString() {
    return Utils.toJson(this);
  }
}
