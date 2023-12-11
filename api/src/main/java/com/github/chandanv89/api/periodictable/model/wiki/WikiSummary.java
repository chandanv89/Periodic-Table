package com.github.chandanv89.api.periodictable.model.wiki;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.chandanv89.api.periodictable.util.Utils;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WikiSummary {
  @Schema(description = "Wikipedia article urls for desktop and mobile versions")
  @JsonProperty(value = "content_urls")
  private ContentUrls contentUrls;

  @Schema(description = "The main image for the article. Can be empty if no image is available.")
  private ImageSource originalimage;

  @Schema(description = "The thumbnail for the article. Can be empty if no thumbnail is available.")
  private ImageSource thumbnail;

  @Schema(description = "The description of the article")
  private String description;

  @Schema(description = "The extract of the article")
  private String extract;

  @Schema(description = "The extract of the article in HTML format")
  @JsonProperty(value = "extract_html")
  private String extractHtml;

  @Schema(description = "The title of the article")
  private String title;

  @Override
  public String toString() {
    return Utils.toJson(this);
  }
}
