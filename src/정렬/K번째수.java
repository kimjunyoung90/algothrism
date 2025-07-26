package 정렬;

import java.util.Arrays;

/**
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42748?language=java
 */
public class K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length ;i++) {
            int[] command = commands[i];
            int from = command[0] - 1;
            int to = command[1];
            int target = command[2] - 1;

            int[] sliced = Arrays.copyOfRange(array, from, to);
            Arrays.sort(sliced);
            answer[i] = sliced[target];
        }
        return answer;
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
        System.out.println(Arrays.toString(result));
    }
}
