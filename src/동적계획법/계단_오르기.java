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
    private static int answer = 0;
    public int climbStairs(int n) {
        // TODO(human): 구현하세요.
        //n계의 계단
        //시작점 = 0;
        //1칸
        //2칸
        //1칸
        //2칸
        //1칸
        //2칸
        step(0, n);
        return answer;
    }
    private void step (int start, int end) {
        if(start == end) {
            answer++;
            return;
        }
        step(start + 1, end);
        if(end - start >= 2) step(start + 2, end);
    }

    public static void main(String[] args) {
        계단_오르기 test = new 계단_오르기();

        System.out.println(test.climbStairs(2)); // 기대값: 2
        System.out.println(test.climbStairs(3)); // 기대값: 3
    }
}
