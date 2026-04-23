package bfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

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
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        if (!wordSet.contains(target)) return 0;

        Set<String> visited = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(begin, 0));
        visited.add(begin);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.word.equals(target)) return curr.depth;

            // 현재 단어의 각 위치에 a~z를 대입해 '한 글자 다른' 이웃 후보를 만든다.
            // 후보가 wordSet에 존재하고 아직 방문 전이면 큐에 추가.
            char[] chars = curr.word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char original = chars[i];
                // TODO(human): a~z로 치환하면서 이웃 탐색
                chars[i] = original;
            }
        }

        return 0;
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
