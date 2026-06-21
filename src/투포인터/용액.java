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
        while (leftPointer < rightPointer) {
            int mix = nums[leftPointer] + nums[rightPointer];
            //mix가 0보다 크면 더 약한 산성 용액을 섞어야함
            //mix가 0보다 작으면 더 센 알칼리 용액을 섞어야 함
            //pointer 이동 시 무분별하게 이동하면 안됨.
            //산성 + 알칼리 용액이 동일한 배열에 있기 때문에
            //pointer가 서로의 영역을 침범하진 않는지 확인해야함
            //이동하기 전에 확인을 해야함
            if(0 < mix) {
                //rightPointer가 알칼리 용액을 가리키진 않는지?
                if(nums[rightPointer - 1] < 0) break;
                rightPointer--;
            } else if(mix < 0) {
                //leftPointer가 산성 용액을 가리키진 않는지?
                if(0 < nums[leftPointer + 1]) break;
                leftPointer++;
            } else {
                //같은 경우 더 0에 수렵한 조합은 없는지
                //예) -100, 100 = 0
                // -10, 10 = 0
                //각 후보 용액들의 값은 겹침이 없음
                //pointer 하나씩 가운데에 가깝게 이동
                if(0 < nums[leftPointer + 1] || nums[rightPointer - 1] < 0) break;
                leftPointer++;
                rightPointer--;
            }
        }
        return new int[]{nums[leftPointer], nums[rightPointer]};
    }

    public static void main(String[] args) {
        용액 test = new 용액();

        int[] result1 = test.solve(new int[]{-99, -2, -1, 4, 98});
        System.out.println(result1[0] + " " + result1[1]); // 기대값: -99 98

        int[] result2 = test.solve(new int[]{-100, -2, -1, 103});
        System.out.println(result2[0] + " " + result2[1]); // 기대값: -2 -1
    }
}
