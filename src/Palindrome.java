/**
 * https://leetcode.com/problems/valid-palindrome/description/
 * 팰린드롬
 * - 대문자는 모두 소문자로 변환
 * - 영숫자(alphanumeric; 문자 or 숫자)만 고려
 * - 정제한 문자열이 앞에서 읽으나 뒤에서 읽으나 동일하면 팰린드롬
 *
 * 시간복잡도 : O(n)
 * 공간복잡도 : O(n)
 *  Java에서 String은 immutable함. 수정되지 않음. 항상 새로운 문자열을 만듬. 소문자 전환이나 정규식으로 치환 시 새로운 문자열을 만듬 = 문자열 길이만큼 추가적인 메모리 공간 사용 = 하나의 문자열에 동일한 길이 메모리 공간을 사용하여 공간 복잡도는 O(n)
 */
public class Palindrome {
    public boolean isPalindrome(String s) {
        //1. 대문자를 소문자로 변환
        s = s.toLowerCase();

        //2. 영어 숫자 외 문자 제거
        s = s.replaceAll("[^a-z0-9]", "");

        //3. 앞에서 읽나 뒤에서 읽나 동일한지 확인(pointer 사용)
        int left = 0, right = s.length() - 1;
        while(left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if(leftChar != rightChar) return false;
            left++;
            right--;
        }
        return true;
    }
}

class PalindromeMain {
    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
        String s = "race a car";
        System.out.println(new Palindrome().isPalindrome(s));
    }
}
