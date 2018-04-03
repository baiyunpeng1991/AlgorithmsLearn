package com.algorithms.chapter.chapter1.collection.arrayImpl;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BagArray<Item> implements Iterable<Item> {

    private Item[] items;

    private int N;

    private static final int DEFAULT_SIZE = 5;

    public BagArray() {
        this.items = (Item[]) new Object[DEFAULT_SIZE];
    }

    public BagArray(int capcity) {
        this.items = (Item[]) new Object[capcity];
    }

    public void put(Item item){
        resize(items.length << 1);
        items[N++] = item;
    }

    private boolean isEmpty(){
        return N == 0;
    }

    private int size(){
        return N;
    }

    private void resize(int max) {
        if (N == this.items.length){
            Item[] newItems = (Item[]) new Object[max];
            for (int i = 0; i < N ; i++) {
                newItems[i] = this.items[i];
            }
            this.items = newItems;
            newItems = null;
        }
    }

    public Iterator<Item> iterator() {
        return new BagIterator();
    }

    private class BagIterator implements Iterator<Item>{

        private int next = N;

        public boolean hasNext() {
            return N > 0;
        }

        public Item next() {
            if (next == 0){
                throw new NoSuchElementException();
            }
            return items[--next];
        }

        public void remove() {
            throw new NoSuchElementException();
        }
    }
}
