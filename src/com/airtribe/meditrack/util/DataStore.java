package com.airtribe.meditrack.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class DataStore<T> {
    private List<T> items = new ArrayList<>();
    public void add(T item) {
        items.add(item);
    }

    public List<T> getAll() {
        return items;
    }


    public T findById(Predicate<T> condition) {
        for (T item : items) {
            if (condition.test(item)) {
                return item;
            }
        }
        return null;
    }

    public void delete(Predicate<T> condition) {
        items.removeIf(condition);
    }
}