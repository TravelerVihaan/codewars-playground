package com.github.vihaan.codewars.kyu4;

import java.util.Iterator;

public class Simplexer
        implements Iterator<Simplexer.Token> {

    public Simplexer(String buffer) {
        // TODO
    }

    @Override
    public boolean hasNext() {
        // TODO
        return false;
    }

    @Override
    public Token next() {
        // TODO
        // Creates a token with (text, type).
        return new Token("x", "identifier");
    }

    public static class Token {

        public final String text;
        public final String type;

        public Token(String text, String type) {
            this.text = text;
            this.type = type;
        }
    }

}