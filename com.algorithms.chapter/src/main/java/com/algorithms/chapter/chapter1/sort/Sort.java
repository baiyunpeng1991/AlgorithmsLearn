package com.algorithms.chapter.chapter1.sort;

public  abstract class Sort {
    public abstract void sort(Comparable[] a);

    public static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    public static void exchange(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static  void show(Comparable[] a){
        for (int i = 0; i < a.length; i++){
            System.out.print("" + a[i] + ",");
        }
    }

    public static  boolean isSorted(Comparable[] a){
        for (int i = 1; i < a.length; i++){
            if(less(a[i],a[i-1])){
                return false;
            }
        }
        return true;
    }
}
