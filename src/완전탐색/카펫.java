package 완전탐색;

/**
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42842
 */
public class 카펫 {
    public static void main(String[] args) {
        int brownBlocks = 10;
        int yellowBlocks = 2;

        //가로의 길이는 세로보다 같거나 크다.
        int i = 1;
        while (yellowBlocks > i) {
            if(yellowBlocks % i == 0) {
                int yellowWidth = yellowBlocks/i;
                int yellowHeight = i;
            }
        }
    }
}
