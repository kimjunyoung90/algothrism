package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 단어_변환
 *
 * begin에서 target으로 변환하는 최소 단계 수를 구하는 문제.
 * 한 번에 한 개의 알파벳만 바꿀 수 있고, words에 속한 단어로만 변환 가능.
 *
 * 제약조건:
 * - 모든 단어는 소문자 알파벳으로만 구성
 * - 단어 길이: 3~10자, 모든 단어 동일 길이
 * - words 크기: 3~50개, 중복 없음
 * - begin과 target은 서로 다름
 * - 변환 불가능 시 0 반환
 *
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/43163
 */
public class 단어변환 {

    class Node {
        String word;
        int depth;

        public Node(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }

    public int solution(String begin, String target, String[] words) {
        // TODO(human): 구현하세요.
        //hit -> cog
        //한 번에 한개의 알파벳만 변경 가능
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(begin, 0));

        boolean[] visited = new boolean[words.length];

        while (!q.isEmpty()) {
            Node curr = q.poll();
            if(curr.word.equals(target)) return curr.depth;
            for (int i = 0; i < words.length; i++) {
                if(!visited[i] && isOneCharDiff(curr.word, words[i])) {
                    visited[i] = true;
                    q.offer(new Node(words[i], curr.depth + 1));
                }
            }
        }

        return 0;
    }

    public boolean isOneCharDiff(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }

    public static void main(String[] args) {
        단어변환 test = new 단어변환();

        // 예제 1: 기대값 4
        String begin1 = "hit";
        String target1 = "cog";
        String[] words1 = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(test.solution(begin1, target1, words1));

        // 예제 2: 기대값 0
        String begin2 = "hit";
        String target2 = "cog";
        String[] words2 = {"hot", "dot", "dog", "lot", "log"};
        System.out.println(test.solution(begin2, target2, words2));
    }
}
