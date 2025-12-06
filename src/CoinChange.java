import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        //최소 코인 사용 수

        //= 최대 금액의 코인을 최대한 사용
        Arrays.sort(coins);

        search(coins.length - 1, amount, coins);

        return -1;
    }

    //아이디어 = 가격이 제일 높은 동전을 선택하고 동전 금액 만큼 차감액을 차감한다.
    public boolean search(int target, int amount, int[] coins) {
        if (amount == 0) return true;
        if (amount < 0) return false;
        if (amount < coins[target]) {
            return search(target - 1, amount, coins);
        } else {
            amount -= coins[target];
            return search(target, amount, coins);
        }
    }
}
