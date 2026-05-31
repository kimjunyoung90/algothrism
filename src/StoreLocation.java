import java.util.Arrays;

/*
 * [문제 1] 매장 위치 개수
 *
 * 2차원 좌표평면의 아파트들로부터 맨해튼 거리 합이 최소가 되는
 * 정수 좌표(매장 위치)가 모두 몇 군데인지 구한다.
 *
 * 맨해튼 거리: |x1 - x2| + |y1 - y2|
 *
 * --- 핵심 아이디어 ---
 * 맨해튼 거리는 x축 거리와 y축 거리가 서로 독립이다.
 *   총 거리 합 = (x 거리 합) + (y 거리 합)
 * 따라서 x 문제와 y 문제를 각각 1차원으로 따로 풀고,
 * 마지막에 (x 후보 개수) * (y 후보 개수)를 곱하면 된다.
 *
 * 1차원에서 거리 합을 최소로 만드는 점은 "중앙값"이다.
 *   - 점이 홀수 개  -> 정중앙 한 점에서만 균형  -> 후보 1개
 *   - 점이 짝수 개  -> 가운데 두 값 사이 구간 전체가 균형
 *                     -> 후보 = (오른쪽 가운데 값) - (왼쪽 가운데 값) + 1
 *                        (양 끝을 모두 포함하므로 +1)
 *
 * 왜 짝수일 때 구간 전체가 최소인가?
 *   가운데 두 값 사이에서 매장을 한 칸 옮기면, 왼쪽 점들과는
 *   멀어지고 오른쪽 점들과는 가까워진다. 좌우 개수가 같으므로
 *   변화량이 상쇄되어 거리 합이 그대로다.
 *
 * 시간복잡도: 정렬이 지배적이므로 O(n log n)
 */
public class StoreLocation {

    public int solution(int[][] positions) {
        int n = positions.length;
        int[] xs = new int[n];
        int[] ys = new int[n];

        // x, y 좌표를 각각 따로 모은다
        for (int i = 0; i < n; i++) {
            xs[i] = positions[i][0];
            ys[i] = positions[i][1];
        }

        // 각각 정렬
        Arrays.sort(xs);
        Arrays.sort(ys);

        // 후보 개수를 구해 곱한다 (오버플로 방지를 위해 long)
        long countX = countCandidates(xs);
        long countY = countCandidates(ys);

        return (int) (countX * countY);
    }

    /** 1차원 좌표 배열에서 거리 합을 최소로 만드는 정수 점의 개수 */
    private long countCandidates(int[] arr) {
        int n = arr.length;
        if (n % 2 == 1) {
            // 홀수: 중앙값 한 점
            return 1;
        } else {
            // 짝수: 가운데 두 값 사이의 정수 개수 (양 끝 포함)
            return (long) arr[n / 2] - arr[n / 2 - 1] + 1;
        }
    }

    // 간단한 검증용
    public static void main(String[] args) {
        StoreLocation s = new StoreLocation();
        int[][] test = {{1, 1}, {-1, 1}, {-1, -1}, {0, 0}};
        System.out.println(s.solution(test)); // 기대값: 4
    }
}
