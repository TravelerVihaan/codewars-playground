package com.github.vihaan.loadbalancertask.storage.selection;

import java.util.Collection;

public interface SelectionStrategy {

    <T> T select(Collection<T> collection);
}
