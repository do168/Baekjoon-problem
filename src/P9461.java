package BAEKJOON;

import java.util.Scanner;

public class P9461 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			int N = sc.nextInt();
			long[] dp = new long[100];
			dp[1] = dp[2] = dp[3] = 1;
			dp[4] = dp[5] = 2;
			for(int j = 6; j<=N; j++) {
				dp[j] = dp[j-1] + dp[j-5];
			}
			System.out.println(dp[N]);
		}
	}

}
