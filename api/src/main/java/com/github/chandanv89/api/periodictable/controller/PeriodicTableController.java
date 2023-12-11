package com.github.chandanv89.api.periodictable.controller;

import com.github.chandanv89.api.periodictable.model.ApiError;
import com.github.chandanv89.api.periodictable.model.Element;
import com.github.chandanv89.api.periodictable.model.wiki.WikiSummary;
import com.github.chandanv89.api.periodictable.service.PeriodicTableService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.extensions.Extension;
import io.swagger.v3.oas.annotations.extensions.ExtensionProperty;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = {
  "http://localhost:4200",
  "http://localhost:8080",
  "http://localhost:80"
})
@RestController
@RequestMapping("/periodic-table/api/v1/elements")
@AllArgsConstructor
@OpenAPIDefinition(
  servers = {@Server(url = "http://localhost:9091", description = "Local server")},
  info = @Info(
    version = "1.0.0",
    title = "Periodic Table API",
    summary = "Restful endpoints for the periodic table app.",
    description = "API to get details about elements of the periodic table",
    contact = @Contact(
      name = "Chandan Veerabhadrappa",
      extensions = {@Extension(
        name = "Websites",
        properties = {
          @ExtensionProperty(name = "Personal", value = "https://chandanv.me"),
          @ExtensionProperty(name = "Source", value = "https://github.com/chandanv89/periodic-table")
        })}
    )
  )
)
public class PeriodicTableController {
  private final PeriodicTableService service;

  @Operation(
    summary = "Get all elements of the periodic table",
    description = "Returns a list of all elements of the periodic table",
    responses = {
      @ApiResponse(
        responseCode = "200",
        description = "Successfully retrieved all elements",
        content = @Content(
          array = @ArraySchema(
            schema = @Schema(implementation = Element.class)
          ),
          examples = @ExampleObject(name = "Hydrogen", value = """
            [
            {"atomicNumber":1,"group":1,"period":1,"atomicMass":"1.008","atomicRadius":"53","block":"s","boilingPoint":"20","bondingType":"diatomic","cpkHexColor":"FFFFFF","density":"0.0000899","electronAffinity":"72.769","electronegativity":"2.2","electronicConfiguration":"1s1","groupBlock":"nonmetal","ionRadius":"167 (-1)","ionizationEnergy":"1312","meltingPoint":"14","name":"Hydrogen","oxidationStates":"-1, 1","standardState":"gas","symbol":"H","vanDerWaalsRadius":"120","yearDiscovered":"1766"},
            {"atomicNumber":2,"group":18,"period":1,"atomicMass":"4.002602","atomicRadius":"31","block":"s","boilingPoint":"4","bondingType":"atomic","cpkHexColor":"D9FFFF","density":"0.0001785","electronAffinity":"0","electronegativity":"","electronicConfiguration":"1s2","groupBlock":"noble gas","ionRadius":"","ionizationEnergy":"2372.3","meltingPoint":"-259","name":"Helium","oxidationStates":"","standardState":"gas","symbol":"He","vanDerWaalsRadius":"140","yearDiscovered":"1868"},
            {"atomicNumber":118,"group":18,"period":7,"atomicMass":"294","atomicRadius":"152","block":"p","boilingPoint":"-","bondingType":"atomic","cpkHexColor":"940094","density":"0.0099","electronAffinity":"0","electronegativity":"-","electronicConfiguration":"[Rn] 5f14 6d10 7s2 7p6","groupBlock":"noble gas","ionRadius":"","ionizationEnergy":"-","meltingPoint":"-","name":"Oganesson","oxidationStates":"-","standardState":"gas","symbol":"Og","vanDerWaalsRadius":"-","yearDiscovered":"2002"}
            ]
            """
          )
        ))
    })
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Element>> getElements() {
    return ResponseEntity.ok(service.getElements());
  }

  @Operation(
    summary = "Get details about an element of the periodic table",
    description = "Returns additional details about the element. This includes the element's wiki summary and image urls",
    parameters = {@Parameter(name = "elementName", description = "Name of the element", required = true)},
    responses = {
      @ApiResponse(responseCode = "200", description = "Successfully retrieved the given element"),
      @ApiResponse(responseCode = "404", description = "Element not found",
        content = {@Content(schema = @Schema(implementation = ApiError.class))}
      )
    })
  @GetMapping(value = "/{elementName}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<WikiSummary> getWikiSummary(@PathVariable String elementName) {
    return ResponseEntity.ok(service.getWikiSummary(elementName));
  }

  @Operation(
    summary = "Get image urls of an element of the periodic table",
    description = "Returns a list of image urls for the given element. This list include images from "
      + "https://images-of-elements.com and corresponding wiki page.",
    parameters = {@Parameter(name = "elementName", description = "Name of the element", required = true)},
    responses = {
      @ApiResponse(responseCode = "200", description = "Successfully retrieved image urls for the element.",
        content = {@Content(
          array = @ArraySchema(schema = @Schema(implementation = String.class)), examples = @ExampleObject(name = "Hydrogen", value = """
          [
          "https://images-of-elements.com/hydrogen.jpg",
          "https://en.wikipedia.org/wiki/Hydrogen#/media/File:Hydrogen_Spectra.jpg"
          ]
          """
        ))}),
      @ApiResponse(responseCode = "404", description = "Image URL not found",
        content = {@Content(
          schema = @Schema(implementation = ApiError.class),
          examples = @ExampleObject(name = "Hydrogen", value = """
            {
            "message": "Unable to construct the image URL for the element",
            "details": "Unable to construct the image URL for the element",
            "timestamp": "2021-08-15T16:30:00.000+00:00",
            "path": "/periodic-table/api/v1/elements/Hydrogen/images"
            }
            """
          ))}
      )
    })

  @GetMapping(value = "/{elementName}/images", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<String>> getElementImageUrl(@PathVariable String elementName) {
    return ResponseEntity.ok(service.getElementImageUrls(elementName));
  }

}
