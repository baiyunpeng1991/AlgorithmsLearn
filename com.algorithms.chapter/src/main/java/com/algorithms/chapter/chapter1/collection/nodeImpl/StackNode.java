package com.algorithms.chapter.chapter1.collection.nodeImpl;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackNode<Item> implements Iterable<Item> {
    /**
     * first node for record
     */
    private Node first;
    /**
     *  record size
     */
    private int N;

    /**
     * the node
     */
    private class Node{
        Item item;
        Node next;
    }

    public void push(Item item){
        // record the first node to old node
        Node oldNode = first;
        // create new node
        first = new Node();
        first.item = item;
        // replace the first node to old node
        first.next = oldNode;
        N++;
    }

    public Item pop(){
        if (N == 0){
            throw new NoSuchElementException();
        }
        //recode the next node
        Node node = first.next;
        Item item = first.item;
        // replace the next node to first node
        first = node;
        N--;
        return item;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return N;
    }

    public Iterator<Item> iterator() {
        return null;
    }

    
    class StackIterator implements Iterator<Item>{

        public boolean hasNext() {
            return false;
        }

        public Item next() {
            return null;
        }

        public void remove() {

        }
    }
}
