
// all methods accept number as a parameter, internal not state exists

// because no internal state, I have less need for scoping
    // all methods are public static (pure functions)

// less efficient for repeating classifications (no caching)
    // removing state I have to calculate every time the factors

public class NumberClassifierFP1 {

    public static boolean isFactor(int number, int factor) {
        return number % factor == 0;
    }

    //  This method encapsulate the logic to calculate the
    // factors. No need of internal state
    public static Set<Integer> factors(int number) {
        Set<Integer> factors = new HashSet<Integer>();
        for (int i = 1; i <= sqrt(number); i++) {
            if (isFactor(number, i)) {
                factors.add(i);
                factors.add(number / i);
            }
        }
        return factors;
    }

    public static int sum(Set<Integer> factors) {
        int sum = 0;
        for(Integer i : factors)
            sum += i.intValue();
        return sum;
    }

    public static boolean isPerfect( int number) {
        return sum(factors(number)) == number;
    }

    public static boolean isAbundant( int number) {
        return sum(factors(number)) > number;
    }

    public static boolean isDeficient( int number) {
        return sum(factors(number)) < number;
    }
}
