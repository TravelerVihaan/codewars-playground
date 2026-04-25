package com.github.vihaan.codewars.kyu4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
A famous casino is suddenly faced with a sharp decline of their revenues. They decide to offer Texas hold'em also online. Can you help them by writing an algorithm that can rank poker hands?
Task

Create a poker hand that has a method to compare itself to another poker hand:

Result PokerHand.compareWith(PokerHand hand);

A poker hand has a constructor that accepts a string containing 5 cards:

PokerHand hand = new PokerHand("KS 2H 5C JD TD");

The characteristics of the string of cards are:

    Each card consists of two characters, where
    The first character is the value of the card: 2, 3, 4, 5, 6, 7, 8, 9, T(en), J(ack), Q(ueen), K(ing), A(ce)
    The second character represents the suit: S(pades), H(earts), D(iamonds), C(lubs)
    A space is used as card separator between cards

The result of your poker hand compare can be one of these 3 options:

public enum Result
{
    WIN,
    LOSS,
    TIE
}

Notes

    Apply the Texas Hold'em rules for ranking the cards.
    Low aces are valid in this kata.
    There is no ranking for the suits.

If you finished this kata, you might want to continue with Sortable Poker Hands

 */
public class PokerHand {

    enum HandResult {
        ROYAL_POKER(1),
        POKER(2),
        FOUR_OF_KIND(3),
        FULL(4),
        COLOR(5),
        STREIGHT(6),
        THREE_OF_A_KIND(7),
        TWO_PAIRS(8),
        ONE_PAIR(9),
        HIGH_CARD(10);

        final int handScore;

        public int getHandScore() {
            return handScore;
        }

        HandResult(int handScore) {
            this.handScore = handScore;
        }
    }

    public enum Result { TIE, WIN, LOSS }

    private final List<Card> cards;

//    private final Map<Integer, Long> cardsCounted;
    private final Map<Long, List<Integer>> cardsCounted =  new HashMap<>();

    private final boolean isMonocolored;
    private HandResult result;
    private int handResultScore;

    private final int sumCardValues;

    PokerHand(String hand) {
        cards = Arrays.stream(hand.split(" ")).map(Card::of).sorted(Comparator.comparingInt(Card::getValue)).toList();
        this.sumCardValues = cards.stream().mapToInt(Card::getValue).sum();
        Map<Integer, Long> countedC = cards.stream().collect(Collectors.groupingBy(Card::getValue, Collectors.counting()));

        countedC.forEach((k, v) -> cardsCounted.merge(v, new ArrayList<>(List.of(k)), (v1, v2) -> {
            v1.addAll(v2);
            return v1;
        }));

        this.isMonocolored = cards.stream().map(Card::getColor).distinct().count() == 1;
        if (isMonocolored) {
            setResult(HandResult.COLOR, cards.stream().max(Comparator.comparingInt(Card::getValue)).orElseThrow().getValue());
        }

        POKER_HAND_VALIDATORS.forEach(validator -> validator.accept(this));
    }

    void setResult(HandResult result, int handResultScore) {
        if (this.result ==  null || this.result.getHandScore() > result.getHandScore()) {
            this.result = result;
            this.handResultScore = handResultScore;
        }
    }

    List<Card> getCards() {
        return cards;
    }

    public Map<Long, List<Integer>> getCardsCounted() {
        return cardsCounted;
    }

    public Result compareWith(PokerHand hand) {
        if (this.result.getHandScore() < hand.result.getHandScore()) {
            return Result.WIN;
        } else if (result.getHandScore() == hand.result.getHandScore()) {
            if (this.handResultScore > hand.handResultScore) {
                return Result.WIN;
            } else if (this.handResultScore == hand.handResultScore) {
                for (int i = HAND_SIZE - 1; i >= 0; i--) {
                    if (this.cards.get(i).getValue() > hand.cards.get(i).getValue()) {
                        return Result.WIN;
                    } else if (this.cards.get(i).getValue() < hand.cards.get(i).getValue()) {
                        return Result.LOSS;
                    }
                }
                return Result.TIE;
            } else {
                return Result.LOSS;
            }
        }
        return Result.LOSS;
    }

    static class Card {
        private final int value;

        private final char color;

        public int getValue() {
            return value;
        }

        public char getColor() {
            return color;
        }

        private Card(int value, char color) {
            this.value = value;
            this.color = color;
        }
        private static Card of(String sCard) {
            char chValue = sCard.charAt(0);
            var val = switch (chValue) {
                case 'T' -> 10;
                case 'J' -> 11;
                case 'Q' -> 12;
                case 'K' -> 13;
                case 'A' -> 14;
                default -> Integer.parseInt(String.valueOf(chValue));
            };
            return new Card(val, sCard.charAt(1));
        }
    }

    private static final int HAND_SIZE = 5;

    private static final List<Consumer<PokerHand>> POKER_HAND_VALIDATORS = List.of(
        PokerHand::pokerHandCheck,
        PokerHand::checkFourOfAKind,
        PokerHand::checkFullAndThreeOfAKind,
        PokerHand::checkPairs,
        PokerHand::checkHighCard
    );

    private static void checkHighCard(PokerHand pokerHand) {
        pokerHand.setResult(HandResult.HIGH_CARD, pokerHand.getCards().stream().max(Comparator.comparingInt(Card::getValue)).orElseThrow().getValue());
    }

    static void pokerHandCheck(PokerHand pokerHand) {
        if(IntStream.range(1, HAND_SIZE).allMatch(i -> pokerHand.getCards().get(i).getValue() - pokerHand.getCards().get(i - 1).getValue() == 1)) {
            int handScore = pokerHand.getCards().stream().max(Comparator.comparingInt(Card::getValue)).orElseThrow().getValue();
            if (pokerHand.isMonocolored) {
                pokerHand.setResult(HandResult.POKER, handScore);
                if (handScore == 14) {
                    pokerHand.setResult(HandResult.ROYAL_POKER, handScore);
                }
            } else {
                pokerHand.setResult(HandResult.STREIGHT, handScore);
            }
        }
    }

    private static void checkFourOfAKind(PokerHand pokerHand) {
        Optional.ofNullable(pokerHand.getCardsCounted().get(4L)).ifPresent(e -> pokerHand.setResult(HandResult.FOUR_OF_KIND, e.get(0)));
    }

    private static void checkFullAndThreeOfAKind(PokerHand pokerHand) {
        var triple = pokerHand.getCardsCounted().getOrDefault(3L, Collections.emptyList()).stream().findFirst().orElse(null);
        if (triple != null && triple != 0) {
            var pair = pokerHand.getCardsCounted().getOrDefault(2L, Collections.emptyList()).stream().findFirst().orElse(null);
            if (pair != null && pair != 0) {
                pokerHand.setResult(HandResult.FULL, triple);
            } else {
                pokerHand.setResult(HandResult.THREE_OF_A_KIND, triple);
            }
        }
    }

    private static void checkPairs(PokerHand pokerHand) {
        var pairs = pokerHand.getCardsCounted().getOrDefault(2L, Collections.emptyList());
        if (pairs.size() == 2) {
            pokerHand.setResult(HandResult.TWO_PAIRS, pairs.stream().mapToInt(Integer::intValue).sum());
        } else if (pairs.size() == 1) {
            pokerHand.setResult(HandResult.ONE_PAIR, pairs.get(0));
        }
    }
}