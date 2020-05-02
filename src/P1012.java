package BAEKJOON;

import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class P1012 {
	static int map[][];
	
	static int M;
	static int N;
	static int K;
	static int total=0;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		
		int test = Integer.valueOf(str.nextToken());
		for (int i=0; i<test; i++) {
			str = new StringTokenizer(bfr.readLine());
			M = Integer.valueOf(str.nextToken());
			N = Integer.valueOf(str.nextToken());
			K = Integer.valueOf(str.nextToken());
			map = new int[M][N];
			for (int x = 0; x<M; x++) {
				for(int y=0; y<N; y++) {
					map[x][y] = 0;
				}
			}
			for (int j=0; j<K; j++) {
				str = new StringTokenizer(bfr.readLine());
				int tmpx = Integer.valueOf(str.nextToken());
				int tmpy = Integer.valueOf(str.nextToken());
				map[tmpx][tmpy] = 1;
			}
		
			for (int k=0; k<M; k++) {
				for (int z=0; z<N; z++) {
					if (map[k][z] == 1) {
						
						total++;
						dfs(k, z);
						
					}
				}
			}
			System.out.println(total);
			total=0;
		}
		
	}
	
	public static void dfs(int x, int y) {
		
		map[x][y] = 0;
		for (int i=0; i<4; i++) {
			
			int tempx = x + dx[i];
			int tempy = y + dy[i];
			
			if (tempx >= 0 && tempx < M && tempy >= 0 && tempy < N) {
				if(map[tempx][tempy]==1) {
					dfs(tempx, tempy);
				}
			}
		}
	}

}