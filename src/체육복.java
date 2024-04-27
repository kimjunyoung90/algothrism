import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42862
 * 전체 학생 수 n
 * 체육복을 도난 당한 학생들 번호 lost [] 중복 번호 없음
 * 여분의 체육복이 있는 학생들 번호 reverse [] 중복 번호 없음
 * 여분의 체육복이 있는 학생이 체육복을 도난 당했을 수 있다.
 */
public class 체육복 {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = { 2, 4 };
        int[] reserve = { 1, 3, 5 };

        int answer = solution(n, lost, reserve);

        System.out.println(answer);
    }

    private static int solution(int n, int[] lost, int[] reserve) {
        int[] clothes = new int[n + 2];

        for (int i = 0; i < lost.length; i++) {
            clothes[lost[i]]--;
        }
        for (int i = 0; i < reserve.length; i++) {
            clothes[reserve[i]]++;
        }

        int answer = n;
        for (int i = 1; i <= n; i++) {
            if(clothes[i] < 0) {
                if(clothes[i - 1] > 0) {
                    clothes[i]++;
                    clothes[i - 1]--;
                } else if (clothes[i + 1] > 0) {
                    clothes[i]++;
                    clothes[i + 1]--;
                }else {
                    answer--;
                }
            }
        }
        return answer;
    }
}
