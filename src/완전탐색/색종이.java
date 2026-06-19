package 완전탐색;

import java.util.Arrays;

/**
 * 색종이
 *
 * 100x100 흰색 도화지 위에 10x10 검은색 색종이들을 붙였을 때, 검은 영역의 넓이를 구한다.
 * (겹친 부분은 한 번만 센다)
 *
 * 제약조건:
 * - 색종이 수 ≤ 100
 * - 색종이는 도화지 밖으로 나가지 않는다
 * - 입력 좌표 = (왼쪽 변과의 거리, 아래쪽 변과의 거리)
 *
 * @link https://takjoon.takijk.xyz/problems/16890
 */
public class 색종이 {
    public int solution(int[][] papers) {
        // TODO(human): 구현하세요.
        //색종이 크기가 10
        //왼쪽, 아래
        int[][] position = new int[101][101];
        for (int i = 0; i < papers.length; i++) {
            int left = papers[i][0];
            int bottom = papers[i][1];
            for (int j = left; j < left + 10 ; j++) {
                for (int k = bottom; k < bottom + 10; k++) {
                    position[k][j] = 1;
                }
            }
        }
        int width = 0;
        for (int i = 1; i < position.length; i++) {
            for (int j = 1; j < position.length; j++) {
                if(position[i][j] == 1) {
                    width++;
                }
            }
        }
        return width;
    }

    public static void main(String[] args) {
        색종이 test = new 색종이();
        int[][] papers = {{3, 7}, {15, 7}, {5, 2}};
        System.out.println(test.solution(papers)); // 기대값: 260
    }
}
