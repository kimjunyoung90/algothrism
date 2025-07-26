package 정렬;

import java.util.Arrays;
import java.util.Collections;

/**
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42746?language=java
 */
public class 가장_큰_수 {
    public String solution(int[] numbers) {
        String[] numberStrings = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            numberStrings[i] = numbers[i] + "";
        }

        Arrays.sort(numberStrings, (a, b) -> (b + a).compareTo(a + b));

        StringBuilder answer = new StringBuilder();

        for (String numberString : numberStrings) {
            answer.append(numberString);
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        가장_큰_수 test = new 가장_큰_수();
        int[] numbers = { 3, 30, 34, 5, 9 };
        String result = test.solution(numbers);
        System.out.println(result);
    }
}
