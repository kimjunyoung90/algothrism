package 동적계획법;

import java.util.List;

/**
 * 최대_부분_배열 (The Maximum Subarray)
 *
 * 정수 리스트가 주어질 때 두 값을 구한다.
 * 1. 비어있지 않은 연속 부분 배열(subarray)의 최대 합
 * 2. 비어있지 않은 부분 수열(subsequence, 비연속 허용)의 최대 합
 * 비어있지 않은 = 적어도 하나의 원소는 포함해야한다.
 * 제약조건:
 * - 1 ≤ n ≤ 10^5
 * - -10^4 ≤ arr[i] ≤ 10^4
 *
 * @link https://www.hackerrank.com/challenges/maxsubarray/problem
 */
public class 최대_부분_배열 {
    public List<Integer> maxSubarray(List<Integer> arr) {
        int subarrayCur = arr.get(0);   // 현재 위치에서 끝나는 연속 합
        int subarrayBest = arr.get(0);  // 지금까지의 최대 연속 합
        int subseqSum = Math.max(arr.get(0), 0); // 양수들의 합 (음수 첫 원소는 제외)
        int maxElem = arr.get(0);                 // 전부 음수일 때 대비: 최대 단일 원소

        for (int i = 1; i < arr.size(); i++) {
            int x = arr.get(i);
            //부분 배열
            subarrayCur += x;
            subarrayBest = Math.max(subarrayBest, subarrayCur);

            //숫자 초기화
            if(subarrayCur < 0) {
                subarrayCur = 0;
            }
            //부분 수열
            if(x > 0) {
                subseqSum += x;
            }
            maxElem = Math.max(maxElem, x);
        }

        // 양수가 하나라도 있으면 그 합, 전부 음수면 최대 단일 원소
        subseqSum = subseqSum > 0 ? subseqSum : maxElem;
        return List.of(subarrayBest, subseqSum);
    }

    public static void main(String[] args) {
        최대_부분_배열 test = new 최대_부분_배열();

        System.out.println(test.maxSubarray(List.of(1, 2, 3, 4)));            // 기대값: [10, 10]
        System.out.println(test.maxSubarray(List.of(2, -1, 2, 3, 4, -5)));    // 기대값: [10, 11]
        System.out.println(test.maxSubarray(List.of(-1, -2, -3, -4)));        // 기대값: [-1, -1]
    }
}
