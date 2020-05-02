package BAEKJOON;

import java.util.Scanner;

public class P2579 {
	static int[] stair;
	static int[] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		stair = new int[n+1];
		dp = new int[n+1];
		for(int i=1; i<=n; i++) {
			stair[i] = sc.nextInt();
		}
		dp[1] = stair[1];
		if(n>=2)
			dp[2] = dp[1] + stair[2];
		for(int i=3; i<=n; i++) {
			dp[i] = Math.max(dp[i-2], stair[i-1]+dp[i-3]) + stair[i];
		}
		System.out.println(dp[n]);
		
	}
	
}
