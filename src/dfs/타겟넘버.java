package dfs;

/**
 * 타겟 넘버
 *
 * 음이 아닌 정수 배열의 각 숫자 앞에 +나 -를 붙여 순서대로 모두 더했을 때
 * 타겟 넘버를 만드는 방법의 수를 구하는 문제.
 *
 * 제약조건:
 * - 주어지는 숫자의 개수는 2개 이상 20개 이하
 * - 각 숫자는 1 이상 50 이하인 자연수
 * - 타겟 넘버는 1 이상 1000 이하인 자연수
 *
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/43165
 */
public class 타겟넘버 {
    public int solution(int[] numbers, int target) {
        return dfs(0, target, numbers, 0);
    }

    private int dfs(int number, int target, int[] numbers, int idx) {
        if (idx == numbers.length) {
            return number == target ? 1 : 0;
        }
        return dfs(number + numbers[idx], target, numbers, idx + 1)
             + dfs(number - numbers[idx], target, numbers, idx + 1);
    }

    public static void main(String[] args) {
        타겟넘버 test = new 타겟넘버();

        // 예제 1: 기대값 5
        int result1 = test.solution(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(result1);

        // 예제 2: 기대값 2
        int result2 = test.solution(new int[]{4, 1, 2, 1}, 4);
        System.out.println(result2);
    }
}
