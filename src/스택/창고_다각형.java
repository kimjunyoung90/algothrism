package 스택;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 창고_다각형
 *
 * 폭 1m, 높이가 다른 N개의 기둥이 일렬로 서 있다.
 * 오목한 부분 없이 모든 기둥을 덮는 지붕(수평·수직)을 씌울 때,
 * 지붕과 땅으로 둘러싸인 창고 다각형의 최소 면적을 구한다.
 *
 * 제약조건:
 * - 기둥 수 N: 1 ≤ N ≤ 1,000
 * - 각 기둥의 왼쪽 면 위치 L, 높이 H: 1 ≤ L, H ≤ 1,000
 *
 * @link https://takjoon.takijk.xyz/problems/14123
 */
public class 창고_다각형 {
    public int solution(int[][] columns) {
        // 창고를 옆에서 봤을 때 생기는 최소 단면 도형을 구하라
        // 지붕 높이는 내림차순
        Arrays.sort(columns, (a, b) -> a[0] - b[0]);
        //가장 높은 기둥의 위치 찾기
        int maxHeightIdx = 0;
        int maxHeight = 0;
        for (int i = 0; i < columns.length; i++) {
            int height = columns[i][1];
            if(maxHeight < height) maxHeightIdx = i;
            maxHeight = Math.max(height, maxHeight);
        }

        //maxHeightIdx 기준으로 왼쪽 구간 더하기
        int leftSum = 0;
        int leftMax = columns[0][1];
        for (int i = 0; i < maxHeightIdx; i++) {
            int height = columns[i][1];
            leftMax = Math.min(height, leftMax);
            int width = columns[i + 1][0] - columns[i][0];
            leftSum += leftMax * width;
        }

        //maxHeightIdx 기준으로 오른쪽 구간 더하기
        int rightSum = 0;
        int rightMax = columns[columns.length - 1][1];
        for (int i = columns.length - 1; i > maxHeightIdx; i--) {
            int height = columns[i][1];
            rightMax = Math.max(height, rightMax);
            int width = columns[i][0] - columns[i - 1][0];
            rightSum += rightMax * width;
        }

        return leftSum + rightSum + columns[maxHeightIdx][1];
    }

    public static void main(String[] args) {
        창고_다각형 test = new 창고_다각형();
        int[][] columns = {
                {2, 4},
                {11, 4},
                {15, 8},
                {4, 6},
                {5, 3},
                {8, 10},
                {13, 6}
        };
        System.out.println(test.solution(columns)); // 기대값: 98
    }
}
