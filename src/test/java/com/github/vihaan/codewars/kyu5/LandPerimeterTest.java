package com.github.vihaan.codewars.kyu5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LandPerimeterTest {
    @Test
    void testBasic() {
      assertEquals("Total land perimeter: 60",
          LandPerimeter.landPerimeter(new String[] { "OXOOOX", "OXOXOO", "XXOOOX", "OXXXOO", "OOXOOX", "OXOOOO", "OOXOOX", "OOXOOO", "OXOOOO", "OXOOXX" }));
      assertEquals("Total land perimeter: 52", LandPerimeter.landPerimeter(new String[] { "OXOOO", "OOXXX", "OXXOO", "XOOOO", "XOOOO", "XXXOO", "XOXOO", "OOOXO", "OXOOX", "XOOOO", "OOOXO" }));
      assertEquals("Total land perimeter: 40", LandPerimeter.landPerimeter(new String[] { "XXXXXOOO", "OOXOOOOO", "OOOOOOXO", "XXXOOOXO", "OXOXXOOX" }));
      assertEquals("Total land perimeter: 54", LandPerimeter.landPerimeter(new String[] { "XOOOXOO", "OXOOOOO", "XOXOXOO", "OXOXXOO", "OOOOOXX", "OOOXOXX", "XXXXOXO" }));
      assertEquals("Total land perimeter: 40", LandPerimeter.landPerimeter(new String[] { "OOOOXO", "XOXOOX", "XXOXOX", "XOXOOO", "OOOOOO", "OOOXOO", "OOXXOO" }));
      assertEquals("Total land perimeter: 4", LandPerimeter.landPerimeter(new String[] { "X" }));
    }
}
