package 동적계획법;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42895
 */
public class N으로_표현 {
    public int solution(int N, int number) {
        if (N == number) return 1;

        List<Set<Integer>> dp = new ArrayList<>();

        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        for (int i = 1; i <= 8; i++) {
            //이어 붙인 수
            int concat = 0;
            for (int j = 0; j < i; j++) {
                concat = concat * 10 + N;
            }
            dp.get(i).add(concat);

            //점화식
            for (int j = 1; j < i; j++) {
                for (int a : dp.get(j)) {
                    for (int b : dp.get(i - j)) {
                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(a * b);
                        if (b != 0) dp.get(i).add(a / b);
                    }
                }
            }

            if (dp.get(i).contains(number)) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        int N = 5;
        int number = 12;
        System.out.println(new N으로_표현().solution(N, number));
    }
}
