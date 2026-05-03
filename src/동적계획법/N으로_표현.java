package 동적계획법;

import java.util.*;

/**
 * N으로 표현
 *
 * 숫자 N과 사칙연산만으로 number를 표현할 때, N을 사용하는 최소 횟수를 구한다.
 *
 * 제약조건:
 * - N: 1 이상 9 이하
 * - number: 1 이상 32,000 이하
 * - 나눗셈은 몫만 취한다
 * - 최솟값이 8을 초과하면 -1을 반환
 *
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42895
 */
public class N으로_표현 {
    public int solution(int N, int number) {
        List<Set<Integer>> dp = new ArrayList<>();

        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        for (int i = 1; i <= 8; i++) {
            int concat = 0;
            for (int j = 0; j < i; j++) {
                concat = concat * 10 + N;
            }
            dp.get(i).add(concat);

            for (int j = 1; j < i; j++) {
                Set<Integer> l = dp.get(j);
                Set<Integer> r = dp.get(i - j);
                for (int l1 : l) {
                    for (int r1 : r) {
                        dp.get(i).add(l1 + r1);
                        dp.get(i).add(l1 - r1);
                        dp.get(i).add(l1 * r1);
                        if(r1 != 0) dp.get(i).add(l1 / r1);
                    }
                }
            }
            if(dp.get(i).contains(number)) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        N으로_표현 test = new N으로_표현();
        System.out.println(test.solution(5, 12)); // 기대값: 4
        System.out.println(test.solution(2, 11)); // 기대값: 3
    }
}
