package add.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Parentheses {

    /**
     * Checks if parentheses is correct
     * @param parentheses
     * @return
     */
    public static boolean checkIfCorrectParentheses(String parentheses){
        if (parentheses.equals("(") || parentheses.equals(")")){
            return false;
        }
        if (parentheses.equals("()")){
            return true;
        }
        char[] listOfChars = parentheses.toCharArray();
        List<Character> arrayListOfChars = new ArrayList<>();
        Set<Character> setOfChars = new HashSet<>();
        for (char elem: listOfChars){
            arrayListOfChars.add(elem);
            setOfChars.add(elem);
        }
        if(setOfChars.size() !=2){
            return false;
        }
        if(arrayListOfChars.get(0)!= '('){
            return false;
        }
        int firstIndex = arrayListOfChars.indexOf(')');
        arrayListOfChars.remove(firstIndex);
        arrayListOfChars.remove(firstIndex - 1);
        StringBuilder stringBuilder = new StringBuilder();
        arrayListOfChars.forEach(stringBuilder::append);
        return checkIfCorrectParentheses(stringBuilder.toString());
    }

    public static void main(String[] args){
        // (())() -> ()() -> () -> true
        // ((()) -> (() -> ( -> false
        assert !checkIfCorrectParentheses("(");
        assert !checkIfCorrectParentheses(")");
        assert !checkIfCorrectParentheses("((((((((");
        assert !checkIfCorrectParentheses(")))))))");
        assert checkIfCorrectParentheses("()");
        assert checkIfCorrectParentheses("(())");
        assert checkIfCorrectParentheses("()()");
        assert checkIfCorrectParentheses("(())()");
        assert checkIfCorrectParentheses("()((()()))");
        assert !checkIfCorrectParentheses(")()");
        assert !checkIfCorrectParentheses("((())");
        assert !checkIfCorrectParentheses("0");
    }

}
