package com.github.vihaan.codewars.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BraceCheckerTests {

  private BraceChecker checker = new BraceChecker();

	@Test
	public void testValid() {
    assertEquals(true, checker.isValid("()"));
    assertEquals(true, checker.isValid("{}"));
	}
  
  	@Test
  	public void testInvalid() {
    assertEquals(false, checker.isValid("[(])"));
	}

}