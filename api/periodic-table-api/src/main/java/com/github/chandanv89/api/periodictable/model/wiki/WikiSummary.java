package com.github.chandanv89.api.periodictable.model.wiki;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WikiSummary {
  private String title;
  private String description;
  private String extract;
  private ImageSource thumbnail;
  private ImageSource originalimage;

  @JsonProperty(value = "extract_html")
  private String extractHtml;

  @JsonProperty(value = "content_urls")
  private ContentUrls contentUrls;
}
