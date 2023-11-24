package com.github.chandanv89.api.periodictable.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "periodictable.api")
public class Config {
  private JpaConfigs jpa;
}
