package com.github.vihaan.codewars.kyu5;

/**
 * Create your own mechanical dartboard that gives back your score based on the coordinates of your dart.
 *
 *      - Use the scoring rules for a standard dartboard
 *      - The coordinates (x, y) are always relative to the center of the board (0, 0). The unit is millimeters.
 *      If you throw your dart 5 centimeters to the left and 3 centimeters below, it is written as:
 *
 *     String score = dartboard.getScore(-50, -30);
 *     Possible scores are:
 *
 *     Outside of the board: "X"
 *     Bull's eye: "DB"
 *     Bull: "SB"
 *     A single number, example: "10"
 *     A triple number: "T10"
 *     A double number: "D10"
 *     A throw that ends exactly on the border of two sections results in a bounce out.
 *     You can ignore this because all the given coordinates of the tests are within the sections.
 *
 *     The diameters of the circles on the dartboard are:
 *
 *     Bull's eye: 12.70 mm
 *     Bull: 31.8 mm
 *     Triple ring inner circle: 198 mm
 *     Triple ring outer circle: 214 mm
 *     Double ring inner circle: 324 mm
 *     Double ring outer circle: 340 mm
 */
public class Dartboard {

    public String getScore(double x, double y)
    {
        double radius = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        String prefix = switch (radius) {
            case radius <= BULLS_EYE -> "DB";
            case radius <= BULL -> "SB";
            case radius >= TRIPLE_RING_INNER && radius <= TRIPLE_RING_OUTER -> "T";
            case radius >= DOUBLE_RING_INNER && radius <= DOUBLE_RING_OUTER -> "D";
            case radius > DOUBLE_RING_OUTER -> "X";
            default -> "";
        }
        // Start your coding here...
        return "";
    }

    private static final double BULLS_EYE = 12.70 / 2;
    private static final double BULL = 31.8 / 2;
    private static final double TRIPLE_RING_INNER = 198.0d / 2;
    private static final double TRIPLE_RING_OUTER = 214.0d / 2;
    private static final double DOUBLE_RING_INNER = 324.0d / 2;
    private static final double DOUBLE_RING_OUTER = 340.0d / 2;
}