package simple;

import java.util.Stack;

public class Solution_22 {

    /**
     *
     * @param args
     */
    public static void main ( String[] args ) {
        boolean isValid = isValid ( "([]" );
        System.out.println (isValid);
    }

    /**
     *
     * @param c
     * @return
     */
    public static boolean isLeft(char c){
        if(c == '{' || c == '[' || c == '('){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     *
     * @param c
     * @return
     */
    public static boolean isRight(char c){
        if(c == '}' || c == ']' || c == ')'){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        boolean isValid = false;
        Stack<Character> stack = new Stack<Character> ();
        char[] charArray = s.toCharArray ();
        if(charArray.length <= 0)
            return true;
        int i = 0;
        for (; i < charArray.length; i++) {
            if (isLeft ( charArray[i] )) {
                stack.push ( charArray[i] );
            }
            else if(isRight ( charArray[i] )) {
                // 如果栈为空，却有右括号，那么一定没有左括号，直接返回失败
                if(stack.empty ())
                    break;
                char popChar = stack.pop ();
                switch (charArray[i]) {
                    case '}':
                        isValid = popChar == '{';
                        break;
                    case ']':
                        isValid = popChar == '[';
                        break;
                    case ')':
                        isValid = popChar == '(';
                        break;
                    default:
                        break;
                }
                if (!isValid)
                    break;
            }
            else{
                // 不是左括号也不是右括号，是别的字符，直接跳过
                continue;
            }
        }
        if(i < charArray.length){
            return false;
        }

        return isValid;
    }
}
