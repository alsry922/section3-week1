package com.codestates.member;

import javax.validation.constraints.Email;

public class MemberPostDto {
  @Email
  private String email;
  private String name;
  private String phone;

  public String getEmail() {
    return email;
  }


  public String getName() {
    return name;
  }


  public String getPhone() {
    return phone;
  }

}
