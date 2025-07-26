package 해시;

import java.util.*;

/**
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42578?language=java
 */
public class 의상 {
    public int solution(String[][] clothes) {

        //옷의 종류별 개수 구하기
        Map<String, Integer> typeCount = new HashMap<>();
        for (String[] clothe : clothes) {
            typeCount.put(clothe[1], typeCount.getOrDefault(clothe[1], 0) + 1);
        }

        //옷 종류별 선택 조합 구하기
        //옷 종류에 안입은 경우 추가하여 + 1
        int answer = 1;
        for (int count : typeCount.values()) {
            answer *= (count + 1);
        }

        return answer - 1;
    }

    public static void main(String[] args) {
        의상 test = new 의상();
        String[][] clothes = {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };
        int result = test.solution(clothes);
        System.out.println(result);
    }
}
