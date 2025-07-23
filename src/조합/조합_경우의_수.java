package 조합;

public class 조합_경우의_수 {
    public static void main(String[] args) {
//        int n = 3;
//        int r = 2;
//        System.out.println(getCombinationCount(n, r));

        int[] numbers = new int[] {1, 2, 3};
        int[] result = new int[3];
        int r = 3;

        getCombination(numbers, new boolean[r], 0, 3, 2);

    }

    private static void getCombination(int[] numbers, boolean[] visited, int depth, int n, int r)  {

        if(r == 0) {
            print(numbers, visited);
            return;
        }

        if(depth == n) {
            return;
        }

        visited[depth] = true; //현재 원소를 뽑았을 때
        getCombination(numbers, visited, depth + 1, n, r - 1);

        visited[depth] = false;
        getCombination(numbers, visited, depth + 1, n, r);
    }

    private static void print(int[] numbers, boolean[] visited) {
        System.out.print("{ ");
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                System.out.print(numbers[i] + " ");
            }
        }
        System.out.print("}\n");
    }

    private static int getCombinationCount(int n, int r) {
        /**
         * n == r 이면 모두 뽑는 케이스 하나만 존재
         * r == 0 이면 모두 뽑지 않는 케이스 하나만 존재
         */
        if(n == r || r == 0)
            return 1;
        return getCombinationCount(n-1, r-1) + getCombinationCount(n - 1, r);
    }
}
