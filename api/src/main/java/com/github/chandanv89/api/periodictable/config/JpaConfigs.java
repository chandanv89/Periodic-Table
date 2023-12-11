package com.github.chandanv89.api.periodictable.config;

import lombok.Data;

@Data
public class JpaConfigs {
  /**
   * Populates the database with the seed data.
   */
  private String seedPath;

  /**
   * The number of records to be inserted in a single batch.
   */
  private int batchSize;
}
