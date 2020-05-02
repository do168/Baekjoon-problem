package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P14501 {
	static int max = Integer.MIN_VALUE;
	static int n = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		n = Integer.parseInt(str.nextToken());
		int[] t = new int[n + 1];
		int[] p = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			str = new StringTokenizer(bfr.readLine());
			t[i] = Integer.parseInt(str.nextToken());
			p[i] = Integer.parseInt(str.nextToken());
		}
		dfs(t, p, 1, 0);
		System.out.println(max);
	}

	static void dfs(int[] t, int[] p, int index, int result) {
		if (index <= n + 1) {
			max = Math.max(max, result);
		}
		for (int i = index; i <= n; i++) {
			dfs(t, p, i + t[i], result + p[i]);
		}
	}

}
