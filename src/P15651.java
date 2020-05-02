package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15651 {
	static int N;
	static int M;
	static int[] arr;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		arr = new int[M+1];
		sb = new StringBuilder();
		sb.append("");
		dfs(1);
		System.out.println(sb);
	}
	static void dfs(int m) {
		if(m == M+1) {
			for(int i=1; i<=M; i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		else {
			for(int i=1; i<=N; i++) {
				arr[m] = i;
				dfs(m+1);
			}
		}
		return;
	}
}
