package 완전탐색;

import java.util.Arrays;

/**
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42840
 */
public class 모의고사 {

    final int[] A_PATTERN = { 1, 2, 3, 4, 5 };
    final int[] B_PATTERN = { 2, 1, 2, 3, 2, 4, 2, 5 };
    final int[] C_PATTERN = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

    public int[] solution(int[] answers) {

        int[] scores = {0, 0, 0};

        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            if(answer == A_PATTERN[i % 5]) scores[0]++;
            if(answer == B_PATTERN[i % 8]) scores[1]++;
            if(answer == C_PATTERN[i % 10]) scores[2]++;
        }

        int max = Math.max(scores[0], Math.max(scores[1], scores[2]));
        int topScoreCount = 0;
        for (int score : scores) {
            if (score == max) {
                topScoreCount++;
            }
        }
        int[] answer = new int[topScoreCount];
        int topScoreIdx = 0;
        for (int i = 0; i < scores.length; i++) {
            if(scores[i] == max) {
                answer[topScoreIdx++] = i + 1;
            }
        }

        return answer;
    }
}
