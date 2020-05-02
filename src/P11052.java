package BAEKJOON;

import java.util.Scanner;

public class P11052 {
	static int[] pack;
	static int[] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		pack = new int[n+1];
		dp = new int[n+1];
		for(int i=1; i<=n; i++) {
			pack[i] = sc.nextInt();
		}
		dp[1] = pack[1];
		for(int i=1;i<=n; i++) {
			for(int j=1; j<=i; j++) {
				dp[i] = Math.max(dp[i], pack[j]+dp[i-j]);
			}
		}
		System.out.println(dp[n]);
		
	}
}
