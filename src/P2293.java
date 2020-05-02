package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2293 {
	static int[] coin;
	static int n;
	static int k;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		n = Integer.parseInt(str.nextToken());
		k = Integer.parseInt(str.nextToken());
		coin = new int[n];
		int[] dp = new int[10001];
		for(int i=0; i<n; i++) {
			str = new StringTokenizer(bfr.readLine());
			coin[i] = Integer.parseInt(str.nextToken());
		}
		dp[0] = 1;
		for(int i=0; i<n; i++) {
			for(int value = 1; value<=k; value++) {
				if(value - coin[i]>=0) dp[value] += dp[value - coin[i]];
			}
		}
		System.out.println(dp[k]);
		
		
	}
	

}
