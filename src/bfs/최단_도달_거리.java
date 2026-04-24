package bfs;

import java.util.*;

/**
 * 최단_도달_거리 (Breadth First Search: Shortest Reach)
 * <p>
 * 노드 1 ~ n 으로 구성된 무방향 그래프가 주어진다. 모든 간선의 가중치는 6으로 동일하다.
 * 시작 노드 s가 주어졌을 때, s로부터 나머지 모든 노드까지의 최단 거리를 노드 번호 순서대로 반환한다.
 * 시작 노드 자신은 결과에서 제외하며, 도달할 수 없는 노드의 거리는 -1 로 표시한다.
 * <p>
 * 제약조건:
 * - 간선 하나의 가중치 = 6
 * - 결과 배열 길이 = n - 1 (시작 노드 제외)
 * - 도달 불가 노드는 -1
 *
 * @link https://www.hackerrank.com/challenges/bfsshortreach/
 */
public class 최단_도달_거리 {
	public int[] bfs(int n, int m, int[][] edges, int s) {
		// TODO(human): 구현하세요.
		//노드 s로 부터 나머지 모든 노드까지의 최단 거리를 노드 번호 순서대로 반환
		//도달할 수 없으면 -1
		int[] distance = new int[n + 1];
		Arrays.fill(distance, -1);

		//s 노드로 부터 시작해서 연결된 모든 노드 찾기...?
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			int start = edges[i][0];
			int end = edges[i][1];
			graph.get(start).add(end);
			graph.get(end).add(start);
		}

		Queue<Integer> q = new LinkedList<>();
		distance[s] = 0;
		q.offer(s);

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int next : graph.get(cur)) {
				if(distance[next] == -1) {
					distance[next] = distance[cur] + 1;
					q.offer(next);
				}
			}
		}

		int[] result = new int[n - 1];
		int idx = 0;
		for (int i = 1; i <= n; i++) {
			if(i == s) continue;//시작 노드 건너뛰기
			result[idx++] = distance[i] == -1 ? -1 : distance[i] * 6;
		}

		return result;
	}

	public static void main(String[] args) {
		최단_도달_거리 test = new 최단_도달_거리();

		// 예제 1: 4 노드, 2 간선, 시작 노드 1
		int[][] edges1 = {
				{1, 2},
				{1, 3}
		};
		int[] result1 = test.bfs(4, 2, edges1, 1);
		print(result1); // 기대값: 6 6 -1

		// 예제 2: 3 노드, 1 간선, 시작 노드 2
		int[][] edges2 = {
				{2, 3}
		};
		int[] result2 = test.bfs(3, 1, edges2, 2);
		print(result2); // 기대값: -1 6
	}

	private static void print(int[] arr) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			if (i > 0) sb.append(' ');
			sb.append(arr[i]);
		}
		System.out.println(sb);
	}
}
