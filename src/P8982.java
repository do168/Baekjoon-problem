import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P8982 {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(bfr.readLine());
        int N = Integer.parseInt(str.nextToken());
        ArrayList<Node8982> ar1 = new ArrayList<>();
        ArrayList<Node8982> ar2 = new ArrayList<>();
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            str = new StringTokenizer(bfr.readLine());
            int num1 = Integer.parseInt(str.nextToken());
            int num2 = Integer.parseInt(str.nextToken());
            ar1.add(new Node8982(num1, num2));
        }


        str = new StringTokenizer(bfr.readLine());
        int M = Integer.parseInt(str.nextToken());
        for (int i = 1; i <= M; i++) {
            str = new StringTokenizer(bfr.readLine());
            int num1 = Integer.parseInt(str.nextToken());
            int num2 = Integer.parseInt(str.nextToken());
            int num3 = Integer.parseInt(str.nextToken());
            int num4 = Integer.parseInt(str.nextToken());
            ar2.add(new Node8982(num1, num2));
            ar2.add(new Node8982(num3, num4));
        }

        for(int i=0; i<ar2.size(); i+=2) {
            Node8982 nd1 = ar2.get(i);
            int left_row = nd1.row;
            int left_col = nd1.col;
            Node8982 nd2 = ar2.get(i+1);
            int right_row = nd2.row;
            int right_col = nd2.col;

            int cal_left_index = 0;
            int cal_left_row = 0;
            int cal_left_col = 0;
            int cal_right_index = 0;
            int cal_right_row = 0;
            int cal_right_col = 0;


            int left_index = 0;
            for(int j = 0; j<ar1.size(); j++) {
                Node8982 node = ar1.get(i);
                if(node.row == left_row && node.col == left_col){
                    left_index = j;
                    break;
                }
            }
            int right_index = 0;
            for(int j = 0; j<ar1.size(); j++) {
                Node8982 node = ar1.get(i);
                if(node.row == right_row && node.col == right_col){
                    right_index = j;
                    break;
                }
            }
            for(int j = left_index-1; j>=0; j--) {
                int angle_col = ar1.get(j).col;
                if(angle_col<left_col) {
                    cal_left_index = j+1;
                    break;
                }
            }
            for(int j = right_index+1; j<ar1.size(); j++) {
                int angle_col = ar1.get(j).col;
                if(angle_col<right_col) {
                    cal_right_index = j-1;
                    break;
                }
            }
            for(int z = left_index-1; z>=cal_left_index; z-=2) {
                int num1 = ar1.get(z).row;
                int num2 = ar1.get(z+1).row;
                int num3 = ar1.get(z).col;
                answer += ((num1 - num2)) * (num3 - left_col);
            }
            for(int z = right_index+1; z<=cal_right_index; z+=2) {
                int num1 = ar1.get(z).row;
                int num2 = ar1.get(z+1).row;
                int num3 = ar1.get(z).col;
                answer += ((num2 - num1)) * (num3 - right_col);
            }


        }
        System.out.println(answer);
    }
}

class Node8982 {
    int row;
    int col;

    Node8982(int row, int col) {
        this.row = row;
        this.col = col;
    }
}