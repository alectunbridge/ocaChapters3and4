package org.alec.words;

public class FizzBuzz extends Word {
    protected Word fizz;
    protected Word buzz;

    public FizzBuzz() {
        fizz = null;
        buzz = null;
    }

    static {
        fizz = new Fizz();
        buzz = new Buzz();
    }

    @Override
    public String toString() {
        return new StringBuilder().append(fizz.toString()).append(buzz.toString()).toString();
    }
}
