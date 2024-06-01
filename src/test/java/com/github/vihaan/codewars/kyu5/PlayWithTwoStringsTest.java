package com.github.vihaan.codewars.kyu5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayWithTwoStringsTest {
  @Test
  public void Sample_tests() {
    assertEquals("abCCde", PlayWithTwoStrings.workOnStrings("abc","cde"));
    assertEquals("abcDeFGtrzWDEFGgGFhjkWqE", PlayWithTwoStrings.workOnStrings("abcdeFgtrzw", "defgGgfhjkwqe"));
    assertEquals("abcDEfgDEFGg", PlayWithTwoStrings.workOnStrings("abcdeFg", "defgG"));
    assertEquals("ABABbababa", PlayWithTwoStrings.workOnStrings("abab", "bababa"));
  }
}