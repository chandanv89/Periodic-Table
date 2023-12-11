package com.github.chandanv89.api.periodictable.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.chandanv89.api.periodictable.config.Config;
import com.github.chandanv89.api.periodictable.model.Element;
import com.github.chandanv89.api.periodictable.repository.PeriodicTableRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class InitialLoaderService {
  private final PeriodicTableRepository repository;
  private final Config config;

  private final TypeReference<List<Element>> typeRef = new TypeReference<>() {
  };

  private ObjectMapper mapper;

  @PostConstruct
  @Transactional()
  public void loadWords() {
    log.info("Initialising Periodic Table...");
    long start = System.currentTimeMillis();
    mapper = new ObjectMapper();
    List<Element> elements = new ArrayList<>();

    try {
      elements = mapper.readValue(new ClassPathResource(config.getJpa().getSeedPath()).getInputStream(), typeRef);

      List<Element> batch = new ArrayList<>();

      for (Element element : elements) {
        batch.add(element);
        if (batch.size() == config.getJpa().getBatchSize()) {
          log.debug("Loading batch of {} elements", batch.size());
          repository.saveAll(batch);
          batch.clear();
        }
      }

      if (!batch.isEmpty()) {
        log.debug("Saving last batch of {} elements", batch.size());
        repository.saveAll(batch);
      }

    } catch (Exception e) {
      log.error("Something went wrong!", e);
    }

    long end = System.currentTimeMillis();
    log.info("Periodic Table initialised with {} elements in {} ms", elements.size(), (end - start));
  }
}
