package 탐욕;

/**
 * 점프_게임
 *
 * 정수 배열 nums가 주어진다. 처음에 0번 인덱스에 위치하며,
 * nums[i]는 해당 위치에서 점프할 수 있는 최대 거리를 나타낸다.
 * 마지막 인덱스에 도달할 수 있으면 true, 아니면 false를 반환한다.
 *
 * 제약조건:
 * - 1 <= nums.length <= 10^4
 * - 0 <= nums[i] <= 10^5
 *
 * @link https://leetcode.com/problems/jump-game/
 */
public class 점프_게임 {
    public boolean canJump(int[] nums) {
        return nextStep(0, nums);
    }

    private boolean nextStep(int current, int[] nums) {

        if(current >= nums.length - 1) {
            return true;
        }

        int maxStep = nums[current];

        boolean result;

        for (int i = current; i < current + maxStep; i++) {
            result = nextStep(i + 1, nums);
            if(result) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        점프_게임 test = new 점프_게임();
        System.out.println(test.canJump(new int[]{2, 3, 1, 1, 4})); // 기대값: true
        System.out.println(test.canJump(new int[]{3, 2, 1, 0, 4})); // 기대값: false
    }
}
