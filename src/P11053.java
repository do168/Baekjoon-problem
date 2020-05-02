package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P11053 {
	static int n;
	static int[] dp;
	static int[] ar;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
			BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer str = new StringTokenizer(bfr.readLine());
			n = Integer.parseInt(str.nextToken());
			ar = new int[n];
			dp = new int[n];
			str = new StringTokenizer(bfr.readLine());
			for(int i=0; i<n; i++) {
				ar[i] = Integer.parseInt(str.nextToken());
			}
			for(int i=0; i<n; i++) {
				dp[i] = 1;
				for(int j = 0; j<i; j++) {
					if(ar[j]<ar[i] && dp[i]<=dp[j]) {
						dp[i] = dp[j]+1;
						max = Math.max(max, dp[i]);
					}
				}
			}
			System.out.println(max);
	}
	

}
