package 탐욕;

import java.util.*;

/**
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42885
 */
public class 구명보트 {

    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int first = 0, last = people.length -1;
        int count = 0;

        while(first <= last) {
            if(limit >= people[first] + people[last]) {
                first++;
            }
            last--;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        System.out.println(new 구명보트().solution(people, limit));
    }
}
