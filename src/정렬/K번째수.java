package 정렬;

import java.util.Arrays;
import java.util.List;

/**
 * K번째수
 *
 * 배열 array의 i번째 숫자부터 j번째 숫자까지 자른 뒤 정렬했을 때,
 * k번째에 있는 수를 구한다. commands의 각 [i, j, k]에 대해 결과를 모아 반환한다.
 *
 * 제약조건:
 * - array의 길이: 1 이상 100 이하
 * - array의 각 원소: 1 이상 100 이하
 * - commands의 길이: 1 이상 50 이하
 * - commands의 각 원소의 길이: 3
 *
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42748
 */
public class K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        // TODO(human): 구현하세요.
        int[] result = new int[commands.length];

        int i = 0;
        for (int[] command : commands) {
            int from = command[0] - 1;
            int to = command[1];
            int th = command[2] - 1;
            int[] sub = Arrays.copyOfRange(array, from, to);
            Arrays.sort(sub);
            result[i++] = sub[th];
        }
        //k번째에 있는 수 구하기
        return result;
    }

    public static void main(String[] args) {
        K번째수 test = new K번째수();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
        };
        int[] result = test.solution(array, commands);
        System.out.println(Arrays.toString(result)); // 기대값: [5, 6, 3]
    }
}
