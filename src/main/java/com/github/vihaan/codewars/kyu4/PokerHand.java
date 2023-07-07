package com.github.vihaan.codewars.kyu4;

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

    PokerHand(String hand)
    {
    }

    public Result compareWith(PokerHand hand) {        
        return Result.TIE;
    }
}