package com.github.vihaan.codewars.kyu3;

/*
You are given a grid, which always includes exactly two end-points indicated by X

You simply need to return true/false if you can detect a one and only one "valid" line joining those points.

A line can have the following characters :

- = left / right
| = up / down
+ = corner
Rules for valid lines
The most basic kind of valid line is when the end-points are already adjacent
X
X
XX
The corner character (+) must be used for all corners (but only for corners).
If you find yourself at a corner then you must turn.
It must be possible to follow the line with no ambiguity (lookahead of just one step, and never treading on the same spot twice).
The line may take any path between the two points.
Sometimes a line may be valid in one direction but not the other. Such a line is still considered valid.
Every line "character" found in the grid must be part of the line. If extras are found then the line is not valid.
 */
public class Dinglemouse {

  public static boolean line(final char [][] grid) {
    // Your code here
    return false;
  }

}