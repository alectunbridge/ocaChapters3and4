package org.alec.fizzbuzz;


import org.alec.words.Number;
import org.alec.words.*;

import java.util.function.Predicate;

public class Game {

    private Integer currentNumber = 1;

    private Word[] words = {new Fizz(), new Buzz(), new FizzBuzz()};

    private String play() {
        Word result;

        if (isDivisibleByThreeAndFive()) {
            result = words[2];
        } else if (isDivisibleByThree()) {
            result = words[0];
        } else if (isDivisibleByFive()) {
            result = words[1];
        } else {
            result = new Number(currentNumber);
        }
        currentNumber++;
        return result.toString();
    }

    private boolean isDivisibleBy(Predicate<Integer> predicate){
        return predicate.test(currentNumber);
    }

    private boolean isDivisibleByThreeAndFive() {
        Predicate<Integer> divisibleByThreePredicate = number -> number % 3 == 0;
        Predicate<Integer> divisibleByFivePredicate = number -> number % 5 == 0;
        return isDivisibleBy(divisibleByThreePredicate.and(divisibleByFivePredicate));
    }

    private boolean isDivisibleByFive() {
        return currentNumber % 5 == 0;
    }

    private boolean isDivisibleByThree() {
        String oldTally = "";
        for (int i = 0; i < currentNumber; i++) {
            oldTally += "I";
        }

        while (true) {
            String newTally = oldTally.replace("III", "");
            if(oldTally.equals(newTally)){
                break;
            }
            oldTally = newTally;
        }
        return oldTally.isEmpty();
    }

    public static void main(String[] args) {
        Game game = new Game();
        for (Integer i = 0; i < 100; i++) {
            System.out.println(game.play());
        }
    }
}
