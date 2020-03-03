package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class P1463 {
	static int[] dp;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new int[n + 1];
		System.out.println(DP(n));
	
	}
	static int DP(int n) {
		if (n == 1) {
			return 0;
		}
		dp[n] = DP(n - 1) + 1;
		if (n % 3 == 0) {
			int temp = dp[n/3]+1;
			dp[n] = dp[n]<temp ? dp[n] : temp;
		}
		if (n % 2 == 0) {
			int temp = dp[n/2] +1;
			dp[n] = dp[n]<temp ? dp[n] : temp;
		}
		return dp[n];
	}
}
