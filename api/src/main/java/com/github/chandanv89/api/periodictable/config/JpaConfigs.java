package com.github.chandanv89.api.periodictable.config;

import lombok.Data;

@Data
public class JpaConfigs {
  private String seedPath;
  private int batchSize;
}
