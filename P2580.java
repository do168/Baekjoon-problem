package BAEKJOON;


import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class P2580 {
	static int cnt=0;
	static int only=0;
	static int[][] map;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str;
		
		
		String need="";
		map = new int[9][9]; 
		for (int i=0; i<9; i++) {
			str = new StringTokenizer(bfr.readLine());
			for (int j=0; j<9; j++) {
				map[i][j] = Integer.valueOf(str.nextToken());
				if (map[i][j] ==0) {
					 need+=i;
					 need+=j;
					 cnt++;
				}
			}
		}
		
		dfs(need, 0);
		
		
		
	}
	
	public static void dfs(String need, int count) {
		
		if (count==cnt) {
			
			for(int i=0; i<9; i++) {
				for (int j=0; j<9; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			only++;
			
		}
		else {
			
			int i=Integer.parseInt(need.substring(2*count, 2*count+1));
			int j=Integer.parseInt(need.substring(2*count+1, 2*count+2));
			
			for (int k=1; k<=9; k++) {
				if(only==0) {
					
					if(isPossible(k, i, j)) {
						map[i][j] = k;
						count++;
						dfs(need, count);
						count--;
						map[i][j]=0;
					}
				}
			}
		}
	}
	
	public static boolean isPossible(int check, int row, int col) {
		for (int i=0; i<9; i++) {
			if(map[i][col]==check || map[row][i]==check) return false;
		}
		for (int i=3*(row/3); i<=(3*(row/3))+2; i++) {
			for (int j=3*(col/3); j<=(3*(col/3))+2; j++) {
				if(map[i][j] == check) return false;
			}
		}
	
	return true;
	}
	
}
