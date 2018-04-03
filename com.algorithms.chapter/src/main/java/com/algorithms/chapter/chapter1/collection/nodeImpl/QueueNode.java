package com.algorithms.chapter.chapter1.collection.nodeImpl;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueNode<Item> implements Iterable<Item> {
    /**
     * first node for record
     */
    private Node first;
    /**
     * last node for record
     */
    private Node last;
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

    public void enqueue(Item item){
      Node lastNode = last;
      last = new Node();
      last.item = item;
      last.next = null;
      if (isEmpty()){
          first = last;
      }else {
          lastNode.next = last;
      }
       N++;
    }

    public Item dequeue(){
        if (N == 0){
            throw new NoSuchElementException();
        }
        Node node = first.next;
        Item item = first.item;
        first = node;
        N--;
        if (isEmpty()){
            last = null;
        }
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
