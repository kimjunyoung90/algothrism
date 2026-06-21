package 투포인터;

/**
 * 용액 (백준 2467)
 *
 * 오름차순 정렬된 N개의 특성값 중 서로 다른 두 용액을 혼합하여
 * 특성값(두 값의 합)이 0에 가장 가까운 두 용액을 찾는다.
 *
 * 제약조건:
 * - 2 ≤ N ≤ 100,000
 * - 각 특성값은 -1,000,000,000 이상 1,000,000,000 이하, 모두 서로 다름
 * - 입력은 오름차순 정렬되어 주어진다
 * - 두 용액은 특성값 오름차순으로 출력
 *
 * @link https://takjoon.takijk.xyz/problems/15861
 */
public class 용액 {
    public int[] solve(int[] nums) {
        // TODO(human): 구현하세요.
        //산성 용액 1 ~ 1,000,000,000
        //알칼리성 용액 -1 ~ -1,000,000,000

        //산성 용액 + 알칼리성 용액 = 0에 가까운 조합
        int leftPointer = 0; //알칼리성 pointer
        int rightPointer = nums.length - 1; //산성 pointer
        int minGap = 999999999;
        int[] candidate = new int[2];
        while (leftPointer < rightPointer) {
            int mix = nums[leftPointer] + nums[rightPointer];

            //mix 절대값이 minGap 보다 작으면 절대값을 갱신해야함
            int gap = Math.abs(mix);
            if(gap <= minGap) {
                minGap = Math.min(gap, minGap);
                candidate[0] = nums[leftPointer];
                candidate[1] = nums[rightPointer];
            }

            if(0 < mix) {
                rightPointer--;
            } else if(mix < 0) {
                leftPointer++;
            } else {
                //같은 경우 더 0에 수렵한 조합은 없는지
                //예) -100, 100 = 0
                // -10, 10 = 0
                //각 후보 용액들의 값은 겹침이 없음
                //pointer 하나씩 가운데에 가깝게 이동
                leftPointer++;
                rightPointer--;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        용액 test = new 용액();

        int[] result1 = test.solve(new int[]{-99, -2, -1, 4, 98});
        System.out.println(result1[0] + " " + result1[1]); // 기대값: -99 98

        int[] result2 = test.solve(new int[]{-100, -2, -1, 103});
        System.out.println(result2[0] + " " + result2[1]); // 기대값: -2 -1
    }
}
