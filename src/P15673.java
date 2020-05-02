package BAEKJOON;
import java.util.*;
import java.io.*;
public class P15673 {
	static char[][] ttt;
	static String stepchar;
	static int one_ans=0;
	static int two_ans=0;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str;
		ttt = new char[3][3];
		for (int i=0; i<3; i++) {
			str = new StringTokenizer(bfr.readLine());
			String temp = str.nextToken();
			
			for (int j=0; j<3; j++) {
				ttt[i][j] = temp.charAt(j);
			}
		}
		for(char i='A'; i<='Z'; i++) {
			one_win(i);
		}
		for (char i='A'; i<='Z'; i++) {
			for(char j=(char)(i+1); j<='Z'; j++) {
				two_win(i, j);
			}
		}
		System.out.println(one_ans);
		System.out.println(two_ans);
	}
	static void one_win(char i) {
		if(ttt[0][0]==(i) && ttt[1][1]==(i) && ttt[2][2]==(i)) {one_ans++; return;}
		if(ttt[2][0]==(i) && ttt[1][1]==(i) && ttt[0][2]==(i)) {one_ans++; return;}
		
		for(int j=0; j<3; j++) {

			if(ttt[j][0]==(i) && ttt[j][1]==(i) && ttt[j][2]==(i)) {one_ans++; return;}
			if(ttt[0][j]==(i) && ttt[1][j]==(i) && ttt[2][j]==(i)) {one_ans++; return;}
		}
	}
	
	static void two_win(char i, char j) {
		if(check(i,j,ttt[0][0],ttt[1][1],ttt[2][2])) { two_ans++; return;}
		if(check(i,j,ttt[2][0],ttt[1][1],ttt[0][2])) { two_ans++; return;}
		
		for(int k=0; k<3; k++) {
			if(check(i,j,ttt[k][0],ttt[k][1],ttt[k][2])) {two_ans++; return;}
			if(check(i,j,ttt[0][k],ttt[1][k],ttt[2][k])) {two_ans++; return;}
		}
	}
	
	static boolean check(char i, char j, char tt1, char tt2, char tt3) {
		if(tt1!=(i)&&tt1!=(j)) return false;
		if(tt2!=(i)&&tt2!=(j)) return false;
		if(tt3!=(i)&&tt3!=(j)) return false;
		
		if (tt1!=(i)&& tt2!=(i)&&tt3!=(i)) return false;
		if (tt1!=(j)&& tt2!=(j)&&tt3!=(j)) return false;
		
		return true;
	}
	
	
	
}
