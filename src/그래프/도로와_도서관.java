package 그래프;

import java.util.*;

/**
 * 도로와_도서관 (Roads and Libraries)
 * <p>
 * n개의 도시에 사는 모든 시민이 도서관을 이용할 수 있도록 만드는 최소 비용을 구한다.
 * 시민은 자기 도시에 도서관이 있거나, 도로를 통해 도서관이 있는 도시까지 갈 수 있어야 한다.
 * 도서관 건설 비용 c_lib, 도로 건설 비용 c_road, 그리고 건설 가능한 도로 목록 cities가 주어진다.
 * <p>
 * 제약조건:
 * - 도로는 두 개의 서로 다른 도시를 연결한다.
 * - 결과는 long 타입으로 반환한다 (도시 수가 많을 경우 int 오버플로 가능).
 *
 * @link https://www.hackerrank.com/challenges/torque-and-development/problem
 */
public class 도로와_도서관 {
	public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
		//2. 아니면 시뮬레이션
		//도시를 연결이 가능한 도로를 모두 건설했을 때도서관을 지을 수 있는 최저 비용은 무엇인가?
		//도로를 하나씩 끊어가며 도서관을 짓는 것과 비교했을 때 최저 비용은 무엇인가?

		//연결된 도시들 확인하기
		//1번 도시랑 연결된 도시들 넣기
		//1번 도시랑 연결된 도시와 연결된 도시들 넣기
		// 그다음 안넣은 도시 넣기
		//도시는 1 부터
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			adj.add(new ArrayList<>());
		}
		for (List<Integer> city : cities) {
			int a = city.get(0);
			int b = city.get(1);
			adj.get(a).add(b);
			adj.get(b).add(a);
		}

		List<List<Integer>> groups = new ArrayList<>();

		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			if (visited[i]) continue;
			List<Integer> currentGroup = new ArrayList<>();
			groups.add(currentGroup);

			q.offer(i);
			visited[i] = true;
			while (!q.isEmpty()) {
				int cur = q.poll();
				currentGroup.add(cur);
				for (int a : adj.get(cur)) {
					if (visited[a]) continue;
					q.offer(a);
					visited[a] = true;
				}
			}
		}

		// TODO(human): 그룹별로 도로 vs 도서관 비용 비교해서 합산
		long total = 0L;
		for(List<Integer> group : groups) {
			long planA = (group.size() - 1) * c_road + c_lib;
			long planB = group.size() * c_lib;
			total += Math.min(planA, planB);

		}
		return total;
	}

	public static void main(String[] args) {
		// 예제 1: n=3, c_lib=2, c_road=1, roads=[[1,2],[3,1],[2,3]] → 기대값: 4
		List<List<Integer>> cities1 = new ArrayList<>();
		cities1.add(Arrays.asList(1, 2));
		cities1.add(Arrays.asList(3, 1));
		cities1.add(Arrays.asList(2, 3));
		System.out.println(roadsAndLibraries(3, 2, 1, cities1)); // 기대값: 4

		// 예제 2: n=6, c_lib=2, c_road=5, roads=[[1,3],[3,4],[2,4],[1,2],[2,3],[5,6]] → 기대값: 12
		List<List<Integer>> cities2 = new ArrayList<>();
		cities2.add(Arrays.asList(1, 3));
		cities2.add(Arrays.asList(3, 4));
		cities2.add(Arrays.asList(2, 4));
		cities2.add(Arrays.asList(1, 2));
		cities2.add(Arrays.asList(2, 3));
		cities2.add(Arrays.asList(5, 6));
		System.out.println(roadsAndLibraries(6, 2, 5, cities2)); // 기대값: 12
	}
}
