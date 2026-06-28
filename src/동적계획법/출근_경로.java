package 동적계획법;

/**
 * 출근_경로 (백준 5569)
 * <p>
 * (1,1)에서 (w,h)까지 동쪽 또는 북쪽으로만 이동하는 경로의 수를 구한다.
 * 단, 교차로에서 방향을 바꾼 직후 1블록만 이동한 뒤 다시 방향을 바꿀 수 없다.
 * 경로의 개수를 100000으로 나눈 나머지를 출력한다.
 * <p>
 * 제약조건:
 * - 2 ≤ w, h ≤ 100
 *
 * @link https://takjoon.takijk.xyz/problems/29528
 */
public class 출근_경로 {
	public int solve(int w, int h) {

		// 남북 방향 도로 w
		// 동서 방향 도로 h
		// w-h 가 만나는 지점이 교차로
		// 상근이는 교차로 (1, 1)에 살고 있고 교차로 (w, h)에 있는 회사에 다님.
		// w, h가 목적지구나.

		// TODO : 상근이가 회사에 출근할 수 있는 경로의 수
		// 1. 상근이는 동쪽 또는 북쪽으로만 이동할 수 있다.
		// 2. 교차로를 돈 차량은 그 다음 교차로에서 다시 방향을 바꿀 수 없다.
		// i, j 에 있을 때 w, h 로 가는 경우의 수
		// i, j 에 있을 때 직전에 교차로를 돌은건지 아닌지

		// wᵢ, hᵢ 에서
		return move(1, 1, 1, 1, 1, 1, h, w);
	}

	private int move(int prevPrevX, int prevPrevY, int prevX, int prevY, int xPosition, int yPosition, int destX, int destY) {

		if(xPosition > destX) return 0;
		if(yPosition > destY) return 0;

		if(xPosition == destX && yPosition == destY) {
			return 1;
		}

		//1. 동쪽으로 이동(x에서 y로 방향 전환했으면 이동 불가)
		boolean intersection = xPosition - prevPrevX == 1 && yPosition - prevPrevY == 1;
		boolean prevXMoved = yPosition == prevY;
		boolean prevYMoved = xPosition == prevX;

		int aCase = intersection && prevYMoved ? 0 : move(prevX, prevY, xPosition, yPosition, xPosition + 1, yPosition, destX, destY);

		//2. 북쪽으로 이동(y에서 x로 변향전환 했으면 이동 불가)
		int bCase = intersection && prevXMoved ? 0 : move(prevX, prevY, xPosition, yPosition, xPosition, yPosition + 1, destX, destY);
		return aCase + bCase;
	}

	public static void main(String[] args) {
		출근_경로 test = new 출근_경로();
		System.out.println(test.solve(3, 4));   // 기대값: 5
		System.out.println(test.solve(15, 15)); // 기대값: 43688
	}
}
