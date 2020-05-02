package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1074 {
	static int row = 0;
	static int col = 0;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		int N = Integer.parseInt(str.nextToken());
		row = Integer.parseInt(str.nextToken());
		col = Integer.parseInt(str.nextToken());
		int size = (int)Math.pow(2, N);
		z(0, 0, size);
	}

	static void z(int r, int c, int n) {
		if (n == 1) {

			if (r == row && c == col) 
				System.out.println(cnt);
			cnt++;
			return;

		} 
		n = n/2;
		{
			z(r, c, n);
			z(r, c+n,n);
			z(r+n, c, n);
			z(r+n, c+n, n);
		}
	}

}
