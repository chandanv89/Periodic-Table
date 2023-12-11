package com.github.chandanv89.api.periodictable.model;

import com.github.chandanv89.api.periodictable.util.Utils;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represents the error response that is sent back to the client.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Error response sent back to the client")
public class ApiError {
  @Schema(description = "Error message", example = "Element not found")
  private String message;

  @Schema(description = "Details about the error", example = "Element not found: mercury")
  private String details;

  @Schema(description = "Timestamp when the error occurred", example = "2021-01-01T00:00:00.000Z")
  private String timestamp;

  @Schema(description = "Path of the request that caused the error", example = "/periodic-table/api/v1/elements/mercury")
  private String path;

  @Override
  public String toString() {
    return Utils.toJson(this);
  }
}
