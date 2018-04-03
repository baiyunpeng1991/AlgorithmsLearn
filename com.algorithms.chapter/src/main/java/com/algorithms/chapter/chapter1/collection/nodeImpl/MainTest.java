package com.algorithms.chapter.chapter1.collection.nodeImpl;

import java.util.Iterator;

public class MainTest {

    public static void main(String[] args) {
        testStackNode();
        testQueueNode();
    }

    /**
     * test the stackNode push and pop
     */
    private static void testStackNode(){
        StackNode<String> stackNode = new StackNode<String>();
        stackNode.push("one");
        stackNode.push("two");
        stackNode.push("three");
        stackNode.push("four");
        stackNode.push("five");
        Iterator<String> iterator = stackNode.iterator();
        while (iterator.hasNext()) {
            System.out.println("args = [" + iterator.next() + "]");
        }
        System.out.println("isEmpty = [" + stackNode.isEmpty() + "]");
    }

    /**
     * test the queueNode push and pop
     */
    private static void testQueueNode(){
        QueueNode<String> queueNode = new QueueNode<String>();
        queueNode.enqueue("one");
        queueNode.enqueue("two");
        queueNode.enqueue("three");
        queueNode.enqueue("four");
        queueNode.enqueue("five");
        Iterator<String> iterator = queueNode.iterator();
        while (iterator.hasNext()) {
            System.out.println("args = [" + iterator.next() + "]");
        }
        System.out.println("isEmpty = [" + queueNode.isEmpty() + "]");
    }
}
