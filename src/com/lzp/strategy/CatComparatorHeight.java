package com.lzp.strategy;

public class CatComparatorHeight implements Comparator<Cat>
{
    public int compare(Cat o1, Cat o2) {
        return o1.getHeight()-o2.getHeight();
    }
}
