package com.algorithms.chapter.chapter1.collection.nodeImpl;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * use the node to implements the stack(LIFO);
 * it's not thread safe when concurrent;
 * @param <Item>
 */
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
        if (isEmpty()){
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
        return new NodeIterator();
    }


    private class NodeIterator implements Iterator<Item>{

        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.item;
            first = first.next;
            current = first;
            return item;
        }

        public void remove() {

        }
    }
}
