/**
 * Container With Most Water
 *
 * 길이 n인 정수 배열 height가 주어진다. 각 원소는 해당 위치(인덱스)에 세워진 수직선의 높이를 나타낸다.
 * 두 수직선을 골라 x축과 함께 물을 담는 컨테이너를 만들 때, 담을 수 있는 물의 최대량을 구하라.
 *
 * 제약조건:
 * - 2 <= height.length <= 10^5
 * - 0 <= height[i] <= 10^4
 *
 * @link https://leetcode.com/problems/container-with-most-water/description/
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        // TODO(human): 구현하세요.
        // 두 height 최대 높이를 구하면 최대 컨테이너겠구나
        int left = 0;
        int right = height.length - 1;
        int area = 0;
        while (left < right) {
            //이렇게 하면 left가 안올라갈수도 있는데... 흠....
            area = Math.max(area, Math.abs(left - right) * Math.min(height[left], height[right]));
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return area;
    }

    public static void main(String[] args) {
        ContainerWithMostWater test = new ContainerWithMostWater();

        // Example 1
        int result1 = test.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(result1); // 기대값: 49

        // Example 2
        int result2 = test.maxArea(new int[]{1, 1});
        System.out.println(result2); // 기대값: 1
    }
}
