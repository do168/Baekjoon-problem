package baekjoon;

import java.util.*;
import java.io.*;
public class P11727 {
	static long[] dp;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		
		int n = Integer.valueOf(str.nextToken());
		dp = new long[n];
		System.out.println(DP(n)%10007);
		
	}
	static long DP(int n) {
		if(n == 1) {
			return 1;
		}
		else if (n == 2) {
			return 3;
		}
		else {
			long sum = 0;
			for (int i=1; i<n; i++) {
				sum += DP(i)*DP(n-i);
			}
			return sum;
		}
	}

}
