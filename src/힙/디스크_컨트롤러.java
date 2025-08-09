package 힙;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 디스크_컨트롤러 {
    public int solution(int[][] jobs) {
        // 1. 작업들 진입시간 기준 정렬
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));

        // 2. pq 생성 및 작업 소요시간 기준 min-heap 생성
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        int n = jobs.length; //전체 작업 수
        int idx = 0; //현재 작업
        int time = 0; //현재 시간
        long total = 0; //전체 작업 반환 시간

        while(idx < n || !pq.isEmpty()) {
            //pq에 시간순 작업 적재
            while(idx < n && jobs[idx][0] <= time) {
                pq.offer(jobs[idx++]);
            }

            if(!pq.isEmpty()) {
                int[] job = pq.poll();
                time += job[1];
                total += time - job[0];
            } else {
                time = Math.max(time, jobs[idx][0]);
            }
        }

        return (int) (total / n);
    }

    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {3, 5}};
        디스크_컨트롤러 test = new 디스크_컨트롤러();
        int result = test.solution(jobs);
        System.out.println(result);
    }
}
