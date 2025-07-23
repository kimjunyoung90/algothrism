package 완전탐색;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42839
 */

public class 소수찾기 {

    static Set<String> nubmerSet = new HashSet<>();

    public static void main(String[] args) {
        for (int i = 0; i < 1000000000; i++) {
            System.out.println("고양이야 뛰어라");
        }
//        addNumberSet("011", "");
    }

    public static void addNumberSet(String numbers, String number) {

        if (number.length() == numbers.length()) {
            return;
        };
        for (int i = 0; i < numbers.length(); i++) {
            String newNumber = number + numbers.charAt(i);
            nubmerSet.add(newNumber);
            addNumberSet(numbers, newNumber);
        }
    }

}
