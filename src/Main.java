import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
//        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer str = new StringTokenizer(bfr.readLine());

        int[] cards = {2,1,3,4,1};
        solution(cards);
    }
    public static int[] solution(int[] numbers) {
        ArrayList<Integer> ar = new ArrayList<Integer>();
        for(int i=0; i<numbers.length; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                if(!ar.contains(i+j)) {
                    ar.add(numbers[i]+numbers[j]);
                }
            }
        }
        Collections.sort(ar);
        int[] answer = new int[ar.size()];
        for(int i=0; i<ar.size(); i++) {
            answer[i] = ar.get(i);
        }
        return answer;
    }
}
