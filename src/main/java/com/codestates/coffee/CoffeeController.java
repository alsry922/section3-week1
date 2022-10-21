package com.codestates.coffee;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "v1/coffees", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CoffeeController {
  @PostMapping
  public String postCoffee(@RequestParam("korName") String korName,
                           @RequestParam("engName") String engName,
                           @RequestParam("price") int price) {
    String response = "{" +
            "\"korName\":" + "\"" + korName + "\"," +
            "\"engName\":" + "\"" + engName + "\"," +
            "\"price\":" + "\"" + price + "\"" +
        "}";
    return response;
  }

  @GetMapping("/{coffee-id}")
  public String getCoffee(@PathVariable("coffee-id") long coffeeId) {
    return null;
  }

  @GetMapping
  public String getCoffees() {
    return null;
  }
}
