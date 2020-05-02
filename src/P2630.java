package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2630 {
	static int[][] map;
	static int N;
	static int white = 0;
	static int blue = 0;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		N = Integer.parseInt(str.nextToken());
		map = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			str = new StringTokenizer(bfr.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		recur(1, N, 1, N);
		System.out.println(white+"\n"+blue);
	}
	
	static void recur(int start_row, int end_row, int start_col, int end_col) {
		int temp = map[start_row][start_col];
		boolean flag = true;
		out: for(int i = start_row; i<=end_row; i++) {
			for(int j = start_col; j<=end_col; j++) {
				if(map[i][j]!=temp) { flag = false; break out;}
			}
		}
		if(!flag) {
		int tmp_row = (start_row+end_row)/2;
		int tmp_col = (start_col+end_col)/2;
		recur(start_row, tmp_row, start_col, tmp_col);
		recur(tmp_row+1, end_row, start_col, tmp_col);
		recur(start_row, tmp_row, tmp_col+1, end_col);
		recur(tmp_row+1, end_row, tmp_col+1, end_col);
		return;
		}
		else {
			if(temp == 0) {
				white++;
				return;
			}
			else {
				blue ++;
				return;
			}
		}
	}
}
