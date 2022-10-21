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
  // 회원 정보 등록
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
  // 회원 정보 수정
  @PatchMapping("/{member-id}")
  public ResponseEntity patchMemeber(@PathVariable("member-id") long memberId,
                                     @RequestParam("phone") String phone) {
    Map<String, Object> body = new HashMap<>();
    body.put("memberId", memberId);
    body.put("email", "hgd@gmail.com");
    body.put("name", "홍길동");
    body.put("phone", phone);

    return new ResponseEntity(body, HttpStatus.OK);
  }
  // 회원 정보 조회
  @GetMapping("/{member-id}")
  public ResponseEntity getMember(@PathVariable("member-id") long memberId) {
    System.out.println("# memberId = " + memberId);
    // not implementation
    return new ResponseEntity<>(HttpStatus.OK);
  }
  // 모든 회원 정보 조회
  @GetMapping
  public ResponseEntity getmembers() {
    System.out.println("# get Members");

    //not implementation
    return new ResponseEntity<>(HttpStatus.OK);
  }
  // 회원 정보 삭제
  @DeleteMapping("/{member-id}")
  public ResponseEntity deleteMember(@PathVariable("member-id") long memberId) {
    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }
}
