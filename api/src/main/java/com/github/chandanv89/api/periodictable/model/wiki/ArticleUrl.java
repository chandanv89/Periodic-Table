package com.github.chandanv89.api.periodictable.model.wiki;

import com.github.chandanv89.api.periodictable.util.Utils;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ArticleUrl {

  @Schema(description = "URL for the article in the desktop/mobile version of Wikipedia")
  private String page;

  @Override
  public String toString() {
    return Utils.toJson(this);
  }
}
