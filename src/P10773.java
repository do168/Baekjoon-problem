package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;

public class P10773 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		int answer = 0;
		int n = Integer.parseInt(str.nextToken());	
		Stack<Integer> st = new Stack<Integer>();
		for(int i=0; i<n; i++) {
			str = new StringTokenizer(bfr.readLine());
			int temp = Integer.parseInt(str.nextToken());
			if(temp==0) {
				st.pop();
			}
			else
				st.push(temp);
		}
		Iterator it = st.iterator();	
		while(it.hasNext()) {
			answer += (Integer)it.next();
		}
		System.out.println(answer);
	}

}
