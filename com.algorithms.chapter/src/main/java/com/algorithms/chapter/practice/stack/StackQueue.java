package com.algorithms.chapter.practice.stack;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * 两个栈实现一个队列FIFO
 */
public class StackQueue<Item> {

    public static void main(String[] args) {
        StackQueue<String> stackQueue = new StackQueue(new Stack<String>(), new Stack<String>());
        stackQueue.push("9");
        stackQueue.push("8");
        stackQueue.push("7");
        stackQueue.push("6");
        stackQueue.push("5");
        stackQueue.push("4");
        System.out.println("args = [" + stackQueue.poll() + "]");
        stackQueue.push("10");
        System.out.println("args = [" + stackQueue.poll() + "]");
    }

    private Stack<Item> pushStack;
    private Stack<Item> popStack;

    public StackQueue(Stack<Item> pushStack, Stack<Item> popStack) {
        this.pushStack = pushStack;
        this.popStack = popStack;
    }

    public void push(Item item){
        pushStack.push(item);
    }

    public Item poll(){
        initPopStack();
        return popStack.pop();
    }

    public Item peek(){
        initPopStack();
        return popStack.peek();
    }

    private void initPopStack() {
        if (this.popStack.empty() && this.pushStack.empty()) {
            throw new NoSuchElementException();
        } else if (this.popStack.empty()) {
            while (!this.pushStack.empty()) {
                this.popStack.push(this.pushStack.pop());
            }
        }
    }
}
