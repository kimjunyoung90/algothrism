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
    public static final char upDefault = 'A';
    public static final double downDefault = 'Z' + 1;

    public int solution(String name) {
        // TODO(human): 구현하세요.
        // 조이스틱을 조작해 알파벳 이름을 완성
        // 처음에 모든 자리가 'A'로 시작
        // 위 아래로 알파벳을 변경하고 좌 우로 커서 이동
        // 최소 조작 횟수
        // 첫번째 문자부터 끝에 문자까지 계속해서 이동하면서 체크하고
        // 'A' 가 타겟 문자가 되기 위해서 조이스틱을 위로 조작하는게 빠를지, 아래로 조작하는게 빠를지 확인한 뒤 더 빠른 방식으로 조작 횟수를 갱신한다.
        int answer = 0;

        for (char c : name.toCharArray()) {
            //문자는 숫자값이 인코딩 된 형태
            //그래서 문자 끼리 연산을 하면 어느 정도 차이가 발생하는지 알 수 있음
            // ex) A에서 Z라는 수를 만들기 위해 위로 조이스틱을 돌릴지(A -> B -> C -> D .... Z)
            //90(Z) - 65(A) = 25 번 조이스틱을 움직여야함
            if(c == upDefault) continue;
            int min = (int) Math.min(c - upDefault, downDefault - c);
            answer += min;
        }
        //좌우 이동 횟수
        answer += name.length() - 1;
        return answer;
    }

    public static void main(String[] args) {
        조이스틱 test = new 조이스틱();
        System.out.println(test.solution("JEROEN")); // 기대값: 56
        System.out.println(test.solution("JAN"));    // 기대값: 23
    }
}
