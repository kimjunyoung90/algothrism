package 기초;

/**
 * 통학의_신
 *
 * x^2 + 2Ax + B = 0 의 정수 근을 오름차순으로 공백 구분해 반환한다. (중근이면 하나만)
 *
 * 제약조건:
 * - A, B는 정수, -1000 ≤ A, B ≤ 1000
 * - 근은 항상 정수
 *
 * @link https://takjoon.takijk.xyz/problems/8589
 */
public class 통학의_신 {
    public String solution(int A, int B) {
        // TODO(human): 구현하세요.
        StringBuilder sb = new StringBuilder();
        for (int i = -2000; i <= 2000 ; i++) {
            int answer = i * i + 2 * A * i + B;
            if(answer == 0) {
                sb.append(i).append(' ');
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        통학의_신 test = new 통학의_신();
        System.out.println(test.solution(2, 3));  // 기대값: -3 -1
        System.out.println(test.solution(1, -8)); // 기대값: -4 2
        System.out.println(test.solution(1, 1));  // 기대값: -1
    }
}
