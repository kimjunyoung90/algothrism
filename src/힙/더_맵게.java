package 힙;

/**
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42626
 */
public class 더_맵게 {
    public int solution(int[] scoville, int K) {
        // TODO(human): PriorityQueue를 활용하여 구현하세요.
        // 힌트:
        //   - PriorityQueue<Integer> 선언 후 scoville 값을 모두 넣기
        //   - peek()으로 최솟값 확인, poll()로 꺼내기
        //   - 섞기 공식: 가장 안 매운 것 + (두 번째로 안 매운 것 * 2)
        //   - 큐에 원소가 1개 이하이면 더 이상 섞을 수 없음
        //   - 불가능하면 -1 반환
        return -1;
    }
    public static void main(String[] args) {
        더_맵게 test = new 더_맵게();
        int[] scoville = { 1, 2, 3, 9, 10, 12 };
        int K = 7;
        int result = test.solution(scoville, K);
        System.out.println(result);
    }
}
