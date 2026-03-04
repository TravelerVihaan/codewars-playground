package com.github.vihaan.interview.loadbalancertask.storage.selection;

import java.util.Collection;

public interface SelectionStrategy {

    <T> T select(Collection<T> collection);
}
