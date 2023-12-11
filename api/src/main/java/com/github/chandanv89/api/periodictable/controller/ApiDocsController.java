package com.github.chandanv89.api.periodictable.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * Controller to redirect to the API documentation.
 * </p>
 * <p>
 * At the moment, the API documentation is available at:
 * <ul>
 *   <li>Swagger UI: <a href="http://localhost:9091/swagger-ui/index.html">Swagger UI</a></li>
 *   <li>ReDoc: <a href="http://localhost:9091/redoc.html">Redoc</a></li>
 * </ul>
 * </p>
 */
@RestController
public class ApiDocsController {
  @RequestMapping(path = {"/swagger", "swgger", "swager", "swager-ui", "swagger-ui", "swagger-ui.html", "swaggr", "swaggr-ui", "swaggr-ui.html"})
  public ModelAndView redirectToSwagger() {
    return new ModelAndView("redirect:/swagger-ui/index.html");
  }

  @RequestMapping(path = {"/redoc", "redocly"})
  public ModelAndView redirectToRedoc() {
    return new ModelAndView("redirect:/redoc.html");
  }
}
