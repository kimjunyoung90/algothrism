package 탐욕;

import java.util.Arrays;

/**
 * 체육복
 *
 * 여벌 체육복이 있는 학생만 바로 앞번호 또는 바로 뒷번호 학생에게 체육복을 빌려줄 수 있다.
 * 체육복을 빌려주는 방법을 최적화하여 체육 수업을 들을 수 있는 학생 수의 최댓값을 구한다.
 *
 * 제약조건:
 * - 전체 학생 수 n: 2 이상 30 이하
 * - 체육복을 도난당한 학생 수(lost)는 1 이상 n 이하이고 중복되는 번호는 없다.
 * - 여벌 체육복을 가져온 학생 수(reserve)는 1 이상 n 이하이고 중복되는 번호는 없다.
 * - 여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있다.
 *   이 경우 빌려줄 수 없고 자신은 체육 수업을 들을 수 있다.
 *
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42862
 */
public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        // TODO(human): 구현하세요.
        // 체육 수업을 들을 수 있는 최대 학생의 수
        // 여벌 체육복이 있는 학생만 바로 앞 또는 뒤 학생에게 체육복 빌려줄 수 있음
        // 여벌 체육복을 가져온 학생 = reserve
        // lost = 체육복을 도난 당한 학생의 번호 목록
        // 처음부터 아예 체육복을 안가져온 학생은 없다.
        int[] clothes = new int[n + 2];
        Arrays.fill(clothes, 1);
        clothes[0] = 0;
        clothes[clothes.length - 1] = 0;
        //체육복 여벌
        for (int i = 0; i < reserve.length; i++) {
            clothes[reserve[i]]++;
        }
        //체육복 도난
        for (int i = 0; i < lost.length; i++) {
            clothes[lost[i]]--;
        }
        //체육복 빌리기
        for (int i = 1; i < clothes.length - 1; i++) {
            //체육복 있어?
            //없으면
            if(clothes[i] == 0) {
                //앞 사람한테 체육복 여유분 있어?
                if(clothes[i - 1] > 1) {
                    clothes[i]++;
                    clothes[i - 1]--;
                    continue;
                }

                //뒷사람한테 체육복 여유분 있어?
                if(clothes[i + 1] > 1) {
                    clothes[i]++;
                    clothes[i + 1]--;
                }
            }
        }
        return Arrays.stream(clothes).filter(i -> i != 0).toArray().length;
    }

    public static void main(String[] args) {
        체육복 test = new 체육복();

        System.out.println(test.solution(5, new int[]{2, 4}, new int[]{1, 3, 5})); // 기대값: 5
        System.out.println(test.solution(5, new int[]{2, 4}, new int[]{3}));       // 기대값: 4
        System.out.println(test.solution(3, new int[]{3}, new int[]{1}));          // 기대값: 2
    }
}
