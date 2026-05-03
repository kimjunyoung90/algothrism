package 그래프;

import java.util.*;

/**
 * 달로_가는_여행 (Journey to the Moon)
 * <p>
 * n명의 우주비행사 중 두 명을 골라 달 탐사 팀을 만들 때, 두 명이 서로 다른 나라 출신이 되도록 고르는 경우의 수를 구한다.
 * 같은 나라 출신이라고 알려진 우주비행사 쌍 목록 astronaut이 주어진다.
 * 직접 또는 간접적으로 같은 그룹에 속한 우주비행사들은 같은 나라 출신이다.
 * <p>
 * 제약조건:
 * - 결과는 long 타입으로 반환한다 (n이 클 경우 n*(n-1)/2가 int 범위를 넘을 수 있다).
 *
 * @link https://www.hackerrank.com/challenges/journey-to-the-moon/
 */
public class 달로_가는_여행 {
	private static int[][] group;

	public long journeyToMoon(int n, List<List<Integer>> astronaut) {
		//1. 같은 그룹으로 묶기
		//0 = root 번호, 1 = size;
		group = new int[n][2];
		Arrays.setAll(group, i -> new int[]{i, 1});

		for (List<Integer> as : astronaut) {
			union(as.get(0), as.get(1));
		}

		long answer = 0L;
		long sumSoFar = 0L;
		for (int i = 0; i < group.length; i++) {
			if(find(i) == i) {
				answer += sumSoFar * group[i][1];
				sumSoFar += group[i][1];
			}
		}

		return answer;
	}

	private void union(int a, int b) {
		int ra = find(a);
		int rb = find(b);
		if (ra == rb) return;
		group[rb][0] = ra;
		group[ra][1] += group[rb][1];
	}

	private int find(int x) {
		if (group[x][0] == x) return x;
		// TODO(human): 경로 압축 적용
		// 재귀로 루트를 찾는데, 매번 탐색할 때 마다 동일한 경로를 또 탐색
		// 바로 상위에 누가 있는지 궁금한게 아니기 때문에 항상 최상위 루트로 값을 갱신해둠
		return group[x][0] = find(group[x][0]);
	}

	public static void main(String[] args) {
		달로_가는_여행 test = new 달로_가는_여행();

		// 예제 0: n=5, pairs=[[0,1],[2,3],[0,4]] → 기대값: 6
		List<List<Integer>> astronaut1 = new ArrayList<>();
		astronaut1.add(Arrays.asList(0, 1));
		astronaut1.add(Arrays.asList(2, 3));
		astronaut1.add(Arrays.asList(0, 4));
		System.out.println(test.journeyToMoon(5, astronaut1)); // 기대값: 6

		// 예제 1: n=4, pairs=[[0,2]] → 기대값: 5
		List<List<Integer>> astronaut2 = new ArrayList<>();
		astronaut2.add(Arrays.asList(0, 2));
		System.out.println(test.journeyToMoon(4, astronaut2)); // 기대값: 5
	}
}