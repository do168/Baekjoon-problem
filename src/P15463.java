package BAEKJOON;
import java.util.*;
import java.io.*;
public class P15463 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str;
		Integer[][] bb = new Integer[3][4];
		for (int i =0; i<3; i++) {
			str = new StringTokenizer(bfr.readLine());
			for (int j=0; j<4; j++) {
				bb[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		int area0 = (bb[0][2] - bb[0][0]) * (bb[0][3]-bb[0][1]);
		int area1 = (bb[1][2] - bb[1][0]) * (bb[1][3]-bb[1][1]);
		int sum = area0+area1;
		int max_x = (bb[0][2]<bb[1][2]) ? 1 : 0;
		int min_x = (max_x>0) ? 0 : 1;
		int max_y = (bb[0][3]<bb[1][3]) ? 1 : 0;
		int min_y = (max_y>0) ? 0 : 1;
		int combinedarea = 
				((Math.min(bb[min_x][2], bb[2][2]) - Math.max(bb[min_x][0], bb[2][0])) * (Math.min(bb[min_x][3], bb[2][3]) - Math.max(bb[min_x][1], bb[2][1]))) + 
				((Math.min(bb[max_x][2], bb[2][2]) - Math.max(bb[max_x][0], bb[2][0])) * (Math.min(bb[max_x][3], bb[2][3]) - Math.max(bb[max_x][1], bb[2][1])));
		if (bb[max_x][2] <= bb[2][0] || bb[2][2]<=bb[min_x][0] || (bb[min_x][2]<=bb[2][0] && bb[2][2] <= bb[max_x][0])){
			System.out.println(sum);
			return;
		}
		if (bb[min_x][2]<=bb[2][0]) {
			combinedarea = ((Math.min(bb[max_x][2], bb[2][2]) - Math.max(bb[max_x][0], bb[2][0])) * (Math.min(bb[max_x][3], bb[2][3]) - Math.max(bb[max_x][1], bb[2][1])));
		}
		if ( bb[2][2] <= bb[max_x][0])
			combinedarea = ((Math.min(bb[min_x][2], bb[2][2]) - Math.max(bb[min_x][0], bb[2][0])) * (Math.min(bb[min_x][3], bb[2][3]) - Math.max(bb[min_x][1], bb[2][1])));
		if (bb[max_y][3] <= bb[2][1] || (bb[min_y][3]<=bb[2][1] && bb[2][3] <= bb[max_y][1]) || bb[2][3]<=bb[min_y][1]) {
			System.out.println(sum);
			return;
		}
		if (bb[min_y][3]<=bb[2][1])
			combinedarea = ((Math.min(bb[max_y][2], bb[2][2]) - Math.max(bb[max_y][0], bb[2][0])) * (Math.min(bb[max_y][3], bb[2][3]) - Math.max(bb[max_y][1], bb[2][1])));
		if (bb[2][3] <= bb[max_y][1])
			combinedarea = ((Math.min(bb[min_y][2], bb[2][2]) - Math.max(bb[min_y][0], bb[2][0])) * (Math.min(bb[min_y][3], bb[2][3]) - Math.max(bb[min_y][1], bb[2][1])));
		
		
		
		System.out.println(sum-combinedarea);
	}

}
