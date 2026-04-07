package com.github.vihaan.codewars.kyu4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// TODO: Replace examples and use TDD development by writing your own tests

class TopWordsnTest {

  @Test @DisplayName("Sample tests")
  void sampleTests() {
    List<String> actual = TopWords.top3("a a a  b  c c  d d d d  e e e e e");
    assertThat(actual).containsExactly("e", "d", "a");
    assertThat(TopWords.top3("e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e")).containsExactly("e", "ddd", "aa");
    assertThat(TopWords.top3("  //wont won't won't ")).containsExactly("won't", "wont");
    assertThat(TopWords.top3("  , e   .. ")).containsExactly("e");
    assertThat(TopWords.top3("  ...  ")).isEmpty();
    assertThat(TopWords.top3("  '  ")).isEmpty();
    assertThat(TopWords.top3("  '''  ")).isEmpty();
    assertThat(TopWords.top3("'a 'A 'a' a'A' a'a'!")).isIn(List.of("'a", "a'a'", "'a'"), List.of("a'a'", "'a", "'a'"));
    assertThat(TopWords.top3("""
                             In a village of La Mancha, the name of which I have no desire to call to
                             mind, there lived not long since one of those gentlemen that keep a lance
                             in the lance-rack, an old buckler, a lean hack, and a greyhound for
                             coursing. An olla of rather more beef than mutton, a salad on most
                             nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra
                             on Sundays, made away with three-quarters of his income."""
                            )).containsExactly("a", "of", "on");
  }
  
}