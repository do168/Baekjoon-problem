package BAEKJOON;


import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class P2606 {
	static int[][] vertexMapBfs;
	static int[] vertexVisitBfs;
	static int C;
	static int cnt=0;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		C = Integer.valueOf(str.nextToken());
		str = new StringTokenizer(bfr.readLine());
		int Net = Integer.valueOf(str.nextToken());
		
		vertexMapBfs = new int[C+1][C+1];
		vertexVisitBfs = new int[C+1];
		
		for (int i=0; i<Net; i++) {
			str = new StringTokenizer(bfr.readLine());
			int a1 = Integer.valueOf(str.nextToken());
			int a2 = Integer.valueOf(str.nextToken());
			vertexMapBfs[a1][a2] = 1;
			vertexMapBfs[a2][a1] = 1;
		
	}
		bfs(1);
		if(C==1) {
			System.out.println(0);
		}
		else
		System.out.println(cnt);
}


	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		vertexVisitBfs[start]=1;
		while(!q.isEmpty()) {
			
			int now = q.remove();
			
			for (int i=1; i<=C; i++) {
					if(vertexMapBfs[now][i] == 0 || vertexVisitBfs[i] ==1) continue;
					q.add(i);
					vertexVisitBfs[i]=1;
					cnt++;
			}
			
		}
	}

}





