package com.codestates.order;

import com.codestates.coffee.CoffeeController;
import com.codestates.member.MemberController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {

  private static final Map<Long, Map<String, Object>> orders = new HashMap<>();

  @PostConstruct
  public void init() {
    Map<Long, Map<String, Object>> members = MemberController.getInstance();
    Map<String, Object> member = members.get(1L);
    Map<Long, Map<String, Object>> coffees = CoffeeController.getInstance();
    Map<String, Object> coffee = coffees.get(1L);
    long orderId = 1L;
    Map<String, Object> order1 = new HashMap<>();
    order1.put("orderId", orderId);
    order1.put("member", member);
    order1.put("coffee", coffee);
    orders.put(orderId, order1);
  }

  @PostMapping
  public ResponseEntity postOrder(@RequestParam("memberId") long memberId,
                                  @RequestParam("coffeeId") long coffeeId) {
    System.out.println("memberId = " + memberId);
    System.out.println("coffeeId = " + coffeeId);
    Map<String, Long> map = new HashMap<>();
    map.put("memberId", memberId);
    map.put("coffeeId", coffeeId);

    return new ResponseEntity(map, HttpStatus.CREATED);
  }

  @GetMapping("/{order-id}")
  public ResponseEntity getOrder(@PathVariable("order-id") long orderId) {
    System.out.println("orderId = " + orderId);
    Map<String, Object> order = orders.get(orderId);

    return new ResponseEntity(order, HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity getOrders() {
    System.out.println("OrderController.getOrders");
    return new ResponseEntity(orders, HttpStatus.OK);
  }
}
