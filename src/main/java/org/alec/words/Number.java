package org.alec.words;

public class Number extends Word{
    final private Integer i;

    public Number(Integer i) {
        i = i;
    }

    @Override
    public String toString() {
        return i.toString();
    }
}
