package 큐;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42583
 */
public class 다리를_지나는_트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int index = 0;
        Queue<Integer> bridge = new LinkedList<>();
        for(int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        while(index < truck_weights.length) {
            time++;
            weight += bridge.poll();

            if(weight >= truck_weights[index]) {
                bridge.add(truck_weights[index]);
                weight -= truck_weights[index];
                index++;
            } else {
                bridge.add(0);
            }
        }
        return time + bridge_length;
    }

    public static void main(String[] args) {
        다리를_지나는_트럭 test = new 다리를_지나는_트럭();
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};
        int result = test.solution(bridge_length, weight, truck_weights);
        System.out.println(result);
    }
}
