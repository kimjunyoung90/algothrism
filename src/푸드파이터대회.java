/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/134240
 */
public class 푸드파이터대회 {
    public static void main(String[] args) {
        int[] food = {1, 3, 4, 6};
        String answer = "0";
        for(int i = food.length - 1; i > 0 ; i--) {
            for(int j = 0; j < food[i]/2; j++) {
                answer = i + answer + i;
            }
        }
        System.out.println(answer);
    }
}
