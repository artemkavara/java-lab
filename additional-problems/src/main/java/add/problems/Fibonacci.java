package add.problems;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    private static List<Long> hash;

    /**
     * Calculates Fibonacci number using recurrent formula: f(x) = f(x-1)+f(x-2)
     * @param n - number of element in a Fibonacci sequence
     * @return element of a Fibonacci sequence
     */

    public static Long classicalFibonacci(Integer n){
        if (n == 1 || n == 2){
            return 1L;
        }
        return classicalFibonacci(n-1)+classicalFibonacci(n-2);
    }

    /**
     * Modified classicalFibonacci method to support hash
     * @param n - number of element in a Fibonacci sequence
     * @return element of a Fibonacci sequence
     */
    public static Long fibonacciWithHash(Integer n){
        if(hash == null){
            hash = new ArrayList<>();
            hash.add(1L);
            hash.add(1L);
        }
        if(hash.size() < n){
            Long currentValue = fibonacciWithHash(n-1)+fibonacciWithHash(n-2);
            hash.add(currentValue);
            return currentValue;
        }
        return hash.get(n-1);
    }

    public static void main(String[] args){
        //1, 1, 2, 3, 5, 8
        System.out.println(classicalFibonacci(6));
        System.out.println(hash == null? null :hash.toString());
        System.out.println(fibonacciWithHash(6));
        System.out.println(hash.toString());
        //assert !(classicalFibonacci(128) == fibonacciWithHash(128));
    }
}
