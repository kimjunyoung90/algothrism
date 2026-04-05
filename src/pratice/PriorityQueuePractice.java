package pratice;

import java.util.*;

public class PriorityQueuePractice {

	public static void main(String[] args) {
		System.out.println("=== Q1: 기본 Min-Heap 사용 ===");
		q1();

		System.out.println("\n=== Q2: Max-Heap 만들기 ===");
		q2();

		System.out.println("\n=== Q3: peek과 poll 차이 ===");
		q3();

		System.out.println("\n=== Q4: 배열을 힙으로 변환 ===");
		q4();

		System.out.println("\n=== Q5: 커스텀 정렬 기준 ===");
		q5();

		System.out.println("\n=== Q6: K번째로 큰 수 찾기 ===");
		q6();

		System.out.println("\n=== Q7: 두 값 합치기 패턴 (더_맵게 핵심) ===");
		q7();
	}

	// Q1: 숫자 배열을 PriorityQueue에 넣고, 작은 순서대로 꺼내보세요.
	// 기대 결과: 1 3 5 7 9
	static void q1() {
		int[] nums = {5, 3, 7, 1, 9};

		// TODO: PriorityQueue를 생성하고 nums를 넣은 뒤, 하나씩 poll()하여 출력하세요.
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (Integer num : nums) {
			pq.add(num);
		}
		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}

	// Q2: 큰 수부터 꺼내는 Max-Heap을 만들어보세요.
	// 기대 결과: 9 7 5 3 1
	static void q2() {
		int[] nums = {5, 3, 7, 1, 9};

		// TODO: Max-Heap PriorityQueue를 생성하고 nums를 넣은 뒤, 큰 순서대로 출력하세요.
		// 힌트: Collections.reverseOrder() 또는 (a, b) -> b - a
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (Integer num : nums) {
			pq.add(num);
		}
		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}

	// Q3: peek()과 poll()의 차이를 확인해보세요.
	// 기대 결과:
	//   peek: 10 (큐 크기: 3)
	//   poll: 10 (큐 크기: 2)
	//   peek: 20 (큐 크기: 2)
	static void q3() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(30);
		pq.offer(10);
		pq.offer(20);

		// TODO: peek()으로 확인 후 크기 출력, poll()로 꺼낸 후 크기 출력, 다시 peek() 출력
		System.out.println(pq.peek());
		System.out.println(pq.size());

		System.out.println(pq.poll());
		System.out.println(pq.size());

		System.out.println(pq.peek());
		System.out.println(pq.size());
	}

	// Q4: 배열의 모든 원소를 한번에 PriorityQueue로 만들어보세요.
	// 기대 결과: [1, 2, 3, 4, 5]
	static void q4() {
		List<Integer> nums = List.of(4, 2, 5, 1, 3);

		// TODO: List를 PriorityQueue 생성자에 넘겨서 한 번에 힙을 만들고, 순서대로 꺼내 List로 수집하세요.
		PriorityQueue<Integer> pq = new PriorityQueue<>(nums);
		List<Integer> newNums = new ArrayList<>();
		while (!pq.isEmpty()) {
			newNums.add(pq.poll());
		}
		System.out.println(newNums);
	}

	// Q5: 문자열을 길이가 짧은 순서로 꺼내는 PriorityQueue를 만들어보세요.
	// 기대 결과: hi -> cat -> hello -> banana
	static void q5() {
		String[] words = {"banana", "hi", "cat", "hello"};

		// TODO: Comparator.comparingInt(String::length)를 사용하여 PriorityQueue를 만들고 출력하세요.
		PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(String::length));
		pq.addAll(Arrays.asList(words));
		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}

	// Q6: 배열에서 3번째로 큰 수를 Min-Heap을 활용해 찾아보세요.
	// 기대 결과: 7
	static void q6() {
		int[] nums = {3, 1, 5, 9, 7, 2, 8};
		int k = 3;

		// TODO: 크기 k짜리 Min-Heap을 유지하면서 배열을 순회하세요.
		// 힌트: 힙 크기가 k를 초과하면 poll()하면, 최종적으로 peek()이 k번째로 큰 수입니다.
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int num : nums) {
			if (pq.size() >= 3) pq.poll();
			pq.add(num);
		}
		System.out.println(pq.peek());
	}

	// Q7: 더_맵게 문제의 핵심 패턴 - 가장 작은 두 값을 꺼내 합친 결과를 다시 넣기
	// 음식 스코빌 지수: [1, 2, 3, 9, 10, 12], 목표 K=7
	// 섞기 공식: 가장 안 매운 것 + (두 번째로 안 매운 것 * 2)
	// 기대 결과: 모든 값이 7 이상이 될 때까지 섞은 횟수 = 2
	static void q7() {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;

		// TODO: PriorityQueue를 사용하여 섞은 횟수를 구하세요.
		// 1) 모든 값을 힙에 넣기
		// 2) peek() < K 이고 size() > 1인 동안 반복:
		//    - poll() 두 번으로 가장 작은 두 값 꺼내기
		//    - 새 값 = first + (second * 2)
		//    - offer()로 새 값 넣기
		// 3) peek() >= K면 횟수 출력, 아니면 -1 출력
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int sc : scoville) {
			pq.add(sc);
		}
		int suffle = 0;
		while (!pq.isEmpty()) {
			int sc = pq.peek();

			if(sc > K) break;
			if(pq.size() == 1) {
				suffle = -1;
				break;
			}

			int newSc = pq.poll() + pq.poll() * 2;
			suffle++;
			pq.offer(newSc);
		}
		System.out.println(suffle);
	}
}
