package com.algorithms.chapter.practice.stack;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * 栈学习
 * 一个可以获取最小元素的栈
 */
public class MinStack {

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{8,4,5,7,21,5,3,76,7,21,4,0,33,91};
        LessSpaceMinStack lessSpaceMinStack = lessSpaceMinStack(integers);
        LessTimeMinStack lessTimeMinStack = lessTimeMinStack(integers);
        System.out.println("lessSpaceMinStack min = [" + lessSpaceMinStack.getMin() + "]");
        System.out.println("lessTimeMinStack min = [" +lessTimeMinStack.getMin() + "]");
    }

    public static LessSpaceMinStack lessSpaceMinStack(Integer[] integers){
        LessSpaceMinStack lessSpaceMinStack = new LessSpaceMinStack();
        for (Integer integer : integers) {
            lessSpaceMinStack.push(integer);
        }
        return lessSpaceMinStack;
    }

    public static LessTimeMinStack lessTimeMinStack(Integer[] integers){
        LessTimeMinStack lessTimeMinStack = new LessTimeMinStack();
        for (Integer integer : integers) {
            lessTimeMinStack.push(integer);
        }
        return lessTimeMinStack;
    }

    /**
     * 实现方式一
     */
   private static class LessSpaceMinStack {
       private Stack<Integer> dataStack;
       private Stack<Integer> minStack;

       public LessSpaceMinStack() {
           this.dataStack = new Stack<Integer>();
           this.minStack =  new Stack<Integer>();
       }

       public void push(int node){
            dataStack.push(node);
            if(minStack.empty()){
                minStack.push(node);
            }
            if(node < minStack.peek()){
                minStack.push(node);
            }
        }

        public Integer pop(){
            Integer pop = dataStack.pop();
            if(pop.equals(minStack.peek())){
                minStack.pop();
            }
            return pop;
        }

        public Integer getMin(){
            if(minStack.empty()){
                throw new NoSuchElementException();
            }
            return minStack.peek();
        }
    }

    /**
     * 实现方式二
     */
    private static class LessTimeMinStack {
        private Stack<Integer> dataStack;
        private Stack<Integer> minStack;

        public LessTimeMinStack() {
            this.dataStack = new Stack<Integer>();
            this.minStack =  new Stack<Integer>();
        }

        public void push(int node){
            dataStack.push(node);
            if(minStack.empty()){
                minStack.push(node);
            }else if(node < minStack.peek()){
                minStack.push(node);
            }else {
                minStack.push(minStack.peek());
            }
        }

        public Integer pop(){
            if(!minStack.empty()){
                minStack.pop();
            }
            return dataStack.pop();
        }

        public Integer getMin(){
            if(minStack.empty()){
                throw new NoSuchElementException();
            }
            return minStack.peek();
        }
    }
}
