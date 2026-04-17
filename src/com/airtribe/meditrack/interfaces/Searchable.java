package com.airtribe.meditrack.interfaces;

public interface Searchable {
    Object search(String keyword);
    Object searchById(String id);

    default void printSearchResult(Object result) {
        System.out.println("Search Result: " + result);
    }
}
