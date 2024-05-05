package com.github.vihaan.codewars.kyu4;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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
public class PokerHand
{      
    public enum Result { TIE, WIN, LOSS }

    private final List<String> cards;

    PokerHand(String hand)
    {
        cards = Arrays.stream(hand.split(" ")).sorted().toList();
    }

    public Result compareWith(PokerHand hand) {        
        if (cards.equals(hand.getCards())) {
            return Result.TIE;
        }
        return Result.TIE;

    }

    private int calculateHandValue(List<String> cards) {
        var grouped = cards.stream().map(card -> card.substring(0,1)).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        var maxocurrences = grouped.entrySet()
                .stream()
                .max(Map.Entry.<String, Long>comparingByValue()).orElse(0);

                //.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));


    }

    public List<String> getCards() {
        return cards;
    }

    private static final int HAND_SIZE = 14;
    private static final List<String> CARD_VALUES = List.of("2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A");
    private static final List<String> CARD_SUITS = List.of("S", "H", "D", "C");
}