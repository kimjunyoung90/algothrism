package 탐욕;

/**
 * 조이스틱
 *
 * 조이스틱으로 알파벳 이름을 완성한다. 처음엔 모든 자리가 'A'이며,
 * 위/아래로 알파벳을 바꾸고 좌/우로 커서를 이동해 목표 이름을 만드는
 * 최소 조작 횟수를 구한다.
 *
 * 제약조건:
 * - name은 알파벳 대문자로만 이루어져 있다.
 * - name의 길이는 1 이상 20 이하이다.
 *
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42860
 */
public class 조이스틱 {
    public static final char DEFAULT_CH = 'A';
    public static final char LAST_CH = 'Z';

    public int solution(String name) {
        int n = name.length();

        // 1) 상・하 비용: 자리마다 확정이므로 전부 더한다.
        int upDown = 0;
        for (int i = 0; i < n; i++) {
            char current = name.charAt(i);
            upDown += Math.min(current - DEFAULT_CH, LAST_CH - current + 1);
        }

        // 2) 좌・우 비용: 끝까지 직진(n-1)을 기본값으로 두고, 더 싼 꺾기 경로로 갱신한다.
        int move = n - 1;
        for (int i = 0; i < n; i++) {
            // i 다음부터 연속된 A 구간을 건너뛰어 다음 비-A 위치(next)를 찾는다.
            int next = i + 1;
            while (next < n && name.charAt(next) == DEFAULT_CH) {
                next++;
            }

            // 오른쪽 i까지 갔다가 되돌아 왼쪽 끝(순환)으로 가는 비용
            int rightThenLeft = i + i + (n - next);
            // 왼쪽 끝(순환)으로 먼저 갔다가 오른쪽 i까지 가는 비용
            int leftThenRight = (n - next) + (n - next) + i;

            move = Math.min(move, Math.min(rightThenLeft, leftThenRight));
        }

        return upDown + move;
    }

    public static void main(String[] args) {
        조이스틱 test = new 조이스틱();
        System.out.println(test.solution("JEROEN")); // 기대값: 56
        System.out.println(test.solution("JAN"));    // 기대값: 23
    }
}
