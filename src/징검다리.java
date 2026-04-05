import java.util.Arrays;

public class 징검다리 {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int left = 1;
        int right = distance;
        Arrays.sort(rocks);

        //여기서 어떻게 이진탐색??
        while (left <= right) {
            int mid = (left + right) / 2;
            if(isPossible(distance, rocks, n, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

    private boolean isPossible(int distance, int[] rocks, int n, int mid) {
        int prev = 0;
        int removed = 0;
        for (int current : rocks) {
            if(current - prev < mid) {
                removed++;
            } else {
                prev = current;
            }
        }

        if(distance - prev < mid) {
            removed++;
        }
        return removed <= n;
    }

    public static void main(String[] args) {
        int distance = 25;
        int[] rocks = {2, 14, 11, 21, 17};
        int n = 2;
        System.out.println(new 징검다리().solution(distance, rocks, n));
    }
}
