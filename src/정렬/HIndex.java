package 정렬;

import java.util.Arrays;

/**
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42747
 */
public class HIndex {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int total = citations.length;

        for (int i = 0; i < total; i++) {
            int h번이상인용된논문의수 = total - i;
            int 인용횟수 = citations[i];
            if(인용횟수 >= h번이상인용된논문의수) return citations[i];
        }
        //논문 1편 발표한 경우
        return citations[0];
    }

    public static void main(String[] args) {
        HIndex test = new HIndex();
        int[] citations = {3, 0, 6, 1, 5};
        int result = test.solution(citations);
        System.out.println(result);
    }
}
