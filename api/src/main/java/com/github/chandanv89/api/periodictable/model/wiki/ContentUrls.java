package com.github.chandanv89.api.periodictable.model.wiki;

import com.github.chandanv89.api.periodictable.util.Utils;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ContentUrls {
  @Schema(description = "URL for the article in the desktop version of Wikipedia")
  private ArticleUrl desktop;

  @Schema(description = "URL for the article in the mobile version of Wikipedia")
  private ArticleUrl mobile;

  @Override
  public String toString() {
    return Utils.toJson(this);
  }
}
