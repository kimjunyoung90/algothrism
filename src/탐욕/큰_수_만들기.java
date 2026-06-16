package 탐욕;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 큰_수_만들기
 *
 * 문자열 number에서 k개의 수를 제거했을 때 만들 수 있는 가장 큰 수를 구한다.
 *
 * 제약조건:
 * - number는 2자리 이상 1,000,000자리 이하인 숫자 문자열
 * - k는 1 이상 number의 자릿수 미만인 자연수
 *
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42883
 */
public class 큰_수_만들기 {
    public String solution(String number, int k) {
        // TODO(human): 구현하세요.
        // 현재 숫자가 바로 뒤에 있는 숫자보다 작으면 제거
        // = 현재 숫자가 바로 뒤에 있는 숫자보다 크면 미제거

        //살아남은 대상
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < number.length(); i++) {
            char cur = number.charAt(i);

            //제거
            while (k > 0 && !stack.isEmpty() && stack.peek() < cur) {
                stack.pop();
                k--;
            }

            stack.push(cur);
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        큰_수_만들기 test = new 큰_수_만들기();
        System.out.println(test.solution("1924", 2));        // 기대값: 94
        System.out.println(test.solution("1231234", 3));     // 기대값: 3234
        System.out.println(test.solution("4177252841", 4));  // 기대값: 775841
    }
}
