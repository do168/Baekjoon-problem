package BAEKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class P2156 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] grapes = new int[n];
		for(int i=0; i<n; i++) {
			grapes[i] = sc.nextInt();
		}
		int[] dp = new int[n];
		dp[0] = grapes[0];
		if(n>1) {
			dp[1] = dp[0]+grapes[1];
		}
		if(n>2) {
			int[] temp = new int[3];
			for(int i=0; i<3; i++) {
				temp[i]= grapes[i];
			}
			Arrays.sort(temp);
			dp[2] = temp[1]+temp[2];
		}
		for(int i=3; i<n; i++) {
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-2], dp[i-3]+grapes[i-1]) + grapes[i]);
		}
		System.out.println(dp[n-1]);
	}

}
