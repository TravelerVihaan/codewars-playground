package com.github.vihaan.codewars.kyu4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecretDetectiveTest {

  private SecretDetective detective;
  
  @BeforeEach
  public void setup() {
    detective = new SecretDetective();
  }

  @Test
  public void secret1() {
    char[][] triplets = {
      {'t','u','p'},
      {'w','h','i'},
      {'t','s','u'},
      {'a','t','s'},
      {'h','a','p'},
      {'t','i','s'},
      {'w','h','s'}
    };
    assertEquals("whatisup", detective.recoverSecret(triplets));
  }
}