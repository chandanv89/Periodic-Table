package com.github.chandanv89.api.periodictable;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableCaching
@SpringBootApplication
public class PeriodicTableApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(PeriodicTableApiApplication.class, args);
  }

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplateBuilder().build();
  }

  @Bean
  public CacheManager cacheManager() {
    return new ConcurrentMapCacheManager("elementsCache", "wikiSummaryCache", "imageUrlsCache");
  }

  @Bean
  public ObjectMapper objectMapper() {
    return new ObjectMapper();
  }

}
