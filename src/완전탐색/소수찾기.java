package 완전탐색;

import java.util.HashSet;
import java.util.Set;

/**
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42839
 */

public class 소수찾기 {

    static Set<Integer> nubmerSet = new HashSet<>();

    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        addNumberSet("", numbers, visited);
        int numberOfPrime = 0;
        for (int number : nubmerSet) {
            if (isPrime(number)) numberOfPrime++;
        }

        return numberOfPrime;
    }

    public static void main(String[] args) {
        소수찾기 test = new 소수찾기();
        System.out.println(test.solution("17"));
    }

    public boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i <  number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public void addNumberSet(String current, String numbers, boolean[] visited) {
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                String newNumber = current + numbers.charAt(i);
                nubmerSet.add(Integer.parseInt(newNumber));
                addNumberSet(newNumber, numbers, visited);
                visited[i] = false;
            }
        }
    }

}
