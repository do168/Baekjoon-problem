package Fighting;

import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class P9663 {
	static int answer=0;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		
		int N = Integer.valueOf(str.nextToken());
		int[] list= new int[N];
		
		
			dfs(list, 0);
		System.out.println(answer
				);
		
	}
	
	public static void dfs(int[] list, int current) {
		if (current==list.length) {
			answer++;
			return;
		}
		else {
			for (int i=0; i<list.length; i++) {
				if(isPossible(list, current, i)) {
					list[current] = i;
					dfs(list, current+1);
				}
			}
		}
	}
	
	public static boolean isPossible(int[] list, int current, int check) {
		for(int i=0; i<current; i++) {
			if(list[i]==check || Math.abs(i-current)==Math.abs(list[i]-check)) {
				return false;
			}
		}
		return true;
	}

}
