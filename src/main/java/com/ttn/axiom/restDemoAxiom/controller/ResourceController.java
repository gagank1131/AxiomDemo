package com.ttn.axiom.restDemoAxiom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class ResourceController {

  @Autowired MessageSource messageSource;

  @GetMapping("/welcome/{name}")
  public String welcomeMessageToUser(
      @RequestHeader(name = "Accept-Language", required = false) Locale locale,
      @PathVariable String name) {
    String message = messageSource.getMessage("good.morning.message", null, locale);
    return message + " " + name;
  }
}
