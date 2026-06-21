package 이진탐색;

import java.util.Arrays;

/**
 * 두_배열의_합 (백준 2143)
 *
 * 두 배열 A, B가 주어졌을 때, A의 부 배열 합 + B의 부 배열 합 = T가 되는
 * 부 배열 쌍의 개수를 구한다.
 *
 * 제약조건:
 * - -1,000,000,000 ≤ T ≤ 1,000,000,000
 * - 1 ≤ n, m ≤ 1,000
 * - 각 원소의 절댓값은 1,000,000 이하
 *
 * @link https://takjoon.takijk.xyz/problems/12399
 */
public class 두_배열의_합 {
    public long solve(int T, int[] A, int[] B) {
        // A의 부 배열의 합에 B의 부 배열의 합을 더해서 T가 되는 모든 부 배열 쌍의 개수
        // A 부 배열의 합
        // B 부 배열의 합
        int[] aSum = new int[A.length];
        int[] bSum = new int[B.length];

        aSum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            aSum[i] = aSum[i - 1] + A[i];
        }

        bSum[0] = B[0];
        for (int i = 1; i < B.length; i++) {
            bSum[i] = bSum[i - 1] + B[i];
        }

        //두 부 배열 경우의 수를 다 구한다음 pointer로
        //실제 부 배열의 개수가 n * (n + 1) / 2라고??
        int[] subSumA = new int[A.length * (A.length - 1) / 2 + A.length];
        int aSubIdx = 0;
        for (int i = 0; i < aSum.length; i++) {
            for (int j = i; j < aSum.length; j++) {
                //i ~ j까지(i 포함)
                // 1 ~ 2
                //1, 2, 3
                //1, 3, 6
                // 6 - 3 = 3
                // 2 + 3 = 5
                subSumA[aSubIdx] = aSum[j] - aSum[i] + A[i];
                aSubIdx++;
            }
        }

        int[] subSumB = new int[B.length * (B.length - 1) / 2 + B.length];
        int bSubIdx = 0;
        for (int i = 0; i < bSum.length; i++) {
            for (int j = i; j < bSum.length; j++) {
                subSumB[bSubIdx] = bSum[j] - bSum[i] + B[i];
                bSubIdx++;
            }
        }

        //case 구하기(완탐 피하기)
        //1. 정렬
        Arrays.sort(subSumA);
        Arrays.sort(subSumB);

        //2. A 부분 배열 케이스 돌면서 매칭되는 B 부분 배열 합 찾기
        int answer = 0;
        for (int i = 0; i < subSumA.length; i++) {
            int gap = T - subSumA[i];

            //왼쪽 경계선 찾기
            int left = 0;
            int right = subSumB.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                //gap이 크거나 같으면 왼쪽에 정답이 있을것이다.
                if(gap <= subSumB[mid]) {
                    right = mid - 1;
                } else {
                    //gap이 작으면 으론쪽에 정답이 있다.
                    left = mid + 1;
                }
            }
            //계산이 끝난 후 left가 정답이다.
        }
        return answer;
    }

    public static void main(String[] args) {
        int T = 5;
        int[] A = {1, 3, 1, 2};
        int[] B = {1, 3, 2};

        System.out.println(new 두_배열의_합().solve(T, A, B)); // 기대값: 7
    }
}
