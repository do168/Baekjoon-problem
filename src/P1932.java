package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1932 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		int n = Integer.parseInt(str.nextToken());
		int[][] tri = new int[n+1][n+1];
		int[][] dp = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			str = new StringTokenizer(bfr.readLine());
			for(int j=1; j<=i; j++) {
				tri[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		dp[1][1] = tri[1][1];
		for(int i=2; i<=n; i++) {
			for(int j=1; j<=i; j++) {
				if(j==1) dp[i][j] = dp[i-1][j]+tri[i][j];
				else if(j==i) dp[i][j] = dp[i-1][j-1]+tri[i][j];
				else dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + tri[i][j];
			}
		}
		int answer = 0;
		for(int i=1; i<=n; i++) {
			if(answer<dp[n][i])
				answer = dp[n][i];
		}
		System.out.println(answer);
	}

}
