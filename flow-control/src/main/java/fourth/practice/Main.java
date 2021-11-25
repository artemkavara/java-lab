package fourth.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    /**
     * Counts the number of repetition of a digit in a given integer.
     *
     * @param a - integer
     * @param b - digit
     */

    public static long countNumberOfDigit(int a, int b) {
        List<Integer> digits = new ArrayList<>();
        while (a != 0) {
            digits.add(a % 10);
            a /= 10;
        }
        return digits.stream().filter(digit -> digit == b).count();
    }

    /**
     * Calculates characteristics about the list of numbers using forEach loop.
     *
     * @param listOfNumbers - list of doubles
     * @return Map<String, Number>
     */

    public static Map<String, Number> getInformationAboutTheListV1(Double... listOfNumbers) {
        int count = 0;
        double max = 0, min = 0, sum = 0;
        for (Double number : listOfNumbers) {
            if (count == 0) {
                max = number;
                min = number;
            } else {
                max = max < number ? number : max;
                min = min > number ? number : min;
            }
            count += 1;
            sum += number;
        }
        Map<String, Number> informationAboutStream = new HashMap<>();

        informationAboutStream.put("Count", count);
        informationAboutStream.put("Maximum", max);
        informationAboutStream.put("Minimum", min);
        informationAboutStream.put("Average", sum / count);

        return informationAboutStream;
    }

    /**
     * Calculates characteristics about the list of numbers using streams.
     *
     * @param listOfNumbers - list of doubles
     * @return Map<String, Number>
     */

    public static Map<String, Number> getInformationAboutTheListV2(Double... listOfNumbers) {

        Map<String, Number> informationAboutStream = new HashMap<>();

        informationAboutStream.put("Count", Arrays.stream(listOfNumbers).count());
        informationAboutStream.put("Maximum", Arrays.stream(listOfNumbers).mapToDouble(v -> v).max().orElseThrow(NullPointerException::new));
        informationAboutStream.put("Minimum", Arrays.stream(listOfNumbers).mapToDouble(v -> v).min().orElseThrow(NullPointerException::new));
        informationAboutStream.put("Average", Arrays.stream(listOfNumbers).mapToDouble(v -> v).average().orElseThrow(NullPointerException::new));

        return informationAboutStream;
    }

    /**
     * Prints the table following the pattern:
     * 0
     * 0 1
     * 0 1 2
     */

    public static void printFirstTable(int numberOfRows) {
        IntStream.range(0, numberOfRows).forEach(number -> System.out.println(IntStream.rangeClosed(0, number).mapToObj(n -> n + " ").collect(Collectors.joining())));
    }

    /**
     * Prints the table following the pattern:
     *     1
     *   2 1
     * 3 2 1
     */

    public static void printSecondTable(int numberOfRows) {
        IntStream.rangeClosed(1, numberOfRows).forEach(number -> System.out.println(
                IntStream.rangeClosed(1, numberOfRows - number).mapToObj(n -> "  ").collect(Collectors.joining()) +
                        IntStream.rangeClosed(1, number).boxed().sorted(Collections.reverseOrder()).map(n -> n + " ").collect(Collectors.joining())));
    }

    public static void main(String[] args) {

        System.out.println("1ST TASK");
        System.out.print("a - " + 1223331 + " b - " + 1 + " result: ");
        System.out.println(countNumberOfDigit(1223331, 1));
        System.out.print("a - " + 312312 + " b - " + 3 + " result: ");
        System.out.println(countNumberOfDigit(312312, 3));
        System.out.print("a - " + 1111111111 + " b - " + 2 + " result: ");
        System.out.println(countNumberOfDigit(1111111111, 2));

        System.out.println(Arrays.toString(new double[]{1., 5., -11., 12., 14.}));

        System.out.println("2ND TASK (WITHOUT STREAM)");
        System.out.println(getInformationAboutTheListV1(1., 5., -11., 12., 14.));
        System.out.println("2ND TASK (WITH STREAM)");
        System.out.println(getInformationAboutTheListV2(1., 5., -11., 12., 14.));

        System.out.println("3RD TASK (A)");
        printFirstTable(7);

        System.out.println("3RD TASK (B)");
        printSecondTable(8);
    }

}
