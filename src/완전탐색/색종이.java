package 완전탐색;

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
        boolean[][] board = new boolean[100][100];
        for (int[] paper : papers) {
            int left = paper[0];
            int bottom = paper[1];
            for (int y = bottom; y < bottom + 10; y++) {
                for (int x = left; x < left + 10; x++) {
                    board[y][x] = true;
                }
            }
        }

        int area = 0;
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board.length; x++) {
                if(board[y][x]) {
                    area++;
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        색종이 test = new 색종이();
        int[][] papers = {{3, 7}, {15, 7}, {5, 2}};
        System.out.println(test.solution(papers)); // 기대값: 260
    }
}
