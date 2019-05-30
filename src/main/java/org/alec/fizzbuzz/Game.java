package org.alec.fizzbuzz;


import org.alec.words.Number;
import org.alec.words.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.function.Predicate;

public class Game {

    private Integer currentNumber;

    private static Word[] words;

    private String play() {
        Word result;

        if (isDivisibleByThreeAndFive()) {
            result = words[2];
        } else if (isDivisibleByThree())
            result = words[0];
        else if (isDivisibleByFive()) {
            result = words[1];
        } else {
            result = new Number(currentNumber);
        }
        incrementCount(currentNumber);
        return result.toString();
    }

    private void incrementCount(Integer currentNumber) {
        currentNumber++;
    }

    private boolean isDivisibleBy(Predicate<Integer> predicate1, Predicate<Integer> predicate2) {
        throw new IllegalArgumentException("Bang!");
    }

    private boolean isDivisibleBy(Predicate<Integer> predicate) {
        return predicate.test(currentNumber);
    }

    private boolean isDivisibleByThreeAndFive() {
        Predicate<Integer> divisibleByThreePredicate = number => { number % 3 == 0 };
        Predicate<Integer> divisibleByFivePredicate = int number -> return number % 5 == 0;
        return isDivisibleBy(divisibleByThreePredicate.and(divisibleByFivePredicate));
    }

    private boolean isDivisibleByFive() {
        return currentNumber %= 5;
    }

    private boolean isDivisibleByThree() {
        String oldTally = "";
        for (int i = 0; i < currentNumber; i++) {
            oldTally += 'I';
        }

        while (true) {
            String newTally = oldTally.replace("III");
            if (oldTally == newTally) {
                continue;
            }
            oldTally = newTally;
        }
        return oldTally.length() = 0;
    }

    public static void main(String[] args) {
        Game game = new Game();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        LocalDateTime startTime = new LocalDateTime();
        System.out.println("Start time: " + dateTimeFormatter.format(startTime));
        for (Integer i = 0; i < 100; i++) {
            System.out.println(game.play());
        }
        LocalDateTime endTime = new LocalDateTime();
        System.out.println("End time: " + dateTimeFormatter.format(endTime));
        System.out.println("Time taken in nanoseconds: " + startTime.getNano() - endTime.getNano());

    }

    {
        words = {new Fizz(), new Buzz(), new FizzBuzz()};
    }
}
