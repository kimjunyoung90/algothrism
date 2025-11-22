/**
 * @link https://leetcode.com/problems/valid-anagram/description/
 */
public class 애너그램 {

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for(int c : count) {
            if (c != 0) return false;
        }

        return true;
    }

}

class Main {
    public static void main(String[] args) {
        System.out.println(new 애너그램().isAnagram("rat", "tar"));
    }
}
