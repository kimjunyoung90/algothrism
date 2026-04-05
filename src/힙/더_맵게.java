package 힙;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42626
 */
public class 더_맵게 {
    public int solution(int[] scoville, int K) {
        // TODO(human): PriorityQueue를 활용하여 구현하세요.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.addAll(Arrays.stream(scoville).boxed().toList());

        int shuffle = 0;
        while(pq.peek() < K) {
            if(pq.size() == 1) return -1;
            int newSc = pq.poll() + pq.poll() * 2;
            pq.offer(newSc);
            shuffle++;
        }
        return shuffle;
    }
    public static void main(String[] args) {
        더_맵게 test = new 더_맵게();
        int[] scoville = { 1, 2, 3, 9, 10, 12 };
        int K = 7;
        int result = test.solution(scoville, K);
        System.out.println(result);
    }
}
