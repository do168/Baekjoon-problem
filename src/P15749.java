package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15749 {
	static int N;
	static int B;
	static int[] tile;
	static int[] b_d;
	static int[] b_s;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		N = Integer.parseInt(str.nextToken());
		B = Integer.parseInt(str.nextToken());
		str = new StringTokenizer(bfr.readLine());
		tile = new int[N];
		b_d = new int[B];
		b_s = new int[B];
		for (int i = 0; i < N; i++) {
			tile[i] = Integer.parseInt(str.nextToken());
		}
		for (int i = 0; i < B; i++) {
			str = new StringTokenizer(bfr.readLine());
			b_d[i] = Integer.parseInt(str.nextToken());
			b_s[i] = Integer.parseInt(str.nextToken());
		}
		dfs(0, 0);
	}

	static void dfs(int t, int b) {
		if(t==N-1) {
			System.out.println(b);
			System.exit(0);
		}
		else {
			if(isPossible(t, b)) {
				for (int i=1; i<=b_s[b]; i++) {
					if(isPossible(t+i,b)) {	
						dfs(t+i, b);
					}
				}
				dfs(t,b+1);
			}
			else {
				
				dfs(t, b+1);
			}
		}
	}

	static boolean isPossible(int t, int b) {
		if (tile[t] <= b_d[b]) {
			return true;
		} else
			return false;
	}
}
