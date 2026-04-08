package 힙;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @link https://www.hackerrank.com/challenges/qheap1/problem
 *
 * 3가지 쿼리를 처리하는 힙:
 * - "1 v": 힙에 원소 v 추가
 * - "2 v": 힙에서 원소 v 삭제
 * - "3": 힙의 최솟값 출력
 */
public class QHEAP1 {

    public void solve(Scanner sc) {
        int q = sc.nextInt();
        // TODO(human): 구현하세요.
        // 힌트: PriorityQueue는 기본적으로 remove(Object)를 지원하지만,
        // 그 외에 TreeMap 등 다른 자료구조도 고려해보세요.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < q; i++) {
            int command = sc.nextInt();
            switch (command) {
                case 1 -> pq.add(sc.nextInt());
                case 2 -> pq.remove(sc.nextInt());
                case 3 -> System.out.println(pq.peek());
            }
        }
    }

    public static void main(String[] args) {
        QHEAP1 test = new QHEAP1();

        // 예제 테스트
        // 기대 출력:
        // 4
        // 9
        String input = String.join("\n",
                "5",
                "1 4",
                "1 9",
                "3",
                "2 4",
                "3"
        );
        Scanner sc = new Scanner(input);
        test.solve(sc);
    }
}
