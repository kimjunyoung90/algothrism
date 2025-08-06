package 힙;

import java.util.PriorityQueue;

/**
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42626
 */
public class 더_맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i : scoville) {
            queue.add(i);
        }

        while(queue.size() > 1) {
            if(queue.peek() >= K) break;

            int first = queue.poll();
            int second = queue.poll();
            int newScoville = first + (second * 2);
            queue.add(newScoville);
            answer++;
        }

        return queue.peek() < K ? -1 : answer;
    }
    public static void main(String[] args) {
        더_맵게 test = new 더_맵게();
        int[] scoville = { 1, 2, 3, 9, 10, 12 };
        int K = 7;
        int result = test.solution(scoville, K);
        System.out.println(result);
    }
}
