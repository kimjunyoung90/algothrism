package pratice;

import java.util.*;

public class SortPractice {

	public static void main(String[] args) {
		System.out.println("=== Q1: 기본 배열 정렬 ===");
		q1();

		System.out.println("\n=== Q2: 내림차순 정렬 ===");
		q2();

		System.out.println("\n=== Q3: 2D 배열을 첫 번째 원소 기준으로 정렬 ===");
		q3();

		System.out.println("\n=== Q4: 2D 배열 다중 조건 정렬 ===");
		q4();

		System.out.println("\n=== Q5: Comparator 체이닝 ===");
		q5();

		System.out.println("\n=== Q6: 정렬 기반 스케줄링 (디스크 컨트롤러 핵심) ===");
		q6();
	}

	// Q1: int 배열을 오름차순 정렬하고 출력하세요.
	// 기대 결과: [1, 2, 3, 5, 8]
	static void q1() {
		int[] nums = {5, 3, 8, 1, 2};
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		// TODO: Arrays.sort()를 사용하여 정렬 후 출력하세요.
	}

	// Q2: Integer 배열을 내림차순 정렬하세요.
	// 기대 결과: [8, 5, 3, 2, 1]
	static void q2() {
		Integer[] nums = {5, 3, 8, 1, 2};

		// TODO: Collections.reverseOrder() 또는 (a, b) -> b - a 를 사용하여 내림차순 정렬하세요.
		// 힌트: int[]에는 Comparator를 쓸 수 없고, Integer[]에만 가능합니다.
		Arrays.sort(nums, Collections.reverseOrder());
		System.out.println(Arrays.toString(nums));
	}

	// Q3: 2D 배열을 첫 번째 원소(요청 시각) 기준으로 오름차순 정렬하세요.
	// 기대 결과: [0,3] [1,9] [3,5]
	static void q3() {
		int[][] jobs = {{1, 9}, {0, 3}, {3, 5}};

		// TODO: Arrays.sort()와 Comparator를 사용하여 jobs[i][0] 기준으로 정렬하세요.
		// 힌트: (a, b) -> a[0] - b[0] 또는 Comparator.comparingInt(a -> a[0])
		Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
		for (int[] job : jobs) {
			System.out.print(Arrays.toString(job) + " ");
		}
		System.out.println();
	}

	// Q4: 2D 배열을 첫 번째 원소로 정렬하되, 같으면 두 번째 원소로 정렬하세요.
	// 기대 결과: [0,3] [0,5] [1,2] [1,9] [3,5]
	static void q4() {
		int[][] jobs = {{1, 9}, {0, 5}, {3, 5}, {0, 3}, {1, 2}};

		// TODO: 다중 조건 정렬을 구현하세요.
		// 힌트: a[0] == b[0]이면 a[1] - b[1], 아니면 a[0] - b[0]
		Arrays.sort(jobs, Comparator.comparingInt((int[] a) -> a[0])
				.thenComparing(a -> a[1]));

		for (int[] job : jobs) {
			System.out.print(Arrays.toString(job) + " ");
		}
		System.out.println();
	}

	// Q5: 문자열 리스트를 (1) 길이 오름차순 → (2) 같은 길이면 사전순으로 정렬하세요.
	// 기대 결과: [go, hi, cat, dog, code, java, hello, world]
	static void q5() {
		List<String> words = Arrays.asList("hello", "hi", "world", "java", "go", "cat", "dog", "code");

		// TODO: Comparator.comparingInt(String::length).thenComparing(...)을 사용하세요.
		// thenComparing()은 첫 번째 비교가 동일할 때 두 번째 기준을 적용합니다.
		words.sort(Comparator.comparingInt(String::length)
				.thenComparing(Comparator.naturalOrder()));
		System.out.println(words);
	}

	// Q6: 디스크 컨트롤러 핵심 - 도착한 작업 중 소요시간이 가장 짧은 것을 고르기
	// 현재 시각 currentTime = 3일 때, 도착한 작업(요청시각 <= 3) 중 소요시간이 짧은 순으로 출력하세요.
	// jobs는 이미 요청시각 기준 정렬되어 있다고 가정합니다.
	// 기대 결과: [0,3] → [3,5] (요청시각 <= 3인 작업만, 소요시간 순)
	// [1,9]는 도착했지만 소요시간이 길어서 마지막
	static void q6() {
		int[][] jobs = {{0, 3}, {1, 9}, {3, 5}};  // 이미 요청시각 기준 정렬됨
		int currentTime = 3;

		// TODO(human): PriorityQueue를 소요시간(job[1]) 기준 Min-Heap으로 만들고,
		// 요청시각이 currentTime 이하인 작업들만 넣은 뒤, 하나씩 꺼내며 출력하세요.
		// 이 패턴이 디스크 컨트롤러 풀이의 핵심입니다!
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
		for (int[] job : jobs) {
			if(job[0] <= currentTime) pq.add(job);
		}
		while (!pq.isEmpty()) {
			System.out.println(Arrays.toString(pq.poll()));
		}
	}
}
