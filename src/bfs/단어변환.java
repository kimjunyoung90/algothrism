package bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/43163?language=java
 */
public class 단어변환 {

    class WordNode {
        String word;
        int depth;

        WordNode(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }

    public int solution(String begin, String target, String[] words) {

        //target이 words에 없다면 변환 불가
        if(!Arrays.asList(words).contains(target)) return 0;

        Queue<WordNode> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];

        queue.offer(new WordNode(begin, 0));

        while(!queue.isEmpty()) {
            WordNode current = queue.poll();

            //target 도달 시 종료
            if(current.word.equals(target)) return current.depth;

            //변환 가능한 다음 단어 탐색
            for(int i = 0; i < words.length; i++) {
                if(!visited[i] && isOneCharDiff(current.word, words[i])) {
                    visited[i] = true;
                    queue.offer(new WordNode(words[i], current.depth + 1));
                }
            }
        }

        return 0;
    }

    private boolean isOneCharDiff(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) {
                diff++;
            }
            if(diff > 1) {
                return false;
            }
        }
        return diff == 1;
    }

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
        단어변환 test = new 단어변환();
        System.out.println(test.solution(begin, target, words));
    }
}
