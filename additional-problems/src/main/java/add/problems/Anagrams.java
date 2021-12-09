package add.problems;

import java.util.TreeMap;

public class Anagrams {

    /**
     * Creates a map and stores calculated occurrences of each symbols in a word
     * @param word - checked string
     */

    public static TreeMap<Byte, Integer> countNumberOfLetters(String word){
        TreeMap<Byte, Integer> mapOfBytes = new TreeMap<>();
        byte[] arrayOfBytes = word.getBytes();
        for (byte wordByte: arrayOfBytes){
            mapOfBytes.computeIfPresent(wordByte, (key, value) -> value+1);
            mapOfBytes.putIfAbsent(wordByte, 1);
        }
        return mapOfBytes;
    }

    public static Boolean checkIfWordsAreAnagrams(String word1, String word2){
        TreeMap<Byte, Integer> mapOfFirstWord = countNumberOfLetters(word1);
        TreeMap<Byte, Integer> mapOfSecondWord = countNumberOfLetters(word2);
        return mapOfFirstWord.equals(mapOfSecondWord);
    }

    public static void main(String[] args){
        assert checkIfWordsAreAnagrams("java16", "61avaj");
        assert checkIfWordsAreAnagrams("java16", "1jvaa6");
        assert !checkIfWordsAreAnagrams("java16", "java14");
    }

}
