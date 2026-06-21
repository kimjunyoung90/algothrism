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
        int[] subSumsA = subArraySum(A);
        int[] subSumsB = subArraySum(B);

        //정렬
        Arrays.sort(subSumsB);

        int answer = 0;
		for (int j : subSumsA) {
			int gap = T - j;
			answer += countEquals(gap, subSumsB);
		}

        return answer;
    }

    private int countEquals(int gap, int[] subSumsB) {
        return upperBound(subSumsB, gap) - lowerBound(subSumsB, gap);
    }

    private int lowerBound(int[] sorted, int target) {
        int left = 0;
        int right = sorted.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if(sorted[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private int upperBound(int[] sorted, int target) {
        int left = 0;
        int right = sorted.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            //동등 연산이 필요한 이유는 같아도 우측에 같은 값이 더 있을 수 있음
            if(sorted[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private static int[] subArraySum(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        int[] subSum = new int[n * (n - 1) / 2 + n];
        int subSumIdx = 0;
        for (int from = 0; from < n; from++) {
            for (int to = from + 1; to <= n; to++) {
                subSum[subSumIdx++] = prefix[to] - prefix[from];
            }
        }
        return subSum;
    }

    public static void main(String[] args) {
        int T = 5;
        int[] A = {1, 3, 1, 2};
        int[] B = {1, 3, 2};

        System.out.println(new 두_배열의_합().solve(T, A, B)); // 기대값: 7
    }
}
