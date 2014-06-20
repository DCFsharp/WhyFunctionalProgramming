// factorsOf() method returns an IntStream
// allowing to chain other operations onto it
// The return from factorsOf() isn a stream which hasn’t generated any values yet

import java.util.stream.IntStream;
import static java.util.stream.IntStream.range;

public class NumberClassifierJ8 {

    public static IntStream factorsOf(int number) {

        return range(1, number + 1)
                .filter(potential -> number % potential == 0);
    }

    public static int sum(int number) {
        return factorsOf(number).sum() - number;
    }

    public static boolean isPerfect(int number) {
        return sum(number) == number;
    }

    public static boolean isAbundant(int number) {
        return sum(number)> number;
    }

    public static boolean isDeficient(int number) {
        return sum(number) < number;
    }
}