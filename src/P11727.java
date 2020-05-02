package BAEKJOON;

import java.util.*;
import java.io.*;
public class P11727 {
	static long dp[];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		
		int n = Integer.valueOf(str.nextToken());
		
		long[] dp = new long[n+1];
		
		for (int i=0; i<=n; i++) {
			if(i==0) dp[i] =0;
			else if(i==1) dp[i] = 1;
			else if(i==2) dp[i] = 3;
			else dp[i] = (dp[i-1] + 2*dp[i-2])%10007;
		}
		
		System.out.println(dp[n]);
	}
	

}
