package com.codestates.member;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/v1/members")
public class MemberController {
  @PostMapping
  public ResponseEntity postMember(@RequestParam("email") String email,
                                   @RequestParam("name") String name,
                                   @RequestParam("phone") String phone) {
    System.out.println("# email = " + email);
    System.out.println("# name = " + name);
    System.out.println("# phone = " + phone);

    Map<String, String> map = new HashMap<>();
    map.put("email", email);
    map.put("name", name);
    map.put("phone", phone);
    return new ResponseEntity(map, HttpStatus.CREATED);
  }

  @GetMapping("/{member-id}")
  public ResponseEntity getMember(@PathVariable("member-id") long memberId) {
    System.out.println("# memberId = " + memberId);
    // not implementation
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity getmembers() {
    System.out.println("# get Members");

    //not implementation
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
