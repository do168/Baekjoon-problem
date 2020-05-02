package BAEKJOON;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class P1904 {
	public static void main(String[] args) throws IOException{
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		int N = Integer.parseInt(str.nextToken());
		int[] dp = new int[N+1];
		if (N==1) {
			System.out.println(1);
			return;
		}
		else if(N==2) {
			System.out.println(2);
			return;
		}
		dp[1] = 1; dp[2] = 2;
		for(int i=3; i<=N; i++) {
			dp[i] = (dp[i-1]+dp[i-2])%15746;
		}
		System.out.println(dp[N]);
	}

}
