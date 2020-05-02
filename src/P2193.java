package BAEKJOON;

import java.util.Scanner;

public class P2193 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] dp = new long[N+1];
		long[] dp_zero = new long[N+1];
		long[] dp_one = new long[N+1];
		if(N==1||N==2) {
			System.out.println(1);
			return;
		}
		dp_zero[1] = 0;
		dp_one[1] = 1;
		dp_zero[2] = 1;
		dp_one[2] = 0;
		dp[1] = dp_zero[1]+dp_one[1];
		dp[2] = dp_zero[2]+dp_one[2];
		for(int i=3; i<=N; i++) {
			dp[i] = dp_zero[i-1]*2 + dp_one[i-1];
			dp_zero[i] = dp_zero[i-1]+dp_one[i-1];
			dp_one[i] = dp_zero[i-1];
		}
		System.out.println(dp[N]);
	}

}
