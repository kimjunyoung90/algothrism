package 큐;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42587?language=java
 */
public class 프로세스 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Process> queue = new LinkedList<>();

        for(int i = 0; i < priorities.length; i++) {
            Process process = new Process(i, priorities[i]);
            queue.add(process);
        }

        while(!queue.isEmpty()) {
            Process current = queue.poll();
            boolean mostPriority = true;
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                Process next = queue.poll();
                if(next.priority > current.priority) {
                    mostPriority = false;
                }
                queue.add(next);
            }

            if(mostPriority) {
                answer++;
                if(current.location == location) break;
            } else {
                queue.add(current);
            }
        }

        return answer;
    }
}

class Process {
    int location;
    int priority;
    Process (int location, int priority) {
        this.location = location;
        this.priority = priority;
    }
}
