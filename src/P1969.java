package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class P1969 {
	static int min = Integer.MAX_VALUE;
	static String answer = "";
	static int n = 0;
	static int m = 0;
	static char[] list = {'A', 'C', 'G', 'T'};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		n = Integer.parseInt(str.nextToken());
		m = Integer.parseInt(str.nextToken());
		String[] dnas = new String[n];
		for(int i=0; i<n; i++) {
			str = new StringTokenizer(bfr.readLine());
			dnas[i] = str.nextToken();
		}
		dfs(dnas, 0, 0, "");
		System.out.println(answer+"\n"+min);
	}
	static void dfs(String[] dnas, int index, int result, String answer_tmp) {
		if(index>=m) {
			if(result<min) {
				min = result;
				answer = answer_tmp;
				return;
			}
		}
		else {
			int idx = 0;
			int res = 0;
			for(int i=0; i<4; i++) {
				int temp = 0;
				for(int j=0; j<n; j++) {
					if(list[i] != dnas[j].charAt(index))
						temp++;
				}
				if(i==0)
					res = temp;
				else {
					if(temp<res) {
						res = temp;
						idx = i;
					}
				}
			}
			dfs(dnas, index+1, result+res, answer_tmp+list[idx]);
		}
	}
}