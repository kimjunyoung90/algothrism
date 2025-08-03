package 큐;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/12906?language=java
 */
public class 같은숫자는싫어 {

    public int[] solution(int []arr) {
        int[] answer = {};

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        int prev = -1;
        Queue<Integer> queue = new LinkedList<>();
        for(int current : arr) {
            if(current != prev) queue.add(current);
            prev = current;
        }

        answer = new int[queue.size()];
        int i = 0;
        while(!queue.isEmpty()) {
            answer[i++] = queue.poll();
        }
        return answer;
    }

    public static void main(String[] args) {
        같은숫자는싫어 test = new 같은숫자는싫어();

        int[] arr = { 1,1,3,3,0,1,1 };
        System.out.println(Arrays.toString(test.solution(arr)));
    }
}
