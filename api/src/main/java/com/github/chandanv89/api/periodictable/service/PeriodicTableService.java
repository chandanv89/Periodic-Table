package com.github.chandanv89.api.periodictable.service;

import static java.lang.String.format;

import com.github.chandanv89.api.periodictable.model.Element;
import com.github.chandanv89.api.periodictable.model.wiki.WikiSummary;
import com.github.chandanv89.api.periodictable.repository.PeriodicTableRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class PeriodicTableService {
  private static final String WIKI_URL = "https://en.wikipedia.org/api/rest_v1/page/summary/%s";

  private RestTemplate restTemplate;
  private PeriodicTableRepository repository;

  @Cacheable(cacheNames = {"elementsCache"})
  public List<Element> getElements() {
    log.info("Getting elements...");
    return repository.findAll();
  }

  @Cacheable(cacheNames = {"wikiSummaryCache"})
  public WikiSummary getWikiSummary(String elementName) {
    final var element = elementName != null && elementName.equalsIgnoreCase("mercury") ? "Mercury_(element)" : elementName;
    final var url = format(WIKI_URL, element);

    var summary = restTemplate.getForEntity(url, WikiSummary.class);

    log.info("Wiki Summary for {}: {}", elementName, summary.getBody());

    return summary.getBody();
  }

  @Cacheable(cacheNames = {"imageUrlsCache"})
  public List<String> getElementImageUrls(String elementName) {
    var urls = new ArrayList<String>();
    urls.add(format("https://images-of-elements.com/%s.jpg", elementName.toLowerCase()));
    urls.add(getWikiSummary(elementName).getOriginalimage().getSource());

    return urls;
  }
}
