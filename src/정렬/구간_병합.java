package 정렬;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 구간_병합 (Merge Intervals)
 * <p>
 * 겹치는 구간들을 모두 병합하여, 입력의 모든 구간을 덮는 서로 겹치지 않는 구간 배열을 반환한다.
 * <p>
 * 제약조건:
 * - 1 <= intervals.length <= 10^4
 * - intervals[i].length == 2
 * - 0 <= start_i <= end_i <= 10^4
 *
 * @link https://leetcode.com/problems/merge-intervals/description/
 */
public class 구간_병합 {
	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		List<int[]> result = new ArrayList<>();
		//1번째 값
		result.add(intervals[0]);
		int idx = 0;
		for (int[] interval : intervals) {
			int start = interval[0];
			int end = interval[1];

			int lastEnd = result.get(idx)[1];

			if (start > lastEnd) {
				//새로운 interval 시작
				result.add(new int[]{start, end});
				idx++;
			} else if (start < lastEnd) {
				//end 가 기존 종료보다 클 수 있음
				if (end > lastEnd) {
					result.get(idx)[1] = end;
				}
			} else {
				result.get(idx)[1] = end;
			}
		}
		return result.toArray(new int[0][]);
	}

	public static void main(String[] args) {
		구간_병합 test = new 구간_병합();

		int[][] result1 = test.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
		System.out.println(java.util.Arrays.deepToString(result1)); // 기대값: [[1, 6], [8, 10], [15, 18]]

		int[][] result2 = test.merge(new int[][]{{1, 4}, {4, 5}});
		System.out.println(java.util.Arrays.deepToString(result2)); // 기대값: [[1, 5]]
	}
}
