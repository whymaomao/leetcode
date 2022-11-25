package com.yue;

public class finalUtilityTestClass {

  private String notTest;
  private final String test;


  public String getNotTest() {
    return this.notTest + this.test;
  }



  private String initializeTest() {
    return "Hello World";
  }

  public finalUtilityTestClass(String input) {
    this.notTest = input;
    this.test = initializeTest();
  }


  public static void main(String[] args) {
    finalUtilityTestClass finalUtilityTestClassOne = new finalUtilityTestClass("yoyo");
    System.out.println(finalUtilityTestClassOne.getNotTest());
  }
}
