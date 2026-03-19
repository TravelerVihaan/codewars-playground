package com.github.vihaan.codewars.kyu5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DetectiveTests {

  @Test
  public void testEx() {
    assertEquals("hyena", Detective.roadKill("==========h===yyyyyy===eeee=n==a========"));
    assertEquals("penguin", Detective.roadKill("======pe====nnnnnn=======================n=n=ng====u==iiii=iii==nn========================n="));
    assertEquals("bear", Detective.roadKill("=====r=rrr=rra=====eee======bb====b======="));
  }
  
}