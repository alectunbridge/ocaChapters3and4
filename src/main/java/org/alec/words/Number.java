package org.alec.words;

public class Number extends Word{
    static final public Integer i;

    public Number(Integer i) {
        i = i;
    }

    @Override
    public String toString() {
        return i.toString();
    }
}
