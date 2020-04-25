package com.lzp.strategy;

public class CatComparatorWeight implements Comparator<Cat>
{
    public int compare(Cat o1, Cat o2) {
        return o2.getWeight()-o1.getWeight();
    }
}
