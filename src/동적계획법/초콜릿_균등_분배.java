package 동적계획법;

import java.util.List;

/**
 * 초콜릿_균등_분배 (Equal)
 *
 * Christy가 동료들에게 초콜릿을 균등하게 나눠주려고 한다.
 * 한 번의 연산에서 한 명을 제외한 모든 동료에게 같은 개수의 초콜릿을 추가로 줄 수 있다.
 * 모든 동료가 같은 개수의 초콜릿을 갖도록 만드는 최소 연산 횟수를 구하라.
 *
 * 제약조건:
 * - 테스트 케이스 수: t
 * - 배열 크기: n
 * - 각 원소 값: < 10^9
 *
 * @link https://www.hackerrank.com/challenges/equal/problem
 */
public class 초콜릿_균등_분배 {
    public int equal(List<Integer> arr) {
        // TODO(human): 구현하세요.
        return 0;
    }

    public static void main(String[] args) {
        초콜릿_균등_분배 test = new 초콜릿_균등_분배();

        int result1 = test.equal(List.of(2, 2, 3, 7));
        System.out.println(result1); // 기대값: 2

        int result2 = test.equal(List.of(10, 7, 12));
        System.out.println(result2); // 기대값: 3
    }
}
