package com.codestates.coffee;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "v1/coffees")
public class CoffeeController {
  @PostMapping
  public ResponseEntity postCoffee(@RequestParam("korName") String korName,
                                   @RequestParam("engName") String engName,
                                   @RequestParam("price") int price) {
    Map<String, Object> map = new HashMap<>();
    map.put("korName", korName);
    map.put("engName", engName);
    map.put("price", price);
    return new ResponseEntity<Map>(map, HttpStatus.CREATED);
  }

  @PatchMapping("/{coffee-id}")
  public ResponseEntity patchCoffee(@PathVariable("coffee-id") long coffeeId,
                                    @RequestBody CoffeePatchDto coffeePatchDto) {
    coffeePatchDto.setPrice(6000);
    return new ResponseEntity<>(coffeePatchDto, HttpStatus.OK);
  }

  @GetMapping("/{coffee-id}")
  public ResponseEntity getCoffee(@PathVariable("coffee-id") long coffeeId) {
    System.out.println("# coffeeId: " + coffeeId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity getCoffees() {

    System.out.println("# get coffees");
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping({"/{coffee-id}"})
  public ResponseEntity delteCoffee(@PathVariable("coffee-id") long coffeeId) {
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
