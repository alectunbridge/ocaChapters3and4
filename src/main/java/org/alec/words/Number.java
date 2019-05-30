package org.alec.words;

public class Number extends Word{
    private final Integer i;

    public Number(Integer i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return i.toString();
    }
}
