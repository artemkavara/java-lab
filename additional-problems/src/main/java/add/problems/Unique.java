package add.problems;

import java.util.Optional;
import java.util.TreeMap;

public class Unique {

    public static Boolean ifUnique(String word){
        TreeMap<Byte, Integer> mapOfBytes = new TreeMap<>();
        byte[] arrayOfBytes = word.getBytes();
        for (byte wordByte: arrayOfBytes){
            mapOfBytes.computeIfPresent(wordByte, (key, value) -> value+1);
            mapOfBytes.putIfAbsent(wordByte, 1);
        }
        Optional<Integer> optionalInteger = mapOfBytes.values().stream().filter(i -> i>1).findAny();
        return optionalInteger.isEmpty();
    }

    public static void main(String[] args){
        assert ifUnique("abcde");
        assert ifUnique("12345");
        assert !ifUnique("112345");
    }

}
