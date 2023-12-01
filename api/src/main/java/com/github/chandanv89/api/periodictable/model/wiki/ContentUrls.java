package com.github.chandanv89.api.periodictable.model.wiki;

import com.github.chandanv89.api.periodictable.util.Utils;
import lombok.Data;

@Data
public class ContentUrls {
  private ArticleUrl desktop;
  private ArticleUrl mobile;

  @Override
  public String toString() {
    return Utils.toJson(this);
  }
}
