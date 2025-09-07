package 이진탐색;

import java.util.Arrays;

/**
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/43238
 */
public class 입국심사 {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long minTime = 0;
        long maxTime = (long) times[times.length - 1] * n;
        long optimalTime = 0;

        while (minTime <= maxTime) {
            long midTime = minTime + (maxTime - minTime) / 2;
            long processedPeople = 0L;

            for (int time : times) {
                processedPeople += midTime / time;
                if(processedPeople >= n) break;
            }

            if(processedPeople >= n) {
                optimalTime = midTime;
                maxTime = midTime - 1;
            } else {
                minTime = midTime + 1;
            }
        }

        return optimalTime;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};
        System.out.println(new 입국심사().solution(n, times));
    }
}
