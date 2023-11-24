package com.github.chandanv89.api.periodictable.controller;

import com.github.chandanv89.api.periodictable.model.Element;
import com.github.chandanv89.api.periodictable.model.wiki.WikiSummary;
import com.github.chandanv89.api.periodictable.service.PeriodicTableService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/periodic-table/api/v1/elements")
@AllArgsConstructor
public class PeriodicTableController {
  private final PeriodicTableService service;

  @GetMapping
  public ResponseEntity<List<Element>> getElements() {
    return ResponseEntity.ok(service.getElements());
  }

  @GetMapping("/{elementName}")
  public ResponseEntity<WikiSummary> getWikiSummary(@PathVariable String elementName) {
    return ResponseEntity.ok(service.getWikiSummary(elementName));
  }

  @GetMapping("/{elementName}/images")
  public ResponseEntity<List<String>> getElementImageUrl(@PathVariable String elementName) {
    return ResponseEntity.ok(service.getElementImageUrls(elementName));
  }

}
