package 이진탐색;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 카누_선수
 *
 * 같은 인원의 4개 반에서 각각 1명씩 뽑아 4명의 몸무게 합이
 * 특정 값 k에 가장 근사하도록 한다. 근사값이 두 개(k보다 작은 쪽/큰 쪽)면
 * 더 작은 합을 택한다. 선택된 4명의 몸무게 총합을 구한다.
 *
 * 제약조건:
 * - 특정 값 k: 1 ≤ k ≤ 40,000,000
 * - 각 반 학생 수 n: 1 ≤ n ≤ 1,000
 * - 각 몸무게: 1 ≤ w ≤ 10,000,000
 *
 * @link https://takjoon.takijk.xyz/problems/32833
 */
public class 카누_선수 {
    public int solution(int k, int[][] classes) {

        Set<Integer> sumList = new HashSet<>();
        for (int a : classes[0]) {
            for (int b : classes[1]) {
                for (int c : classes[2]) {
                    for (int d : classes[3]) {
                        sumList.add(a + b + c + d);
                    }
                }
            }
        }

        //정렬
        List<Integer> sorted = sumList.stream().sorted().toList();

        //근사치 구하기
        int minGap = Integer.MAX_VALUE;
        int answer = 0;
        for (int i = 0; i < sorted.size(); i++) {
            int candidate = sorted.get(i);
            int gap = Math.abs(k - candidate);
            if(gap < minGap) {
                minGap = gap;
            } else if (gap == minGap){
                answer = Math.min(candidate, sorted.get(i - 1));
                break;
            } else {
                answer = sorted.get(i - 1);
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        카누_선수 test = new 카누_선수();
        System.out.println(test.solution(300, new int[][]{
                {60, 52, 80, 40},
                {75, 68, 88, 63},
                {48, 93, 48, 54},
                {56, 73, 49, 75}})); // 기대값: 301
        System.out.println(test.solution(8, new int[][]{
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3}})); // 기대값: 8
        System.out.println(test.solution(32, new int[][]{
                {2, 5},
                {9, 4},
                {10, 20},
                {4, 2}})); // 기대값: 31
    }
}
