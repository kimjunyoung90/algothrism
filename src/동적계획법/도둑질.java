package 동적계획법;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 도둑질
 * <p>
 * 원형으로 배치된 집들에서 인접한 두 집을 동시에 털 수 없을 때,
 * 도둑이 훔칠 수 있는 돈의 최댓값을 구한다.
 * <p>
 * 제약조건:
 * - 집의 개수: 3 이상 1,000,000 이하
 * - 각 집에 있는 돈: 0 이상 1,000 이하 정수
 *
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42897
 */
public class 도둑질 {
    public int solution(int[] money) {
        // TODO(human): 구현하세요.
        //1, 2, 3, 1
        int[] dp = new int[money.length];
        dp[0] = money[0];
        dp[1] = Math.max(money[0], money[1]);

        for (int i = 2; i < money.length; i++) {
            dp[i] = Math.max(money[i] + dp[i - 2], dp[i - 1]);
        }

        //마지막 값과 첫번째 값은??
        return 0;
    }

    public static void main(String[] args) {
        도둑질 test = new 도둑질();
        int[] money = {1, 2, 3, 1};
        System.out.println(test.solution(money)); // 기대값: 4
    }
}
