package dfs;

/**
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/43165
 * @link 참조 https://hyojun.tistory.com/entry/Programmers-%ED%83%80%EA%B2%9F-%EB%84%98%EB%B2%84-Java
 */
public class 타겟넘버 {
    int answer = 0;
    public int solution(int[] numbers, int target) {
//        int answer = 0;
        return answer;
    }

    private void dfs(int[] numbers, int target, int depth, int sum) {
        if(numbers.length == depth) {
            if(sum == target) {
                answer++;
            }
            return;
        }
        dfs(numbers, target, depth + 1, sum + numbers[depth]);
        dfs(numbers, target, depth + 1, sum - numbers[depth]);
    }

    public static void main(String[] args) {

        타겟넘버 targetNumber = new 타겟넘버();
        int[] numbers = new int[]{4,1,2,1};
        int target = 4;
        int depth = 0;
        int sum = 0;
        targetNumber.dfs(numbers, target, depth, sum);
        System.out.println(targetNumber.answer);
    }
}
