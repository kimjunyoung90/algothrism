package 완전탐색;

import java.util.ArrayList;

public class 모음사전 {
    char[] chars = { 'A', 'E', 'I', 'O', 'U' };

    // 사전에 들어갈 모든 경우의 수를 저장할 배열
    ArrayList<String> dictionary = new ArrayList<>();

    public void addDictionary(String word) {
        if (word.length() == 5) return;
        for(char alphabet : chars) {
            dictionary.add(word + alphabet);
            addDictionary(word + alphabet);
        }
    }

    public int solution(String word) {
        addDictionary("");
        return dictionary.indexOf(word) + 1;
    }
}
