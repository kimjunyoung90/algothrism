package 탐욕;

/**
 * 주유소 (Gas Station)
 *
 * 원형으로 배치된 n개의 주유소가 있다. i번 주유소에는 gas[i]만큼의 기름이 있고,
 * i번에서 i+1번으로 이동하는 데 cost[i]만큼의 기름이 든다.
 * 빈 탱크로 어느 한 주유소에서 출발하여 원형 경로를 한 바퀴 돌아 다시 출발점으로
 * 돌아올 수 있는 출발 주유소의 인덱스를 반환한다. 불가능하면 -1을 반환한다.
 * (정답이 존재한다면 유일하다)
 *
 * 제약조건:
 * - n == gas.length == cost.length
 * - 1 <= n <= 10^5
 * - 0 <= gas[i], cost[i] <= 10^4
 *
 * @link https://leetcode.com/problems/gas-station/
 */
public class 주유소 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // TODO(human): 구현하세요.
        //i에서 출발했을 때 한 바퀴 돌고 i로 돌아올 수 있는 인덱스
        //gas = 충전 가능한 기름
        //cost = 현재로 오기 위해 필요한 기름
        int totalGas = 0;
        for (int i = 0; i < cost.length; i++) {
            //현재 충전소에서 gas 충전하고
            totalGas += gas[i];
            //다음 충전소 가기 위해 gas 소비
            totalGas -= cost[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        주유소 test = new 주유소();
        System.out.println(test.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2})); // 기대값: 3
        System.out.println(test.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));             // 기대값: -1
    }
}
