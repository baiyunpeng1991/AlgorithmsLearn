package com.algorithms.chapter.chapter1.sort;

public class InsertSort extends Sort {
    @Override
    public void sort(Comparable[] a) {
        int count = 0;
        int count2 = 0;
        for (int i = 1; i <a.length ; i++) {
            for (int j = i; j > 0 && less(a[j],a[j-1]) ; j--) {
                exchange(a,j,j-1);
                count++;
                count2++;
            }
            count2++;
        }
        show(a);
        System.out.println("count = [" + count2 + "],["+count+"]");
    }
}
