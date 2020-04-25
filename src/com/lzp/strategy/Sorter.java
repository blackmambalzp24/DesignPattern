package com.lzp.strategy;

import java.util.Arrays;

public class Sorter<T> {


    public void sort(T[] t,Comparator<T> comparator) {
        for (int k = 0; k <t.length-1; k++) {
            int minPos = k;
            for (int i = minPos+1; i <t.length ; i++) {
                if (comparator.compare(t[i],t[minPos])<0)
                {
                    minPos=i;
                }
            }
            swap(t,minPos,k);
        }
    }



    private   void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main(String[] args) {

        Cat[] cats = new Cat[]{new Cat(2,3),new Cat(4,7),new Cat(2,4)};
//        new Sorter<Cat>().sort(cats,new CatComparatorHeight());
        new Sorter<Cat>().sort(cats,new CatComparatorWeight());
        System.out.println(Arrays.toString(cats));

    }
}
