package BAEKJOON;
import java.io.*;
import java.util.*;
public class P16771 {
	static int[][] bucket;
	static boolean[][] isVisit;
	static ArrayList<Integer> union;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str;
		bucket = new int[2][10];
		isVisit = new boolean[2][10];
		union = new ArrayList<Integer>();
		for (int i=0; i<2; i++) {
			str = new StringTokenizer(bfr.readLine());
			for (int j=0; j<10; j++) {
				bucket[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		DFS(0, 0);
		HashSet<Integer> hash = new HashSet<Integer>(union);
		ArrayList<Integer> answer = new ArrayList<Integer>(hash);
		System.out.println(answer.size());
	}
	static void DFS(int d, int sum) {
		if(d==4) {
			union.add(sum);
			return;
		}
		if(d+2<=4) DFS(d+2, sum);
		int isOdd = d&1;
		for (int i=0;i<10;i++) {
			if(!isVisit[isOdd][i]) {
				isVisit[isOdd][i]=true;
				DFS(d+1, sum+bucket[isOdd][i]*(isOdd==1?1:-1));
				isVisit[isOdd][i]=false;
			}
		}
	}
}
