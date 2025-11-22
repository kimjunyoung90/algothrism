package 힙;

import java.util.Arrays;
import java.util.TreeSet;

public class 이중우선순위큐 {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        TreeSet<Integer> deque = new TreeSet<>();
        for(String operation : operations) {
            String[] data = operation.split(" ");
            String order = data[0];
            int num = Integer.valueOf(data[1]);
            if("I".equals(order)) {
                deque.add(num);
            } else {
                if(num == 1) {
                    deque.pollLast();
                } else {
                    deque.pollFirst();
                }
            }
        }
        if(!deque.isEmpty()) {
            answer[0] = deque.last();
            answer[1] = deque.first();
        }
        return answer;
    }

    public static void main(String[] args) {
//        String[] operations = { "I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1" };
        String[] operations = { "I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333" };
        System.out.println(Arrays.toString(new 이중우선순위큐().solution(operations)));
    }
}
