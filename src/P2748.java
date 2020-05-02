package BAEKJOON;

import java.util.Scanner;

public class P2748 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] dp = new long[N+1];
		dp[0] = 0; dp[1] = 1;
		for(int i=2; i<=N; i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		System.out.println(dp[N]);
	}

}
