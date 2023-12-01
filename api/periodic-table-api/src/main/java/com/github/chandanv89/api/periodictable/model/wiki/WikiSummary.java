package com.github.chandanv89.api.periodictable.model.wiki;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.chandanv89.api.periodictable.util.Utils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WikiSummary {
  @JsonProperty(value = "content_urls")
  private ContentUrls contentUrls;
  private ImageSource originalimage;
  private ImageSource thumbnail;
  private String description;
  private String extract;
  @JsonProperty(value = "extract_html")
  private String extractHtml;
  private String title;

  @Override
  public String toString() {
    return Utils.toJson(this);
  }
}
