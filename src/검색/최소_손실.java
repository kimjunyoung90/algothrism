package 검색;

import java.util.Arrays;
import java.util.List;

/**
 * 최소_손실
 * <p>
 * 연도별 집값 배열이 주어졌을 때, 어떤 해에 사서 더 나중 해에 손해를 보고 팔 때
 * 발생할 수 있는 최소 손실(loss)을 구하는 문제.
 * (즉, 인덱스 i < j 이면서 price[i] > price[j] 인 쌍 중 price[i] - price[j] 의 최솟값)
 * <p>
 * 제약조건:
 * - 모든 가격은 서로 다르다 (distinct).
 * - 반드시 손실을 보는 경우가 존재함이 보장된다.
 * - 부분 점수 조건: n ≤ 10^5
 * - 가격은 매우 커질 수 있어 long 타입을 사용한다.
 *
 * @link https://www.hackerrank.com/challenges/minimum-loss/problem
 */
public class 최소_손실 {
	public int minimumLoss(List<Long> price) {
		long minLoss = Long.MAX_VALUE;
		int n = price.size();
		long[][] indexed = new long[n][2];
		for (int i = 0; i < n; i++) {
			indexed[i][0] = i;
			indexed[i][1] = price.get(i);
		}
		Arrays.sort(indexed, (a, b) -> Long.compare(b[1], a[1]));

		for (int i = 0; i < n - 1; i++) {
			if (indexed[i][0] < indexed[i + 1][0]) {
				minLoss = Math.min(minLoss, indexed[i][1] - indexed[i + 1][1]);
			}
		}
		return (int) minLoss;
	}

	public static void main(String[] args) {
		최소_손실 test = new 최소_손실();

		int result0 = test.minimumLoss(List.of(5L, 10L, 3L));
		System.out.println(result0); // 기대값: 2

		int result1 = test.minimumLoss(List.of(20L, 7L, 8L, 2L, 5L));
		System.out.println(result1); // 기대값: 2
	}
}
