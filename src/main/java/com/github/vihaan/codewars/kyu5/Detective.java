package com.github.vihaan.codewars.kyu5;

import java.util.Arrays;

public class Detective {

    /**
     * Even for a professional like me, the identification of flattened exotic animals is not always easy!
     *
     * If it ever happens that I can't find all of the remains, or if there are gaps or other parts that I don't recognise, then I record it as ?? in my dead-critter notebook.
     *
     * What I really need is a program that I can scan my photos into which can give back the correct answer straight away.
     *
     * Something like this:
     * Input
     *
     *     photo (not null)
     *
     * Output
     *
     *     the detected animal name, or ?? if unknown^
     *
     *     Here are some photos of what I came across last week:
     *
     *     There was a thing that looked like a hyena ==========h===yyyyyy===eeee=n==a========
     *
     *     a long black and white smudge that probably once was a penguin ======pe====nnnnnn=======================n=n=ng====u==iiii=iii==nn========================n=
     *
     *     and an unlucky bear that was hit going the other direction =====r=rrr=rra=====eee======bb====b=======
     * @param photo
     * @return
     */
    public static String roadKill(final String photo) {

        String animalFromPhoto = photo.replace("=", "");

        return Arrays.stream(ANIMALS)
            .map(animal -> {
                StringBuilder sb = new StringBuilder();
                for (char c: animal.toCharArray()) {
                    sb.append(c).append("+");
                }
                return sb.toString();
            })
            .filter(animalRegex -> animalFromPhoto.matches(animalRegex) || new StringBuilder(animalFromPhoto).reverse().toString().matches(animalRegex))
            .map(animalRegex -> animalRegex.replace("+", ""))
            .findFirst()
            .orElse("??");
    }

    private static final String[] ANIMALS = {"aardvark", "alligator", "armadillo", "antelope", "baboon", "bear", "bobcat", "butterfly", "cat", "camel", "cow", "chameleon", "dog", "dolphin", "duck", "dragonfly", "eagle", "elephant", "emu", "echidna", "fish", "frog", "flamingo", "fox", "goat", "giraffe", "gibbon", "gecko", "hyena", "hippopotamus", "horse", "hamster", "insect", "impala", "iguana", "ibis", "jackal", "jaguar", "jellyfish", "kangaroo", "kiwi", "koala", "killerwhale", "lemur", "leopard", "llama", "lion", "monkey", "mouse", "moose", "meercat", "numbat", "newt", "ostrich", "otter", "octopus", "orangutan", "penguin", "panther", "parrot", "pig", "quail", "quokka", "quoll", "rat", "rhinoceros", "racoon", "reindeer", "rabbit", "snake", "squirrel", "sheep", "seal", "turtle", "tiger", "turkey", "tapir", "unicorn", "vampirebat", "vulture", "wombat", "walrus", "wildebeast", "wallaby", "yak", "zebra"};

}