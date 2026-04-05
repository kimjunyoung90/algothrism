import java.util.Stack;

/**
 * @link https://leetcode.com/problems/decode-string/description/
 */
public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder current = new StringBuilder();
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            //숫자
            if(Character.isDigit(c)) {
                System.out.println(c - '0');
                count = count * 10 + c - '0';
                continue;
            }

            if('[' == c) {
                countStack.push(count);
                stringStack.push(current);
                current = new StringBuilder();
                count = 0;
            } else if (']' == c) {
                StringBuilder prev = stringStack.pop();
                prev.append(current.toString().repeat(Math.max(0, count)));
                current = prev;
            } else {
                current.append(c);
            }

        }

        return current.toString();
    }
    public static void main(String[] args) {
        String s = "3[a2[c]]";
        System.out.println(new DecodeString().decodeString(s));
    }
}
