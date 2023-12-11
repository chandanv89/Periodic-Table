package com.github.chandanv89.api.periodictable.model.wiki;

import com.github.chandanv89.api.periodictable.util.Utils;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ImageSource {

  @Schema(description = "The URL of the image")
  private String source;

  @Override
  public String toString() {
    return Utils.toJson(this);
  }
}
