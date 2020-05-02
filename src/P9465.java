package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P9465 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		int T = Integer.parseInt(str.nextToken());
		for(int i=0; i<T; i++) {
			str = new StringTokenizer(bfr.readLine());
			int N = Integer.parseInt(str.nextToken());
			int[][] stick = new int[N+1][2];
			int[][] dp = new int[N+1][2];
			for(int j=0; j<2; j++) {
				str = new StringTokenizer(bfr.readLine());
				for(int z = 1; z<=N; z++) {
					stick[z][j] = Integer.parseInt(str.nextToken()); 
				}
			}
			dp[1][0] = stick[1][0];
			dp[1][1] = stick[1][1];
			for(int j = 2; j<=N; j++) {
				dp[j][0] = Math.max(dp[j-1][1], dp[j-2][1]) + stick[j][0];
				dp[j][1] = Math.max(dp[j-1][0], dp[j-2][0]) + stick[j][1];
			}
			int answer = Math.max(dp[N][0], dp[N][1]);
			System.out.println(answer);
		}
	}

}
