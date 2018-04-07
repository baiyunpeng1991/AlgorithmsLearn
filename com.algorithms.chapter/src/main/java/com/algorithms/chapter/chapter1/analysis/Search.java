package com.algorithms.chapter.chapter1.analysis;

public class Search {

    public static int binarySearch(int point, int[] array){
        int head = 0;
        int length = array.length - 1;
        while (head <= length) {
            int mid = head + ((length - head) >> 1);
            if(point > array[mid]){
                head = mid + 1;
            }else if(point < array[mid]){
                length = mid - 1;
            }else {
                return mid;
            }
        }
        return - 1;
    }
}
