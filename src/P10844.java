package BAEKJOON;

import java.util.Scanner;

public class P10844 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long answer = 0;
		long[][] dp = new long[n+1][10];
		for(int i=1; i<=9; i++) {
			dp[1][i]++;
		}
		for(int i=2; i<=n; i++) {
			for(int j=0; j<=9; j++) {
				if(j==0) {
					dp[i][1]+=dp[i-1][j]%1000000000;
				}
				else if(j==9) {
					dp[i][8]+=dp[i-1][j]%1000000000;
				}
				else {
					dp[i][j-1]+=dp[i-1][j]%1000000000;
					dp[i][j+1]+=dp[i-1][j]%1000000000;
				}
			}
//			for(int k=0; k<=9; k++) {
//				System.out.print(dp[i][k] + " ");
//			}
//			System.out.println();
		}
		for(int i=0; i<=9; i++) {
			answer+=dp[n][i];
		}
		System.out.println(answer%1000000000);
	}

}
