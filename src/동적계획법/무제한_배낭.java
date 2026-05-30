package 동적계획법;

import java.util.Arrays;

/**
 * 무제한_배낭 (Unbounded Knapsack)
 *
 * 정수 배열 arr와 목표값 k가 주어질 때, 배열의 원소를 0번 이상 자유롭게
 * 사용하여 k를 초과하지 않으면서 만들 수 있는 최대 합을 구한다.
 *
 * 제약조건:
 * - 각 원소는 횟수 제한 없이 여러 번 사용할 수 있다.
 * - 만들어지는 합은 k를 초과할 수 없다.
 *
 * @link https://www.hackerrank.com/challenges/unbounded-knapsack/problem
 */
public class 무제한_배낭 {
    private int maxCount = 0;
    int[][] dp;
    public int unboundedKnapsack(int k, int[] arr) {
        // TODO(human): 구현하세요.
        maxCount = 0;
        dp = new int[k + 1][arr.length];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        //내가 뭘 해야하지?? 탐색을 하는거잖아?
        //어떤 탐색?? 중복 포함 다른 원소를 사용해서 구할 수 있는 최대값을
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
           int max = getMaxSum(k, arr[i], i, arr);
           answer = Math.max(answer, max);
        }
        return answer;
    }

    public int getMaxSum(int target, int sum, int start, int[] arr) {
        if(sum > target) {
            return sum - arr[start];
        }
        if(target == sum) {
            return sum;
        }
        if(dp[target - sum][start] != -1) {
            return dp[target - sum][start];
        }
        int max = 0;
        for (int i = start; i < arr.length; i++) {
            int maxSum = getMaxSum(target, sum + arr[i], i, arr);
            max = Math.max(max, maxSum);
        }
        dp[target - sum][start] = max;
        return max;
    }

    /**
     * 1차원 bottom-up 버전.
     * dp[i] = 용량 i를 초과하지 않으면서 만들 수 있는 최대 합
     */
    public int unboundedKnapsack1D(int k, int[] arr) {
        int[] dp = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            for (int w : arr) {
                if (w <= i) {
                    // TODO(human): dp[i]를 갱신하는 점화식 한 줄
                    dp[i] = Math.max(dp[i], dp[i - w] + w);
                }
            }
        }
        return dp[k];
    }

    public static void main(String[] args) {
        무제한_배낭 test = new 무제한_배낭();

        System.out.println(test.unboundedKnapsack(12, new int[]{1, 6, 9}));      // 기대값: 12
        System.out.println(test.unboundedKnapsack(9, new int[]{3, 4, 4, 4, 8})); // 기대값: 9

        System.out.println(test.unboundedKnapsack1D(12, new int[]{1, 6, 9}));      // 기대값: 12
        System.out.println(test.unboundedKnapsack1D(9, new int[]{3, 4, 4, 4, 8})); // 기대값: 9
    }
}
