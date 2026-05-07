package 동적계획법;

/**
 * 계단_오르기 (Climbing Stairs)
 *
 * n개의 계단을 오르려고 한다. 한 번에 1칸 또는 2칸을 오를 수 있을 때,
 * 정상에 도달하는 서로 다른 방법의 수를 구하는 문제.
 *
 * 제약조건:
 * - 1 <= n <= 45
 *
 * @link https://leetcode.com/problems/climbing-stairs/
 */
public class 계단_오르기 {
    private int[] memo;
    public int climbStairs(int n) {
        memo = new int[n + 1];
        return step(0, n);
    }
    private int step (int start, int end) {
        if(memo[start] != 0) return memo[start];
        if(start == end) return 1;

        int oneStep = step(start + 1, end);
        int twoStep = end - start >= 2 ?  step(start + 2, end) : 0;

        memo[start] = oneStep + twoStep;

        return memo[start];
    }

    public static void main(String[] args) {
        계단_오르기 test = new 계단_오르기();

        System.out.println(test.climbStairs(2)); // 기대값: 2
        System.out.println(test.climbStairs(3)); // 기대값: 3
    }
}
