import java.util.Stack;

/**
 * @link https://leetcode.com/problems/valid-parentheses/description/
 */
public class ValidParentheses {
    public boolean isValid(String s) {

        //엣지 케이스
        if(s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '[' || c == '{' || c == '(') {
                stack.push(c);
            } else {

                //닫기 여러번
                if (stack.isEmpty()) return false;

                char open = stack.pop();

                switch(open) {
                    case '[' -> { if(c != ']') return false; }
                    case '{' -> { if(c != '}') return false; }
                    case '(' -> { if(c != ')') return false; }
                }

            }
        }

        return stack.isEmpty();
    }
}
