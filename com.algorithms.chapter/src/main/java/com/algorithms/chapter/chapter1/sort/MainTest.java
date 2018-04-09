package com.algorithms.chapter.chapter1.sort;

public class MainTest {
    public static void main(String[] args) {
        Integer[] ints = new Integer[]{12,5,4,3,2,1,6,8,20};
        Sort selectSort = new SelectSort();
        selectSort.sort(ints);
        ints = new Integer[]{12,5,4,3,2,1,6,8,20};
        InsertSort insertSort = new InsertSort();
        insertSort.sort(ints);
    }
}
