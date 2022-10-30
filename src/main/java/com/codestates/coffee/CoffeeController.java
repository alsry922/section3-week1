package com.codestates.coffee;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/coffees")
public class CoffeeController {
  private static final Map<Long, Map<String,Object>> coffees = new HashMap<>();

  public static Map<Long, Map<String, Object>> getInstance() {
    return coffees;
  }

  @PostConstruct
  public void init() {
    Map<String, Object> coffee1 = new HashMap<>();
    long coffeeId = 1L;
    coffee1.put("coffeeId", coffeeId);
    coffee1.put("korName", "바닐라 라떼");
    coffee1.put("engName", "Vanilla Latte");
    coffee1.put("price", 4500);

    coffees.put(coffeeId, coffee1);
  }
  @PostMapping
  public ResponseEntity postCoffee(@RequestParam("korName") String korName,
                                   @RequestParam("engName") String engName,
                                   @RequestParam("price") int price) {
    Map<String, Object> map = new HashMap<>();
    map.put("korName", korName);
    map.put("engName", engName);
    map.put("price", price);
    return new ResponseEntity(map, HttpStatus.CREATED);
  }

  @GetMapping("/{coffee-id}")
  public ResponseEntity getCoffee(@PathVariable("coffee-id") long coffeeId) {
    Map<String, Object> coffee = coffees.get(coffeeId);
    return new ResponseEntity(coffee, HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity getCoffees() {
    return new ResponseEntity(coffees, HttpStatus.OK);
  }

  @PatchMapping("/{coffee-id}")
  public ResponseEntity patchCoffee(@PathVariable("coffee-id") long coffeeId,
                                    @RequestParam("korName") String korName,
                                    @RequestParam("price") int price) {
    Map<String, Object> coffee = coffees.get(coffeeId);
    coffee.put("korName", korName);
    coffee.put("price", price);
    return new ResponseEntity(coffee, HttpStatus.OK);
  }

  @DeleteMapping("/{coffee-id}")
  public ResponseEntity deleteCoffee(@PathVariable("coffee-id") long coffeeId) {
    coffees.remove(coffeeId);
    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }
}
