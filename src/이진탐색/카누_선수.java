package 이진탐색;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 카누_선수
 * <p>
 * 같은 인원의 4개 반에서 각각 1명씩 뽑아 4명의 몸무게 합이
 * 특정 값 k에 가장 근사하도록 한다. 근사값이 두 개(k보다 작은 쪽/큰 쪽)면
 * 더 작은 합을 택한다. 선택된 4명의 몸무게 총합을 구한다.
 * <p>
 * 제약조건:
 * - 특정 값 k: 1 ≤ k ≤ 40,000,000
 * - 각 반 학생 수 n: 1 ≤ n ≤ 1,000
 * - 각 몸무게: 1 ≤ w ≤ 10,000,000
 *
 * @link https://takjoon.takijk.xyz/problems/32833
 */
public class 카누_선수 {
	public int solution(int k, int[][] classes) {

		//왼쪽 반 합을 구하고 = O(n^2) = 1000000
		int[] leftSum = new int[1000000];
		int leftSumIdx = 0;
		for (int i = 0; i < classes[0].length; i++) {
			for (int j = 0; j < classes[1].length; j++) {
				leftSum[leftSumIdx] = classes[0][i] + classes[1][j];
				leftSumIdx++;
			}
		}

		//오른쪽 반 합을 구한다.
		int[] rightSum = new int[1000000];
		int rightSumIdx = 0;
		for (int i = 0; i < classes[2].length; i++) {
			for (int j = 0; j < classes[3].length; j++) {
				rightSum[rightSumIdx] = classes[2][i] + classes[3][j];
				rightSumIdx++;
			}
		}

		//정렬
		Arrays.sort(leftSum);
		Arrays.sort(rightSum);

		//근사치 구하기
		int leftPointer = 0;
		int rightPointer = rightSum.length - 1;
		int minGap = Integer.MAX_VALUE;
		int answer = 0;
		while (leftPointer < leftSum.length && rightPointer >= 0) {
			int candidate = leftSum[leftPointer] + rightSum[rightPointer];
			int gap = Math.abs(k - candidate);

			//1. gap 갱신
			if (gap < minGap) {
				minGap = gap;
				answer = candidate;
			} else if (gap == minGap) {
				answer = Math.min(candidate, answer);
			}

			//2. pointer 이동
			if (candidate < k) {
				leftPointer++;
			} else if (k < candidate) {
				rightPointer--;
			} else {
				break;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		카누_선수 test = new 카누_선수();
		System.out.println(test.solution(300, new int[][]{
				{60, 52, 80, 40},
				{75, 68, 88, 63},
				{48, 93, 48, 54},
				{56, 73, 49, 75}})); // 기대값: 301
		System.out.println(test.solution(8, new int[][]{
				{1, 2, 3},
				{1, 2, 3},
				{1, 2, 3},
				{1, 2, 3}})); // 기대값: 8
		System.out.println(test.solution(32, new int[][]{
				{2, 5},
				{9, 4},
				{10, 20},
				{4, 2}})); // 기대값: 31
	}
}
