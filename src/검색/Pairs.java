package 검색;

import java.util.*;

/**
 * 정수 배열이 주어질 때, 두 수의 차이가 정확히 k인 쌍의 개수를 구하는 문제.
 * 배열의 모든 원소는 고유(unique)하다.
 *
 * @link https://www.hackerrank.com/challenges/pairs/problem
 */
public class Pairs {
    public int pairs(int k, int[] arr) {
        // TODO(human): 구현하세요.
        //1. 배열에서 기준 요소를 정한다.
        //2. 기준 요소와 기준 요소가 아닌 것들을 비교한다.
        //3. 차이를 k와 비교한다.
        //4. k이면 count++;
        //2번 단계에서 기준 요소 전에 있는 요소들은 이미 비교되었기 때문에 다시 비교하지 않는다.
        Set<Integer> set = new HashSet<>();
        int result = 0;
		for (int value : arr) {
            set.add(value - k);
		}
		for (int j : arr) {
			if (set.contains(j)) result++;
		}
        return result;
    }

    public static void main(String[] args) {
        Pairs test = new Pairs();
        int result = test.pairs(2, new int[]{1, 5, 3, 4, 2});
        System.out.println(result); // 기대값: 3
    }
}
