package dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 그래프_복제 (Clone Graph)
 * <p>
 * 연결된 무방향 그래프에서 주어진 노드의 참조가 주어졌을 때,
 * 그래프의 깊은 복사(deep copy)를 반환한다.
 * <p>
 * 각 노드는 값(int)과 이웃 노드 리스트(List<Node>)를 가진다.
 * <p>
 * 제약조건:
 * - 노드 수 n: 0 <= n <= 100
 * - 1 <= Node.val <= 100
 * - Node.val 은 각 노드마다 유일하다.
 * - 중복된 간선과 자기 자신을 가리키는 간선은 없다.
 * - 그래프는 연결되어 있으며, 주어진 노드로부터 모든 노드에 도달할 수 있다.
 *
 * @link https://leetcode.com/problems/clone-graph/
 */
public class 그래프_복제 {

	static class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
			val = 0;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}

	public Node cloneGraph(Node node) {
		// TODO(human): 구현하세요.
		// 그래프의 아무 노드가 주어졌을 때 그래프를 복사하는 문제
		// Node는 val 과 neighbors로 구현되어 있음
		// 한 타겟 지정 시 해당 타겟과 연결된 노드들을 끝까지 탐색해서 복사
		Map<Node, Node> visited = new HashMap<>();
		return dfs(node, visited);
	}

	private Node dfs(Node node, Map<Node, Node> visited) {
		if(node == null) return null;

		// 새로운 노드 확인
		if(visited.containsKey(node)) return visited.get(node);

		// 복제본 생성
		Node newNode = new Node(node.val);

		// 새로운 노드 등록
		visited.put(node, newNode);

		// 이웃 노드 치환
		newNode.neighbors = node.neighbors.stream()
				.map(neighbor -> dfs(neighbor, visited))
				.toList();

		return newNode;
	}

	public static void main(String[] args) {
		그래프_복제 test = new 그래프_복제();

		// 예제 1: adjList = [[2,4],[1,3],[2,4],[1,3]]
		// 기대 출력: [[2,4],[1,3],[2,4],[1,3]]
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		n1.neighbors = new ArrayList<>(List.of(n2, n4));
		n2.neighbors = new ArrayList<>(List.of(n1, n3));
		n3.neighbors = new ArrayList<>(List.of(n2, n4));
		n4.neighbors = new ArrayList<>(List.of(n1, n3));
		Node cloned1 = test.cloneGraph(n1);
		System.out.println("예제1 복제 루트 val: " + (cloned1 == null ? "null" : cloned1.val));
		System.out.println("원본과 다른 인스턴스인가? " + (cloned1 != n1));

		// 예제 2: adjList = [[]]  (노드 1개, 이웃 없음)
		// 기대 출력: [[]]
		Node single = new Node(1);
		Node cloned2 = test.cloneGraph(single);
		System.out.println("예제2 복제 루트 val: " + (cloned2 == null ? "null" : cloned2.val));

		// 예제 3: adjList = []  (빈 그래프)
		// 기대 출력: []
		Node cloned3 = test.cloneGraph(null);
		System.out.println("예제3 복제 루트: " + (cloned3 == null ? "null" : String.valueOf(cloned3.val)));
	}
}
