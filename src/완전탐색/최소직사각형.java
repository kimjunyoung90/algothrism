package 완전탐색;

/**
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/86491?language=java
 */
public class 최소직사각형 {
    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        int width = 0;
        int height = 0;

        for (int i = 0; i < sizes.length; i++) {

            if(sizes[i][0] < sizes[i][1]) {
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }

            if (sizes[i][0] > width) width = sizes[i][0];
            if (sizes[i][1] > height) height = sizes[i][1];
        }

        System.out.println(width * height);
    }
}
