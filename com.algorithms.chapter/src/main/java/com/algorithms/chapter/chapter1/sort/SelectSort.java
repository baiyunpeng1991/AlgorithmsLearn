package com.algorithms.chapter.chapter1.sort;

/**
 * 选择排序
 */
public class SelectSort extends Sort{
    @Override
    public void sort(Comparable[] a) {
        int count = 0;
        int count2 = 0;
        for (int i = 0; i < a.length ; i++) {
            int min = i;
            for (int j = i+1; j < a.length ; j++) {
                if(less(a[j],a[i])){
                   // exchange(a,i,j); 55，17
                    count++;
                    min = j;
                }
                exchange(a,i,min);
                count2++;
            }
            count2++;
        }
        show(a);
        System.out.println("count = [" + count2 + "],["+count+"]");
    }

}
// 5,4,3,2,1
// 5,4,3,2,1

//内层循环第一步
//4与5比true
//4,5,3,2,1
//3和4比true
//3,5,4,2,1
//2和3比true
//2,5,4,3,1
//1和2比true
//1,5,4,3,2

//外层循环结果
// 1,5,4,3,2
// 1,2,5,4,3
// 1,2,3,5,4
// 1,2,3,4,5