package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P9012 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		int T = Integer.parseInt(str.nextToken());
		for(int i=0; i<T; i++) {
			int count = 0;
			boolean flag = true;
			str = new StringTokenizer(bfr.readLine());
			String[] temp = str.nextToken().split("");
			for(String t : temp) {
				if(t.equals("(")) {
					count++;
				}
				else {
					count --;
				}
				if(count<0) {
					flag = false;
					break;
				}
			}
			if(count>0) flag = false;
			if(flag) 
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

}
