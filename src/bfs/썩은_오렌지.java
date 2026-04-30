package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 썩은_오렌지 (Rotting Oranges)
 * <p>
 * m x n 그리드의 각 셀은 다음 세 값 중 하나이다:
 * - 0: 빈 칸
 * - 1: 신선한 오렌지
 * - 2: 썩은 오렌지
 * 매 분마다 썩은 오렌지에 4방향(상하좌우)으로 인접한 신선한 오렌지가 썩는다.
 * 모든 신선한 오렌지가 썩는 데 걸리는 최소 시간을 반환한다.
 * 불가능하면 -1을 반환한다.
 * <p>
 * 제약조건:
 * - m == grid.length
 * - n == grid[i].length
 * - 1 <= m, n <= 10
 * - grid[i][j]는 0, 1, 2 중 하나이다.
 *
 * @link https://leetcode.com/problems/rotting-oranges/
 */
public class 썩은_오렌지 {
	public int orangesRotting(int[][] grid) {
		// TODO(human): 구현하세요.
		//빈칸 0
		//신선한 오렌지 1
		//썩은 오렌지 2
		//매 분마다 썩은 오렌지 주변의 신선한 오렌지가 썩음
		//모든 오렌지가 썩기 위해 몇분 걸리는지 확인

		//1. 썩은 오렌지 위치 확인
		//썩은 오렌지 주변은 동시 다발적으로 썩기 때문에 썩은 오렌지 위치를 확인해서 주변에 신선한 오렌지가 있는지 확인하는게 올바른 방법인 것 같음
		//2. 주변에 신선한 오렌지 확인
		//3. 신선한 오렌지 썩게 변경 + 시간 추가
		// 1 - 2 - 3 반복
		//4. 모든 오렌지 썩으면 종료(불가능하면 -1)



		//주변 단계를 하나씩 넓혀가며 탐색??
		//썩은 오렌지는 탐색 대상
		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				int cur = grid[i][j];
				//동시 다발성을 표현하나?
				//동시 다발적인 것을 표현하기 위해서 처음에 모든 썩은 오렌지를 Q에 넣어야 하지 않나?
				if(cur == 2) {
					q.offer(new int[]{i, j});
				}
			}
		}

		//썩은 오렌지의 주변 탐색
		int[] dx = {0, 0, -1, 1};
		int[] dy = {1, -1, 0, 0};

		//처음 들어온 썩은 오렌지의 주변 탐색이 끝났는지 어떻게 판단하나?
		//그건 큐에 들어온 오렌지 중 신선한 오렌지가 나타나는 순간 썩은 오렌지로부터 파생 탐색된 오렌지다.
		//count 수를 증가시키기 위해 주변의 신선한 오렌지를 한 번만 탐색하는 방법은??
		//모든 오렌지가 썩었는지는 어떻게 알 수 있나? = 채신선한 오렌지 개수와 썩게 만든 오렌지 개수를 비교하면 된다.
		while (!q.isEmpty()) {
			int[] center = q.poll();
			//썩게 변경
			grid[center[0]][center[1]] = 2;

			//주변 오렌지 탐색
			for (int i = 0; i < 4; i++) {
				int nextx = center[1] + dx[i];
				int nexty = center[0] + dy[i];
				//경계값
				if(nextx < 0 || nexty < 0 || nextx >= grid[0].length || nexty >= grid.length) continue;
				//주변의 신선한 오렌지인지 확인
				if(grid[nexty][nextx] == 1) {
					q.offer(new int[]{nexty, nexty});
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		썩은_오렌지 test = new 썩은_오렌지();

		int[][] grid1 = {
				{2, 1, 1},
				{1, 1, 0},
				{0, 1, 1}
		};
		System.out.println(test.orangesRotting(grid1)); // 기대값: 4

		int[][] grid2 = {
				{2, 1, 1},
				{0, 1, 1},
				{1, 0, 1}
		};
		System.out.println(test.orangesRotting(grid2)); // 기대값: -1

		int[][] grid3 = {
				{0, 2}
		};
		System.out.println(test.orangesRotting(grid3)); // 기대값: 0
	}
}
