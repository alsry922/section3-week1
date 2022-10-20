package com.codestates.order;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "v1/orders", produces = {MediaType.APPLICATION_JSON_VALUE})
public class OrderController {
  @GetMapping
  public String getOrders() {
    System.out.println("# get orders: ");
    return null;
  }

  @GetMapping("/{order-id}")
  public String getOrder(@PathVariable("order-id") long orderId) {
    System.out.println("# orderId = " + orderId);
    return null;
  }

  @PostMapping
  public String postOrder(@RequestParam("memberId") long memberId,
                          @RequestParam("coffeeId") long coffeeId) {
    System.out.println("#memberId = " + memberId);
    System.out.println("#coffeeId = " + coffeeId);

    String response =
            "{" +
                    "\"memberId\":\"" + memberId + "\"," +
                    "\"coffeeId\":\"" + coffeeId + "\"," +
                    "}";
    return response;

  }
}
