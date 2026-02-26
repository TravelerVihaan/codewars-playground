package com.github.vihaan.loadbalancertask.storage.selection;

import java.util.Collection;
import java.util.Random;

public class RandomSelectionStrategy implements SelectionStrategy {

    private final Random random = new Random();

    @Override
    public <T> T select (Collection<T> collection) {
        T[] elements = (T[]) collection.toArray();
        return elements[random.nextInt(elements.length)];
    }
}
