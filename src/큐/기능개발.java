package 큐;

import java.util.*;

/**
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42586
 */
public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> remaining = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int workDays = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            remaining.add(workDays);
        }

        while(!remaining.isEmpty()) {
            int current = remaining.poll();
            int count = 1;
            while(!remaining.isEmpty() && remaining.peek() <= current) {
                remaining.poll();
                count++;
            }
            answer.add(count);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        기능개발 test = new 기능개발();
        int[] result = test.solution(progresses, speeds);
        System.out.println(Arrays.toString(result));
    }
}
