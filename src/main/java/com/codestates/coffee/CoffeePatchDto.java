package com.codestates.coffee;

public class CoffeePatchDto {
  private String korName;
  private String engName;
  private int price;

  public String getKorName() {
    return korName;
  }

  public void setKorName(String korName) {
    this.korName = korName;
  }

  public int getPrice() {
    return price;
  }

  public String getEngName() {
    return engName;
  }

  public void setEngName(String engName) {
    this.engName = engName;
  }

  public void setPrice(int price) {
    this.price = price;
  }
}
