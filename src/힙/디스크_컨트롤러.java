package 힙;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42627
 */
public class 디스크_컨트롤러 {
    public int solution(int[][] jobs) {
        //요청 시각이 빠른 순 정렬
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[1]));
        int time = 0;
        int idx = 0;
        int total = 0;

        //반복
        while(idx < jobs.length || !pq.isEmpty()) {
            //현재 시간 이전에 도착한 작업 큐에 넣기
            while (idx < jobs.length && jobs[idx][0] <= time) {
                pq.add(jobs[idx++]);
            }

            //작업이 비어 있으면 다음 작업 시간으로 점프
            if (pq.isEmpty()) {
                time = jobs[idx][0];
                continue;
            }
            //최소 작업 시간 작업 꺼내서 처리
            int[] job = pq.poll();
            time += job[1];
            total += time - job[0];
        }

        return total / jobs.length;
    }

    public static void main(String[] args) {
        디스크_컨트롤러 test = new 디스크_컨트롤러();
        int[][] jobs = {{0, 3}, {1, 9}, {3, 5}};
        int result = test.solution(jobs);
        System.out.println(result); // 기대값: 9
    }
}
