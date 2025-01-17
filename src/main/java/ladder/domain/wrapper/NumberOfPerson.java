package ladder.domain.wrapper;

public class NumberOfPerson {

    private final int numberOfPerson;

    private NumberOfPerson(int numberOfPerson) {
        this.numberOfPerson = numberOfPerson;
    }

    public static NumberOfPerson of(int numberOfPerson) {
        validateNumber(numberOfPerson);
        return new NumberOfPerson(numberOfPerson);
    }

    private static void validateNumber(int numberOfPerson) {
        if (!isNaturalNumber(numberOfPerson)) {
            throw new IllegalArgumentException("numberOfPerson은 2이상이어야 합니다.");
        }
    }

    private static boolean isNaturalNumber(int numberOfPerson) {
        return numberOfPerson > 1;
    }

    public int getNumberOfPerson() {
        return numberOfPerson;
    }
}
